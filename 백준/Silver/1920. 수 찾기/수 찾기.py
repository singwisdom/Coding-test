# 백준 1920번 : 수 찾기
import sys

n = int(input())
a_list = set(map(int, sys.stdin.readline().split()))

m = int(input())
m_list = list(map(int, sys.stdin.readline().split()))

for i in m_list :
    if i in a_list : sys.stdout.writelines("1"+'\n')
    else : sys.stdout.writelines("0"+'\n')