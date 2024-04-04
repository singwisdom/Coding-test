# 백준 9012번 : 괄호
# https://www.acmicpc.net/problem/9012
# 자료구조 : 스택 사용 >> 다시 공부하기
# 풀이 : ( 나올 경우 스택에 넣음, ) 나올 경우 스택에서 pop 
# ==> 마지막에 스택에 아무것도 없다면 YES 스택에 남아있는게 있다면 NO


import sys

n = int(input())
vps = list()
check = True

for i in range(n):

    string = str(input())

    for exp in string :

        if exp == "(" : vps.append("(")
        elif exp == ")" : 
            if len(vps) == 0 :
                check = False
                break
            else : vps.pop()

    if check == True and len(vps) == 0 : sys.stdout.write("YES\n")
    elif check == False or len(vps) != 0 : sys.stdout.write("NO\n")

    # 스택, check 변수들 모두 초기화
    vps.clear()
    string = ""
    check = True

