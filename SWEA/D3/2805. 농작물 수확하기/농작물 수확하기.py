# SWEA 2805번 : 농작물 수확하기
# 자료구조 & 알고리즘 : 인덱스 슬라이싱으로 접근

tc = int(input())

for t in range(1,tc+1):
    n = int(input())
    farm = list()
    for i in range(n): # 농장 배열 입력받기
        farm.append(list(map(int, str(input()))))

    center = n//2 # 농장의 중앙, 배열 인덱스 기준
    result = 0
    k = 0

    for i in reversed(range(center+1)): # for문 역순, 2,1,0 / k는 0,1,2 증가
        if i == center : 
            result += sum(farm[center][center-i:center+i+1])
        else : 
             result += sum(farm[center+k][center-i:center+i+1])
             result += sum(farm[center-k][center-i:center+i+1])
        k+=1

    print(f'#{t} {result}')