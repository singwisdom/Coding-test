# SWEA 1217번 : 거듭제곱
# 자료구조 & 알고리즘 : 재귀호출 사용하기

def sqrt(n,m):
    if m == 1 : return n # 마지막에 n 곱하기
    return n * sqrt(n,m-1)

for _ in range(10):
    tc = int(input())
    n,m = map(int, input().split()) # n,m 입력받음
    result = sqrt(n, m) # 함수 호출
    print(f'#{tc} {result}')