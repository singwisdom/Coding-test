tc = int(input())
for t in range(1,tc+1):
    k = int(input()) - 1
    res = 0

    while k>0:
        # k가 홀수라면 -1을 빼고 2를 나눠줌, 규칙 : 홀수의 경우 f(2n+1) = f(n)
        if k % 2 == 1 : k = (k-1) // 2

        if k % 4 == 0 :  # 이 수가 4의 배수라면 k의 인덱스는 0
            res = 0
            break
        elif k % 2 == 0 : # 이 수가 2의 배수라면 k의 인덱스는 1
            res = 1
            break

    print(f'#{t} {res}')