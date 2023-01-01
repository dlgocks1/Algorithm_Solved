import sys
import math

n,k = map(int,sys.stdin.readline().split())

dp = [[1 for i in range(1,j+1)]for j in range(n+1)]
for i in range(3,n+1):
    for j in range(1,len(dp[i])-1):
        dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
print(dp[n][k-1])
