# SWEA 6190번 : 정곤이의 단조 증가하는 수
# 자료구조 & 알고리즘 : 문제 이해 못해서 시간 오래 걸림

def is_up(num):
    res = 0
    num_list = list(str(num)) # 여기는 내 생각으로 안 품 , 구글링해서 품
    for k in range(len(num_list)-1):
        if int(num_list[k]) > int(num_list[k+1]) : 
            res = False
            break
        else : res = True
    return res


tc = int(input())
for t in range(1,tc+1):

    n = int(input()) # 숫자 자리수
    num = list(map(int, input().split()))
    result = -1

    for i in range(n): # Ai * Aj 구하기
        for j in range(i+1,n) :
            calc = num[i] * num[j]
            if calc > result and is_up(calc) : # 단조 증가하는 수인지 판별
                result = calc             

    print(f'#{t} {result}') # 단조 증가하는 수 중, 최댓값 판별