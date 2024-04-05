# 백준 2839번 : 설탕배달
# https://www.acmicpc.net/problem/2839

n = int(input())
sugar = [-1] * (5001)

# 초기값 구하기 : 단, 정확하게 N킬로를 만들 수 없다면 -1 출력
sugar[3] = 1
sugar[5] = 1
sugar[6] = 2

for i in range(8,n+1):

    if sugar[i-3] == -1 : sugar[i] = sugar[i-5]+1
    elif sugar[i-5] == -1 : sugar[i] = sugar[i-3]+1
    else : sugar[i] = min(sugar[i-3]+1, sugar[i-5]+1)

    if i%3 == 0 : sugar[i] = min(sugar[i], sugar[i-3]+1)
    if i%5 == 0 : sugar[i] = min(sugar[i], sugar[i-5]+1)
    

print(sugar[n])