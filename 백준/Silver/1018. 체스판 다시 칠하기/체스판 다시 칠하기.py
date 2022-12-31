import sys
from collections import deque
from itertools import permutations as pm

n,m = map(int,sys.stdin.readline().split())
csmap = [sys.stdin.readline().replace('\n','') for i in range(n)]
cnt = list()
for a in range(n-7):
    for b in range(m-7):
        cnt1, cnt2 = 0, 0
        for i in range(a,a+8):
            for j in range(b,b+8):
                if (i+j) %2 ==0:
                    if csmap[i][j] != 'W':
                        cnt1 +=1
                    if csmap[i][j] != 'B':
                        cnt2 +=1
                else:
                    if csmap[i][j] != 'B':
                        cnt1 +=1
                    if csmap[i][j] != 'W':
                        cnt2 +=1
        cnt.append(min(cnt1,cnt2))
print(min(cnt))