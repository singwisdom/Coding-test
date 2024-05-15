# SWEA 3307번 : 최장 증가 부분 수열
# 알고리즘 & 자료구조 : DP /  문제 이해를 완전 이상하게 했다... 답 보고 풀었음

tc = int(input())
for t in range(1,tc+1):
    n = int(input()) # 수열의 길이
    num_list = list(map(int, input().split()))
    dp = [1] * n # dp[0]은 초기값이 1임

    for i in range(1,n):
        for j in range(i):
            if num_list[i] > num_list[j] : # i 보다 앞에 있는 숫자들을 비교하면서 작은 것을 만나면
                dp[i] = max(dp[i] , dp[j]+1)

    print(f'#{t} {max(dp)}')