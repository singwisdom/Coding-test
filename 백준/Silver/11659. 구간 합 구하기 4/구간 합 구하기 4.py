# 백준 11659번 : 구간 합 구하기
# 알고리즘 & 자료구조 : DP를 이용하면 될 것 같은데 ! => 누적합을 구해서 구간별로 빼주기만 하면 됨

import sys

n,m = map(int, sys.stdin.readline().rstrip().split()) # n: 수의 개수, m: 합을 구해야 하는 횟수
num_lst = list(map(int, sys.stdin.readline().rstrip().split()))
prefix = [0 for _ in range(n+1)]
prefix[1] = num_lst[0]

for k in range(2,n+1):
    prefix[k] = prefix[k-1] + num_lst[k-1]

for k in range(m):
    i,j = map(int, sys.stdin.readline().rstrip().split())
    res = prefix[j] - prefix[i-1] # 원래는 prefix[j] - prefix[i] + s[i] , 여기서 i랑 j는 1부터 시작이기 때문에 -1씩 더 해야함
    sys.stdout.write(str(res)+'\n')
