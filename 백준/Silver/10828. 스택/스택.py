import sys

# 백준 : 10828번 (스택)

def push(x):
    stack.append(x)

def pop():
    if stack : num = stack.pop() 
    else : num = -1
    return num

def size():
    sys.stdout.write(str(len(stack))+'\n')

def empty():
    if len(stack) == 0 : emp = 1
    else : emp  = 0
    return emp 

def top():
    if stack : 
        num = stack.pop()
        stack.append(num)
    else : num = -1
    sys.stdout.write(str(num)+'\n')



n = int(sys.stdin.readline())
stack = list()
act = ['push','pop','size','empty','top']

for i in range(n):
    word = str(sys.stdin.readline().strip())

    if word[0:4] == act[0] : # push 
        x = int(word[5:])
        push(x)
        
    elif word == act[1]:  # pop
        sys.stdout.write(str(pop())+'\n')

    elif word == act[2]: # size
        size()

    elif word == act[3] : # empty
        sys.stdout.write(str(empty())+'\n')
    
    else : # top
        top()
