# SWEA 5948번 : 새샘이의 7-3-5 게임
# 자료구조 & 알고리즘 : 단순하게 조합으로 !

tc = int(input())
for t in range(1,tc+1):

    num = list(map(int, input().split()))
    add_num = list()

    for i in range(7):
        for j in range(i+1,7):
            for k in range(j+1,7):
                add_num.append(num[i] + num[j] + num[k])

    set_add = set(add_num) # set으로 중복 숫자 제거
    add_num = list(set_add) # 다시 리스트로 변환
    add_num.sort(reverse=True) # 내림차순으로 정렬

    print(f'#{t} {add_num[4]}')