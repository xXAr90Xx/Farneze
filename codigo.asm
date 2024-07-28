org 100h
jmp start
section .data
_) dw 0
t1) dw 0
SI) dw 0
L1) dw 0
L2) dw 0
L3) dw 0
section .code
start:
mov dx, offset saludo
mov ah, 9
int 21h
mov ax, [numero1]
sub ax, [esDiaSoleado]
mov [t1)], ax
mov ax, [t1]
mov [SI)], ax
mov dx, offset "El número es mayor que 5"
mov ah, 9
int 21h
L1):
cmp MAYOR, 0
je L2)
jmp L3)
L2):
jmp L1)
L3):
mov dx, offset "El resultado es:"
mov ah, 9
int 21h
mov dx, offset resultado
mov ah, 9
int 21h
mov ah, 4Ch
int 21h
