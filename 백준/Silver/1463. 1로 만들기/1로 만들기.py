# 백준 1436번 : 1로 만들기
# https://www.acmicpc.net/problem/1463
# 다이나믹 프로그래밍으로 풀기

n = int(input())
d = [0 for i in range(n+1)]


for i in range(2,n+1):

    d[i] = d[i-1]+1


# 여기서 주의 >> if i//3 , elif i//2 으로 하면 안됨 
# >> (2와 3의 공배수가 입력될 경우, 둘 중 하나만 걸려서 최솟값을 구하게 되기 때문. 이럴 경우 2로 나뉘는거랑 3으로 나뉘는거 둘 다 계산되어야 함)
    if i%3 == 0 : 
        d[i] = min(d[i//3]+1, d[i])

    if i%2 == 0:  
        d[i] = min(d[i//2]+1, d[i])

print(d[n])