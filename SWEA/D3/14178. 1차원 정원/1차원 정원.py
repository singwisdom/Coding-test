# SWEA 14178번 : 1차원 정원
# 자료구조 & 알고리즘 : 단순한 계산문제, d를 통해 얼마나 물을 줄 수 있는지 확인하면 됨

tc = int(input())
for t in range(1,tc+1):
    n,d = map(int, input().split())
    spray = 2*d + 1 # 좌표 x에 분무기 놓으면 2d+1 만큼 물 줄 수 있음
    result = 0

    if n % spray == 0 : result = n // spray
    else : result = (n // spray) + 1

    print(f'#{t} {result}')