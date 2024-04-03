# 백준 10814번 : 나이순 정렬 
# https://www.acmicpc.net/problem/10814
#=============> 그냥 버블정렬 구현하면 시간 매우 오래 걸림.. stable sort 라는 것이 있음 ! 

import sys

num = int(input())
member = list()

for i in range(num): # 리스트에 입력
    age, name = map(str, sys.stdin.readline().split())
    age = int(age)
    member.append([age,name])

member.sort(key = lambda x:x[0])

# 출력
for i in range(len(member)) :
    print("{} {}".format(member[i][0], member[i][1]))
