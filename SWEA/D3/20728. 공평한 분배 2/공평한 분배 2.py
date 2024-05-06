# SWEA 20728번 : 공평한 분배
# 알고리즘 & 자료구조 : 정렬

tc = int(input())
for num in range(1,tc+1):
    n,k = map(int, input().split()) # n: 주머니 총 개수 , k: 나눠줄 주머니 개수
    candy = list(map(int, input().split())) # 주머니 속 사탕의 개수
    candy.sort() # 사탕의 개수 정렬
    result = candy[n-1] - candy[0]
    i = 0

    if n == k : result = candy[0+k-1] - candy[0]
    else :
        while True:
            if k+i > n : break
            new_candy = candy[i:k+i]
            result = min(result, (new_candy[-1] - new_candy[0]))
            i += 1

    print(f'#{num} {result}')