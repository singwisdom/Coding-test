# SWEA 1215번 : 회문
# 자료구조 & 알고리즘 : 스택 이용하면 될 듯? (너무 코드 복잡함)
## ==> 문자열 슬라이싱으로 바꾸기

for tc in range(1,11):
    n = int(input()) # 회문 길이
    count = 0
    col_list = [[] for x in range(8)]

    for i in range(8):  
        line  = str(input()) # 8줄 글자판 입력받음

        for j in range(8): # 세로 회문 저장
            col_list[j].append(line[j]) 

        # 가로 회문 세기
        for k in range(0,(8-n+1)) :
            reverse = ''.join(reversed(line[k:k+n]))
            if line[k:k+n] == reverse : count+=1

    # 세로 회문 세기
    for i in range(8):
        for k in range(0,(8-n+1)) :
            string = ''.join(col_list[i][k:k+n])
            reverse = ''.join(reversed(string))
            if string == reverse : count+=1 

    print(f'#{tc} {count}')