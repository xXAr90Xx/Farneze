/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Alberto Perez
 */
import java.util.*;

public class ScopeManager {
    private Stack<Map<String, Compilador.VariableInfo>> scopes;

    public ScopeManager() {
        scopes = new Stack<>();
        // Inicializar con el ámbito global
        enterScope();
    }

    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    public void exitScope() {
        if (!scopes.isEmpty()) {
            scopes.pop();
        }
    }

    public void declare(String name, Compilador.VariableInfo info) {
        scopes.peek().put(name, info);
    }

    public Compilador.VariableInfo lookup(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Compilador.VariableInfo info = scopes.get(i).get(name);
            if (info != null) {
                return info;
            }
        }
        return null;
    }

    public boolean isInCurrentScope(String name) {
        return scopes.peek().containsKey(name);
    }

    public Map<String, Compilador.VariableInfo> getCurrentScope() {
        return scopes.peek();
    }

    public Map<String, Compilador.VariableInfo> getAllVariables() {
        Map<String, Compilador.VariableInfo> allVariables = new HashMap<>();
        for (Map<String, Compilador.VariableInfo> scope : scopes) {
            allVariables.putAll(scope);
        }
        return allVariables;
    }
}
 