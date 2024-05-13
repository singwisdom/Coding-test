# 백준 1929번 : 소수구하기
# 알고리즘 & 자료구조 : 에라토스테네스의 체

import math

def find_prime(m, n):
    is_prime = [True] * (n + 1)
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(math.sqrt(n)) + 1):  # 에라토스테네스의 체로 거르기
        if is_prime[i]:
            j = 2
            while i * j <= n:
                is_prime[i * j] = False
                j += 1

    for k in range(m, n + 1):
        if is_prime[k] == True: print(k)


m, n = map(int, input().split())
find_prime(m, n)