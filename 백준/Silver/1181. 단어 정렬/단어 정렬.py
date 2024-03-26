# 백준 1181번 : 단어 정렬
# 나의 풀이 >> set으로 중복제거를 하고 list에 글자 수대로 인덱스별로 저장 후, 정렬을 하기

import sys

num = int(input())
word = set()
word_list = [[] for i in range(51)]
word_len = 0 # 글자수 길이

for i in range(num):
    word.add(sys.stdin.readline().strip())

for j in word :
    word_len = len(j)
    word_list[word_len].append(j)
    word_list[word_len].sort()


for row in word_list:
    # 튜플을 문자열로 변환하여 줄바꿈으로 출력
    if row == [] : pass # 빈 리스트면 출력하지 않음
    else: 
        print('\n'.join(row))
