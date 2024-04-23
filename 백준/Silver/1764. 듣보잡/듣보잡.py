# 백준 1764번 : 듣보잡
# https://www.acmicpc.net/problem/1764
# 자료구조, 알고리즘 : set()을 이용하여 교집합 구하기

import sys

not_listen = set()
not_hear = set()
n,m = map(int, input().split())

for i in range(n):
    not_listen.add(sys.stdin.readline().rstrip())

for j in range(m):
    not_hear.add(sys.stdin.readline().rstrip())

listen_hear = list(not_listen & not_hear) # 교집합으로 듣보잡 구하기
listen_hear.sort() # 명단 정렬

print(len(listen_hear)) # 명단 수 출력
for k in listen_hear :
    sys.stdout.write(str(k)+"\n")