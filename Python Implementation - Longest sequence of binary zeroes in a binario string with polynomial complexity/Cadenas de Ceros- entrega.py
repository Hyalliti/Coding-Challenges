# Complejidad Polinómica

M = [0,5,1041,32,15]
H = [] # Cadena binaria


def dec2bin(N,H):
  if N > 1:
    H.append(N%2)
    N = N//2
    dec2bin(N,H)
  elif N == 1:
    H.append(1)
  if H == []:
    H.append(0)

def solution(N):
   
  # Filtra casos menores a 9
  if N < 9:
    if N == 5:
      print("Binary Gap is:", 1)
    else: 
      print("Binary Gap is:", 0)

  else:
    H = []
    P = []
    gap = 0

    dec2bin(N,H)
    H = H[::-1]
    H = ''.join(map(str, H))
    cadena_zero = ['0']
    
    # Revisa la secuencia de 'O's encontrados en H (dec2bin) para obtener el Binary Gap.

    for i in range(len(H)):
      cadena_zero.append(cadena_zero[i] + '0')
    for i in range(len(cadena_zero)):
      P.append(H.find(cadena_zero[i]))
    for i in P:
      if i == 0:
        gap = 0
      if i > 0:
        gap += 1
      elif i == -1: 
        break

  # gap: Siempre será +1 del indice de P correspondiente, corresponde al Binary Gap del digito.

  # Si la cadena no le considera como substring válida, elige la substring previa
    if H.find(cadena_zero[gap-1]) == 1:
      print("Binary Gap is:", gap)
    else:
      for i in range(gap):
        if P[i] == P[i+1]:
          gap = len(cadena_zero[i])
          break
        elif P[i] == 0:
          gap = 0
        else:
          gap+= 1
      if gap == 0:
        print("Binary Gap is:", gap)
      else:
        print("Binary Gap is:", gap-1)

