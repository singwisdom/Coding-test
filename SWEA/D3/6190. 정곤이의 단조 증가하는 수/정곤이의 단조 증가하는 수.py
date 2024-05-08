# SWEA 6190번 : 정곤이의 단조 증가하는 수
# 자료구조 & 알고리즘 :

def is_up(num):
    res = 0
    num_list = list(str(num))
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
    max_num = 0

    for i in range(n): # Ai * Aj 구하기
        for j in range(i+1,n) :
            calc = num[i] * num[j]
            if calc > max_num : # 단조 증가하는 수인지 판별
                result = is_up(calc)
                if result == True : 
                    max_num = max(calc, max_num)

    if max_num <= 0 :print(f'#{t} -1')
    else :print(f'#{t} {max_num}') # 단조 증가하는 수 중, 최댓값 판별