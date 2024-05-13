# 백준 2503번 : 숫자야구
# 알고리즘 & 자료구조 : 조합으로 1~9 의 숫자를 넣은 다음, 영수의 질문에 대한 답과 해당 숫자가 맞는지 확인
# 처음에 못 푼이유 : 사람의 뇌 알고리즘으로 적으려고 해서 그럼.. 걍 브루트포스처럼 숫자를 다 적고 스트라이크와 볼의 개수가 맞는지 확인하면 되는데 ㅜㅜ
# 어렵게 생각해서 풀어서 그럼....

from itertools import permutations

n = int(input())
num_list = list(permutations(['1','2','3','4','5','6','7','8','9'],3))

for i in range(n):
    num, s, b = map(int, input().split())
    num = list(str(num)) # 문자열로 다시 변환
    rmcnt = 0
    for j in range(len(num_list)):
        j -= rmcnt
        s_n = b_n = 0
        for k in range(3):
            if num_list[j][k] == num[k]: s_n += 1
            elif num[k] in num_list[j]: b_n +=1

        if s_n != s or b_n != b :
            num_list.remove(num_list[j])
            rmcnt += 1

print(len(num_list))