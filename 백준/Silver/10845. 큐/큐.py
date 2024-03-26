####################################
# 백준 10845번 : 큐

import sys
import queue 


# 정수 x를 큐에 넣는 연산
def push(x): 
    my_queue.put(x)


# 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력.
# 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
def pop():
    if my_queue.qsize() == 0 : x = -1
    else : x = my_queue.get()
    sys.stdout.write(str(x)+'\n')


# 큐에 들어있는 정수의 개수 출력
def size():
    sys.stdout.write(str(my_queue.qsize())+'\n')


# 큐가 비어있으면 1, 아니면 0을 출력
def empty():
    if my_queue.qsize() == 0 : sys.stdout.write(str(1)+'\n')
    else : sys.stdout.write(str(0)+'\n')


# 큐에 가장 앞에 있는 정수를 출력, 큐가 비어있으면 1을 출력
def front():
    if my_queue.qsize() == 0 : sys.stdout.write(str(-1)+'\n')
    else : 
        x = my_queue.queue[0]
        sys.stdout.write(str(x)+'\n')

# 큐에 가장 뒤에 있는 정수를 출력, 큐가 비어있으면 -1을 출력
def back():
    if my_queue.qsize() == 0 : sys.stdout.write(str(-1)+'\n')
    else :
        x = my_queue.queue[-1]
        sys.stdout.write(str(x)+'\n')



# main 코드 
        
n = int(sys.stdin.readline().strip())
my_queue = queue.Queue()

for i in range(n):
    word = sys.stdin.readline().strip()

    if word[0:4] == 'push' :
        x = int(word[5:])
        push(x)
    elif word == 'pop': pop()
    elif word == 'size' : size()
    elif word == 'empty' : empty()
    elif word == 'front' : front()
    else : back()

####################################