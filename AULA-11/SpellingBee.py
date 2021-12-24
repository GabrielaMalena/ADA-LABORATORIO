def palabraMatching(palabras, letrasForma):
    for letras in palabras:
        if letras not in letrasForma:
            return False

    return True


letrasForma = input()
primeraLetra= letrasForma[0]

numeroPalabrasDiccionario = int(input())
for _ in range(numeroPalabrasDiccionario):
    diccionario = input()
    if len(diccionario) < 4:
        continue

    if primeraLetra not in diccionario:
        continue

    if palabraMatching(diccionario, letrasForma):
        print(diccionario)
