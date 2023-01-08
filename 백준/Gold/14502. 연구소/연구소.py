from itertools import combinations
import re
import math
from heapq import *
import sys
from collections import deque

n,m = map(int,sys.stdin.readline().split())
dx= [0,1,0,-1]
dy= [1,0,-1,0]
arr = [[*map(int,sys.stdin.readline().split())] for _ in range(n)]

wall = []
virus = []
ans = 0
for i in range(n):
    for j in range(m):
        if arr[i][j] == 0: wall.append([i,j])
        if arr[i][j] == 2: virus.append([i,j])

for w1, w2, w3 in combinations(wall, 3):
    isvisited = [[0] * m for _ in range(n)]
    q= deque()
    for x,y in [w1,w2,w3]:
        arr[x][y] = 1
    for x,y in virus:
        q.append([x,y])
        isvisited[x][y] = 1
    while q:
        x,y = q.popleft()
        for i in range(4):
            mx = x + dx[i]
            my = y + dy[i]
            if 0<= mx < n and 0<= my < m :
                if isvisited[mx][my] ==0 and arr[mx][my] != 1:
                    isvisited[mx][my] = 1
                    q.append([mx,my])
    val = 0
    for i in range(n):
        for j in range(m):
            if arr[i][j] != 1 and isvisited[i][j] == 0:
                val +=1
    ans = max(ans,val)

    for x,y in [w1,w2,w3]:
        arr[x][y] = 0

print(ans)