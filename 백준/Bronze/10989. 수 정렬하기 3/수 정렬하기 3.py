# 백준 10989번 : 수 정렬하기 3
# https://www.acmicpc.net/problem/10989
# 파이썬의 list.append()는 공간을 많이 잡아먹음 => 메모리 재할당으로 인함
# velog 참고 : https://velog.io/@cbkyeong/%EB%B0%B1%EC%A4%8010989%EC%88%98%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B03

import sys

n = int(input())
num_list = [0] * 10001

for i in range(n):
    x = int(sys.stdin.readline().strip())
    num_list[x] +=1 

# 10,000 이하의 수만 입력되므로, 해당 숫자가 몇번 나왔는지 리스트에 저장 후 반복문으로 출력
for j in range(len(num_list)) :
    if num_list[j] == 0 : pass
    else :
        for k in range(num_list[j]) :
            sys.stdout.write(str(j)+'\n')