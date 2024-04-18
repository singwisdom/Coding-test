# 백준 10773번 : 제로
# https://www.acmicpc.net/problem/10773
# 알고리즘 : 덱으로 구현하기

from collections import deque
import sys

k = int(input())
q = deque()
sum = 0

for i in range(k):
    n = int(sys.stdin.readline().rstrip())
    if n == 0 :
        q.pop()
    else :
        q.append(n)

#print(q)

while q :
    sum += q.popleft()

print(sum)