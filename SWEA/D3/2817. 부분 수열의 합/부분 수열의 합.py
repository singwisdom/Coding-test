# SWEA 2817번 : 부분 수열의 합
# 알고리즘 & 자료구조 : DP일까 ?

def dfs(i,sum):
    global count
    # 두 if문의 순서를 바꾸면 안됨, n 인덱스 까지 왔을때 sum이 k일 수 있기 때문
    if sum == k : # 합이 k와 같다면 return
        count += 1
        return 
    if i == n : return # 이미 다 돌았으므로 return

    dfs(i+1, sum+num[i]) # 해당 숫자를 사용하는 경우
    dfs(i+1, sum) # 해당 숫자를 사용하지 않는 경우

tc = int(input())
for t in range(1,tc+1):
    n,k = map(int, input().split()) # n이 숫자의 개수, k가 합
    num = list(map(int, input().split())) # 숫자 리스트 입력
    count = 0
    dfs(0,0)
    print(f'#{t} {count}')