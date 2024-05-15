# SWEA 15230번 : 알파벳 공부
# 알고리즘 & 자료구조 : 문자열 슬라이싱으로 비교 

tc = int(input())
for t in range(1,tc+1):
    alpha = 'abcdefghijklmnopqrstuvwxyz'
    string = str(input())
    count = 0

    for i in range(len(string)):
        if alpha[i:i+1] == string[i:i+1] : count += 1 # 순서와 알파벳이 동일하다면 카운트해주기
        else : break # 틀린 위치가 있다면 break로 빠져나오기

    print(f'#{t} {count}')