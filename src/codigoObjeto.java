import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class codigoObjeto {
    private Map<String, String> variables = new HashMap<>();
    private int labelCount = 0;

    public List<String> generateCode(List<String> cuadruplos) {
        List<String> codigoObjeto = new ArrayList<>();
        codigoObjeto.add("org 100h");
        codigoObjeto.add("jmp start");
        codigoObjeto.add("section .data");
        
        procesarVariables(cuadruplos);
        for (String var : variables.keySet()) {
            codigoObjeto.add(var + " dw 0");
        }
        
        codigoObjeto.add("msg_alta db 'Elevacion alta: $'");
        codigoObjeto.add("msg_baja db 'Elevacion baja: $'");
        codigoObjeto.add("msg_analisis db 'Analisis completado$'");
        
        codigoObjeto.add("section .code");
        codigoObjeto.add("start:");
        
        for (String cuad : cuadruplos) {
            String[] parts = cuad.substring(1, cuad.length() - 1).split(", ");
            if (parts.length == 0) continue;
            
            switch (parts[0]) {
                case "=":
                    if (parts.length >= 4) generarAsignacion(codigoObjeto, parts);
                    break;
                case "PRINT":
                    if (parts.length >= 2) generarImpresion(codigoObjeto, parts);
                    break;
                case "IF":
                    if (parts.length >= 4) generarCondicion(codigoObjeto, parts);
                    break;
                case "GOTO":
                    if (parts.length >= 2) codigoObjeto.add("jmp " + parts[1]);
                    break;
                case "LABEL":
                    if (parts.length >= 2) codigoObjeto.add(parts[1] + ":");
                    break;
                case "RESTA":
                    if (parts.length >= 4) generarResta(codigoObjeto, parts);
                    break;
            }
        }
        
        codigoObjeto.add("mov ax, 4C00h");
        codigoObjeto.add("int 21h");
        
        agregarFuncionPrintNum(codigoObjeto);
        
        return codigoObjeto;
    }
    
    private void procesarVariables(List<String> cuadruplos) {
        for (String cuad : cuadruplos) {
            String[] parts = cuad.substring(1, cuad.length() - 1).split(", ");
            if (parts.length >= 4 && parts[0].equals("=")) {
                String var = parts[3];
                if (!variables.containsKey(var)) {
                    variables.put(var, "dw 0");
                }
            }
        }
    }
    
    private void generarAsignacion(List<String> codigoObjeto, String[] parts) {
        String valor = parts[1];
        String variable = parts[3];
        if (esNumero(valor)) {
            codigoObjeto.add("mov word [" + variable + "], " + valor);
        } else {
            codigoObjeto.add("mov ax, [" + valor + "]");
            codigoObjeto.add("mov [" + variable + "], ax");
        }
    }
    
    private void generarImpresion(List<String> codigoObjeto, String[] parts) {
        if (parts[1].equals("'Elevación alta: '")) {
            codigoObjeto.add("mov dx, offset msg_alta");
        } else if (parts[1].equals("'Elevación baja: '")) {
            codigoObjeto.add("mov dx, offset msg_baja");
        } else if (parts[1].equals("'Análisis completado'")) {
            codigoObjeto.add("mov dx, offset msg_analisis");
        }
        codigoObjeto.add("mov ah, 9");
        codigoObjeto.add("int 21h");
        if (parts.length > 2) {
            codigoObjeto.add("mov ax, [" + parts[2] + "]");
            codigoObjeto.add("call print_num");
        }
    }
    
    private void generarCondicion(List<String> codigoObjeto, String[] parts) {
        if (parts.length < 4) return;
        String condicion = parts[1];
        String etiquetaTrue = parts[3];
        String etiquetaFalse = generateLabel();
        String[] condParts = condicion.split(">");
        if (condParts.length < 2) return;
        codigoObjeto.add("mov ax, [" + condParts[0].trim() + "]");
        codigoObjeto.add("cmp ax, " + condParts[1].trim());
        codigoObjeto.add("jg " + etiquetaTrue);
        codigoObjeto.add("jmp " + etiquetaFalse);
        codigoObjeto.add(etiquetaFalse + ":");
    }
    
    private void generarResta(List<String> codigoObjeto, String[] parts) {
        codigoObjeto.add("mov ax, [" + parts[1] + "]");
        codigoObjeto.add("sub ax, " + parts[2]);
        codigoObjeto.add("mov [" + parts[3] + "], ax");
    }
    
    private String generateLabel() {
        return "L" + (++labelCount);
    }
    
    private boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private void agregarFuncionPrintNum(List<String> codigoObjeto) {
        codigoObjeto.add("print_num:");
        codigoObjeto.add("    push ax");
        codigoObjeto.add("    push bx");
        codigoObjeto.add("    push cx");
        codigoObjeto.add("    push dx");
        codigoObjeto.add("    mov bx, 10");
        codigoObjeto.add("    xor cx, cx");
        codigoObjeto.add("print_loop:");
        codigoObjeto.add("    xor dx, dx");
        codigoObjeto.add("    div bx");
        codigoObjeto.add("    push dx");
        codigoObjeto.add("    inc cx");
        codigoObjeto.add("    test ax, ax");
        codigoObjeto.add("    jnz print_loop");
        codigoObjeto.add("print_loop2:");
        codigoObjeto.add("    pop dx");
        codigoObjeto.add("    add dl, '0'");
        codigoObjeto.add("    mov ah, 2");
        codigoObjeto.add("    int 21h");
        codigoObjeto.add("    loop print_loop2");
        codigoObjeto.add("    mov dl, 13");
        codigoObjeto.add("    mov ah, 2");
        codigoObjeto.add("    int 21h");
        codigoObjeto.add("    mov dl, 10");
        codigoObjeto.add("    mov ah, 2");
        codigoObjeto.add("    int 21h");
        codigoObjeto.add("    pop dx");
        codigoObjeto.add("    pop cx");
        codigoObjeto.add("    pop bx");
        codigoObjeto.add("    pop ax");
        codigoObjeto.add("    ret");
    }
}