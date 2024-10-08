# SWEA 1225번 : 암호생성기
# 알고리즘 & 자료구조 : 덱

from collections import deque
my_que = deque()

for i in range(10):
    n = int(input()) # 테스트케이스 번호
    is_zero = False
    result = ''
    my_que.clear()

    string = input().split()
    for num in string :
        my_que.append(int(num)) # 8자리의 번호를 입력받아서 덱에 저장

    while True :
        for j in range(1,6):
            num = my_que.popleft() - j
            if num <= 0 : # 0이 된다면 반복문 빠져나옴
                is_zero = True
                my_que.append(0)
                break
            else : 
                my_que.append(num)

        if is_zero == True : break

    result = ' '.join(map(str, my_que)) # 리스트 컴프리헨션, join 메서드 사용
    print(f'#{n} {result}') # 결과 출력