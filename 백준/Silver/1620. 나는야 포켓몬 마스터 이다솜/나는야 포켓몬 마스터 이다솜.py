# 백준 1620번 : 나는야 포켓몬 마스터 이다솜
# https://www.acmicpc.net/problem/1620
# 알고리즘 , 자료구조 : 딕셔너리 사용

import sys

n,m = map(int, input().split())
poketmon = dict()

for i in range(n):
    name = str(sys.stdin.readline().rstrip())
    if name not in poketmon :
        poketmon[i+1] = name # 딕셔너리에 포켓몬 이름 추가

# 딕셔너리를 뒤집어서 key와 value 자리를 바꿈
reverse_poketmon = dict(map(reversed, poketmon.items()))

# print(poketmon)
# print(reverse_poketmon)

for k in range(m):
    string = str(sys.stdin.readline().rstrip())
    if string.isalpha() : sys.stdout.write(str(reverse_poketmon[string])+"\n") # 숫자를 입력받았다면 이름을 출력
    elif string.isdigit() : sys.stdout.write(str(poketmon[int(string)])+"\n") # 이름을 입력받았다면 숫자를 출력 , int(string) 이거를 꼭 해줘야함