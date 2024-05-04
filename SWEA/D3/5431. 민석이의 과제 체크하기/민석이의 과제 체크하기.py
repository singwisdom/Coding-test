# SWEA 5431번 : 민석이의 과제 체크하기
# 자료구조 & 알고리즘 : set 차집합 풀기

tc = int(input())
for num in range(1,tc+1):
    n, k = map(int, input().split())
    student = set()

    for i in range(1,n+1): # 전체 학생 번호 저장
        student.add(i)

    # 제출한 학생 번호 저장
    submit_std = set(map(int, input().split()))

    # 차집합을 이용해서 제출하지 않은 학생 찾기, 오름차순으로 정렬
    not_submit = list(student - submit_std)
    not_submit.sort()
    
   # 밖에는 큰 따옴표로 해줘야함, 그리고 join은 문자열만 가능, map으로 str 변환해주기
    print(f"#{num} {' '.join(map(str, not_submit))}") 