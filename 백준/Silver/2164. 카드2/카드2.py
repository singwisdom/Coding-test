# 백준 2164번 : 카드 2
# https://www.acmicpc.net/problem/2164

from collections import deque

n = int(input())
result = 0
num = 0

my_queue = deque()

for i in range(1,n+1) : #큐에 숫자 순서대로 집어넣기
    my_queue.append(i)
   

while len(my_queue) != 1 :
    
    my_queue.popleft()
    num = my_queue.popleft()
    my_queue.append(num)
    
print(my_queue.popleft())