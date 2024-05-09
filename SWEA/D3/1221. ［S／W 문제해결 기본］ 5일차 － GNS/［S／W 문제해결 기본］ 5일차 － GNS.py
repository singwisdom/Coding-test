# SWEA 1221번 : GNS
# 알고리즘 & 자료구조 : ZRO부터 count해서 출력

gns = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]

tc = int(input())
for _ in range(tc):
    t, n = map(str, input().split())
    string_list = list(map(str, input().split()))
    result = ''

    for i in range(len(gns)):
        count = string_list.count(gns[i]) # 각 인덱스별로 몇 번 들어있는지 count
        result += (gns[i]+' ')*count

    print(t)
    print(result)