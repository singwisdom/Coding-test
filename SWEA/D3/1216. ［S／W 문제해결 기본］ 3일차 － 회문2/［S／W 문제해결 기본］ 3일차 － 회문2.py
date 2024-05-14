# SWEA 1216번 : 회문2
# 알고리즘 & 자료구조 : DP로 풀려고 했는데, 점화식을 어떻게 세워야 할지 모르겠음.
# 어쨌든 최대 길이를 출력하는거니까 100부터 범위를 좁히면서 탐색

def find(box,col_box):
    n = 100
    
    while n >= 1 :
        for i in range(100):
            for j in range(100-n+1):
                # 가로와 세로를 동시에 돌면서 확인 for문을 줄일 수 있음
                string = box[i][j:n+j]
                string_2 = col_box[i][j:n+j]
                # 만약 회문이라면 n을 return 함
                if box[i][j:n+j] == string[::-1] : return n
                if col_box[i][j:n+j] == string_2[::-1] :return n

        n -= 1

        
for tc in range(10):
    num = int(input())
    box = [str(input()) for _ in range(100)] # 회문 입력
    col_box = list(map(list, zip(*box[::-1])))
    res = find(box,col_box)

    print(f'#{num} {res}')