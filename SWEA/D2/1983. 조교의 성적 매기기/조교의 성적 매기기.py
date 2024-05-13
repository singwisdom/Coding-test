# SWEA 1983번 : 조교의 성적 매기기
# 알고리즘 & 자료구조 :

hakjum = ['A+','A0','A-','B+','B0','B-','C+','C0','C-','D0']
tc = int(input())
for t in range(1,tc+1):
    res = 0
    n,k = map(int, input().split()) # N: 학생 수, K: 학생의 번호
    score = list()

    for i in range(n): # 성적 계산
        mid, final, task = map(int, input().split())
        tmp = mid*0.35 + final*0.45 + task*0.2
        score.append(tmp)
        if i == k-1: find = tmp
    score.sort(reverse=True) # 총점 정렬
    indx = score.index(find) # k학생의 인덱스 찾기


    same = int(n / 10) # 동일한 평점 몇명까지 가능한지 계산
    res = hakjum[indx // same]

    print(f'#{t} {res}')