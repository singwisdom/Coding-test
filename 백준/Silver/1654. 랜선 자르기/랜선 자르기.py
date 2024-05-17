# 이분탐색, 가장 짧은 길이를 1, 긴 길이를 랜선 중 max 길이로 설정해야함
k, n = map(int, input().split())
line = [int(input()) for _ in range(k)]
left = 1
right = max(line)

while left<=right :
    mid = (left+right) // 2
    count = 0
    for j in range(k):
        count += int(line[j] // mid)

    if count >= n: left = mid+1 # 원하는 랜선 길이가 될 경우,
    else : right = mid-1  # 랜선이 만들어지지 않는 다는 뜻
print(right)