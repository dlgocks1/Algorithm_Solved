import re
import sys
import math

n,m = map(int,sys.stdin.readline().split())
dp = [[0] * (m+1) for i in range(n+1)]
mlist = list()
for i in range(n):
    mlist.append([*map(int,sys.stdin.readline().split())])

for i in range(1,n+1):
    for j in range(1,m+1):
        if mlist[i-1][j-1] == 1:
            dp[i][j] = max(dp[i-1][j],dp[i][j-1]) + 1
        else:
            dp[i][j] = max(dp[i-1][j],dp[i][j-1])
print(max(max(dp)))