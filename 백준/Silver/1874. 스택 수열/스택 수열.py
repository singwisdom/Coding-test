
# 백준 1874번 : 스택 수열
# https://www.acmicpc.net/problem/1874

import sys

n = int(input())

stack = list()
max_num = 1
string = ""

for i in range(n):
    num = int(sys.stdin.readline().rstrip())
    is_okay = True

    # push일 경우
    if len(stack)== 0 or stack[-1] < num:
        for j in range((num-max_num)+1):
            stack.append(max_num)
            max_num += 1
            string +="+\n"
        stack.pop() # 해당 수가 들어오면 무조건 pop
        string +="-\n"
        
    # pop일 경우
    elif stack[-1] == num :
        stack.pop()   
        string +="-\n"

    # 수열이 아닌 경우
    elif stack[-1] != num :
        print("NO")
        is_okay = False
        break
        

if is_okay == True:
    sys.stdout.write(string)
