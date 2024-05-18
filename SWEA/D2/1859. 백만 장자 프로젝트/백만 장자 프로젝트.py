# SWEA 1859번 : 백만 장자 프로젝트
# 알고리즘 & 자료구조 : 뒤에서 부터 접근하기 !
# 뒤에서 부터 접근하면서 최대값을 갱신해준다, 최대값보다 더 큰 값을 만났을 경우, 그동안 사들인 물건을 다 팔고 이윤을 남겨야함

tc = int(input())
for t in range(1,tc+1):
    n = int(input())
    day = list(map(int, input().split()))
    buy = list()
    money = 0
    max_num  = day[-1]

    for i in range(1,n):
        if max_num > day[-1-i] :buy.append(day[-1-i]) # 현재 판매값이 최대 판매값보다 작다면, 사들인다.
        else : # 현재 판매값이 최대 판매값보다 더 크다면, 그동안 사들인거를 팔아야함
            money += (max_num * len(buy)) - sum(buy)
            buy.clear()
        max_num = max(day[-1-i], max_num)

    if len(buy) > 0 : money += (max_num * len(buy)) - sum(buy)
    print(f'#{t} {money}')