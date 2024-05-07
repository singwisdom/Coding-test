# SWEA 1204번 : 최빈수 구하기
# 알고리즘 & 자료구조 : 딕셔너리

tc = int(input())
for _ in range(1,tc+1):
    num = int(input())
    score = dict()
    std = list(map(int, input().split())) # 학생들 점수 입력

    for i in std : # 점수에 해당하는 인덱스에 저장
        if i not in score : score[i] = 1
        else : score[i] += 1

    # 딕셔너리에서 max 값 구하기 (max가 여러개일때)
    max_num = [k for k,v in score.items() if max(score.values()) == v] 

    print(f'#{num} {max(max_num)}')