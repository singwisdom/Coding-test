# SWEA 1228번 : 암호문 1
# 자료구조 & 알고리즘 : 문자열, 덱

from collections import deque

def I(x,y,s):
    for i in range(y):
        code.insert(x+i,s[i])

for i in range(10):
    n = int(input()) # 암호문 길이
    code = deque(list(map(str, input().split()))) # 원본 암호문
    m = int(input()) # 명령어 개수
    string = list(map(str, input().split())) # 입력된 명령어

    new_string = list()

    for j in string :
        if j.isalpha() : # 명령어가 알파벳인 경우
            if len(new_string) != 0 : # 이전에 저장된 명령문 함수 전달 후 초기화
                I(int(new_string[1]),int(new_string[2]),new_string[3:])   
                new_string.clear()
        new_string.append(j)
    I(int(new_string[1]),int(new_string[2]),new_string[3:]) # 마지막 명령문 함수 전달

    result = ""
    for num in range(10) :
        result += str(code[num])+" "

    print(f'#{i+1} {result}')