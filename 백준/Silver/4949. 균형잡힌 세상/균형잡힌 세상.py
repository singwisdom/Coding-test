# 백준 4949번 : 균형잡힌 세상
# https://www.acmicpc.net/problem/4949
# 알고리즘 : 스택으로 구현

import sys

vps = list()


while(True) :

    string  = str(sys.stdin.readline().rstrip())
    if string == "." : break

    check = True
    exp =""
    exp2 =""

    for exp in string :
        if exp == "(" or exp == "[" : # 왼쪽 괄호가 나올 경우 stack에 push
            vps.append(exp)

        if exp == ")" : # 닫는 괄호가 나올 경우
            if len(vps) != 0 : # 스택이 비었는지 확인
                exp2 = str(vps.pop())
                if exp2 != "(" :  check = False
            else : check =  False

        if exp == "]" : # 닫는 괄호가 나올 경우
            if len(vps) != 0 : # 스택이 비었는지 확인
                exp2 = str(vps.pop())
                if exp2 != "[" :  check = False
            else : check =  False

    if check == True and len(vps) == 0 : sys.stdout.write("yes\n")
    elif check == False or len(vps) !=0 : sys.stdout.write("no\n")

    vps.clear() # 스택 초기화

