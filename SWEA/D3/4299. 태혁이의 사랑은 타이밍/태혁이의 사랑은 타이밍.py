# SWEA 4299번 : 태혁이의 사랑은 타이밍
# 알고리즘 & 자료구조 : 그냥..ㅎㅎ 싹다 분으로 바꾸고 계산해주면 겁나 빠름ㅋㅎ

tc = int(input())
for test_case in range(1,tc+1):

    d,h,m = map(int, input().split()) # 깨달음을 얻은 시간
    result = 60*24*d + 60*h + m
 
    result_11 = 60*24*11 + 60*11 + 11 # original 시간 11일 오전 11시 11분

    if result < result_11 : result = -1
    else : result = result - result_11
    print(f'#{test_case} {result}')