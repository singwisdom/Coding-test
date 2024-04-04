# 백준 11866번 : 요세푸스 문제 0
# https://www.acmicpc.net/problem/11866
# 나의 풀이 >> 리스트로 값 할당 후, 순환하면서 제거 (pop은 시간 오래 걸리므로 0으로 만들기)

import sys

n, k = map(int, input().split()) # N명, K번째 제거
num_list = list()
result = list()

for i in range(1,n+1):
    num_list.append(i)

count = 0 # K번째인지 계산하기 위한 변수

while len(result) != n :

    for j in range(len(num_list)) :

        if num_list[j]!=0 : 
            count += 1

            if count == k :
                result.append(num_list[j])
                # print("빠진 변수 :{}".format(num_list[j]))
                num_list[j] = 0
                count = 0

        
output_str = "<" + ", ".join(map(str, result)) + ">"
print(output_str)
       