# 백준 1003번 : 피보나치 함수
# 알고리즘 & 자료구조 : DP이용하기
# 테이블 정의 : D[i][j] = i을 입력한 피보나치 함수, j는 0, 1의 개수
# 점화식 : D[i][j] = D[i-1][j] + D[i-2][j]
# 초기식은 D[1]까지 정해야 함.

D = [[0,0] for _ in range(41)]# 피보나치 DP 배열, 0번째 인덱스가 0 출력 횟수, 1번째 인덱스가 1 출력 횟수
D[0] = [1,0] # D[0]
D[1] = [0,1]

for i in range(2,41):
    for j in range(2):
        D[i][j] = D[i-1][j] + D[i-2][j]

#print(D)

tc = int(input())
for t in range(tc):
    n = int(input())
    print(D[n][0], D[n][1])