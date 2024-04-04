# 백준 10866번 : 덱
# https://www.acmicpc.net/problem/10866


import sys
from collections import deque

def push_front(x):
    my_deque.appendleft(x)

def push_back(x):
    my_deque.append(x)

def pop_front():
    if len(my_deque) == 0 : sys.stdout.write("-1\n")
    else : sys.stdout.write(str(my_deque.popleft())+"\n")

def pop_back():
    if len(my_deque) == 0 :sys.stdout.write("-1\n")
    else : sys.stdout.write(str(my_deque.pop())+"\n")

def size():
    sys.stdout.write(str(len(my_deque))+"\n")

def empty():
    if len(my_deque) != 0 : sys.stdout.write("0\n")
    else : sys.stdout.write("1\n")

def front():
    if len(my_deque) == 0 : sys.stdout.write("-1\n")
    else :
        num = my_deque[0]
        sys.stdout.write(str(num)+"\n")

def back():
    if len(my_deque) == 0 : sys.stdout.write("-1\n")
    else :
        num = my_deque[-1]
        sys.stdout.write(str(num)+"\n")



n = int(input())
my_deque = deque()

for i in range(n):
    word = sys.stdin.readline().strip()

    if word[0:9] == 'push_back' : push_back(word[10:])
    elif word[0:10] == 'push_front' : push_front(word[11:])
    elif word == 'front' : front()
    elif word == 'back' : back()
    elif word == 'size' : size()
    elif word == 'empty' : empty()
    elif word == 'pop_front' : pop_front()
    elif word == 'pop_back' : pop_back()