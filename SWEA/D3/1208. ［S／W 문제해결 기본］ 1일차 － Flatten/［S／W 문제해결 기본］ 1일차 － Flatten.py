# SWEA 1208번 : Flatten
# 알고리즘 & 자료구조 : 정렬

for i in range(10):
    dump = int(input())
    box_list = list(map(int, input().split()))

    for k in range(dump):
        box_list.sort()
        box_list[0] += 1
        box_list[-1] -= 1
        if box_list[-1] - box_list[0] <=1 : break

    box_list.sort()
    height = box_list[-1] - box_list[0]
    print(f'#{i+1} {height}')