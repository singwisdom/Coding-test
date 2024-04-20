# 백준 11723번 : 집합
# https://www.acmicpc.net/problem/11723
# 자료구조 : set 사용

import sys

def add(num): # S에 x를 추가
    s.add(num)

def remove(num): # S에 x 제거
    if num in s: s.remove(num)

def check(num): # S에 x가 있는지 확인
    if num in s: sys.stdout.write("1\n")
    else : sys.stdout.write("0\n")

def toggle(num): # S에 x가 있으면 제거, 없으면 추가
    if num in s: s.remove(num)
    else : s.add(num)

def all():
    global s # 할당전에 참조되는 변수이기 때문
    s.clear()
    s = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}

def empty(): # S를 공집합으로 바꿈
    s.clear()

s = set()
m = int(input())

for i in range(m):
    string = sys.stdin.readline().rstrip()

    if string[0:3] == "add" : add(int(string[4]))
    elif string[0:6] == "remove" : remove(int(string[7]))
    elif string[0:5] == "check" : check(int(string[6]))
    elif string[0:6] == "toggle" : toggle(int(string[7]))
    elif string == "all" : all()
    elif string == "empty" : empty()

    #print(s)