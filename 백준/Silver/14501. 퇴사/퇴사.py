import sys
import math

n = int(sys.stdin.readline())
dp = [0 for i in range(n+1)]
ws = list()
for i in range(n):
    ws.append(list(map(int,sys.stdin.readline().split())))

for i in range(n-1,-1,-1):
    if ws[i][0] + i > n:
        dp[i] = dp[i+1]
        continue
    dp[i] = max(dp[i+1], dp[i+ws[i][0]]+ws[i][1])

print(dp[0])
