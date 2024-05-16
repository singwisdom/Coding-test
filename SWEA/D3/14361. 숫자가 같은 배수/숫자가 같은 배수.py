# SWEA 14361번 : 숫자가 같은 배수
# 알고리즘 & 자료구조 : 숫자가 7자리가 최대니, 순열로 풀어서 완탐하면 될 것 같음

from itertools import permutations

def is_possible(permu, num_list):
    for i in range(len(permu)):
        if permu[i][0] > num_list[0] : # 2배수부터 계산하는 것이므로 (순열 리스트 앞 자리가 원래 숫자 첫번째 자리보다 작으면 비교 안해도 됨)
            tmp = ''
            for j in range(len(permu[i])) :
                tmp += permu[i][j] # 순열을 다 더해준다.
            if int(tmp) % num == 0 : return 'possible'
    return 'impossible' # 다 돌았는데도 불가능할때

tc = int(input())
for t in range(1,tc+1):
    num = int(input())
    num_list = list(str(num)) # 배열에 각 숫자 저장
    permu = list(permutations(num_list, len(num_list)))

    res = is_possible(permu, num_list)
    print(f'#{t} {res}')