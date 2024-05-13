# SWEA 6485번 : 삼성시의 버스 노선
# 알고리즘 & 자료구조 :

tc = int(input())
for t in range(1, tc + 1):
    bus = list()
    station = list()
    result = ''

    n = int(input())  # 버스 노선의 개수
    for _ in range(n): bus.append(list(map(int, input().split())))

    p = int(input())  # 정류장의 개수
    for _ in range(p): station.append(int(input()))  # Cj번 버스정류장

    # 핵심 알고리즘
    for i in range(p):
        cnt = 0
        for j in range(n):
            if bus[j][0] <= station[i] <= bus[j][1]: cnt += 1
        result += str(cnt)+' '

    print(f'#{t} {result}')