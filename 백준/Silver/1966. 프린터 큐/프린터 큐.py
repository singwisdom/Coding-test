# 백준 1966번 : 프린터 큐
# 알고리즘 & 자료구조 :

from collections import deque

tc = int(input())
for t in range(tc):
    n, m = map(int, input().split())  # n :문서의 개수, m : 찾고자 하는 문서의 위치
    important = list(map(int, input().split()))  # 문서의 중요도
    printer = deque()

    for i in range(n):
        printer.append([i, important[i]])  # (문서번호, 중요도)

    # 중요도 정렬
    important.sort()
    count = 0

    while printer :
        i, rank = printer.popleft() # 항상 0번째 인덱스가 MAX인지 확인하면 됨

        if rank == important[-1] : # 중요도가 가장 높다면
            important.pop() # 중요도 리스트에서도 pop 해줌
            count += 1

            if i == m : # 만약 내가 찾고자 하는 문서라면
                print(count) # 출력
                break
        else : # max가 아니면 뒤에 삽입
            printer.append([i,rank])
