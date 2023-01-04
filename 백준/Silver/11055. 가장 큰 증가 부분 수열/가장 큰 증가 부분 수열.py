import sys
import math

n = int(sys.stdin.readline())
a = list(map(int,sys.stdin.readline().split()))

dp = [0] * n
for i in range(n):
    dp[i] = a[i]

for i in range(1,len(a)):
    for j in range(i):
        if a[i] > a[j]:
            dp[i] = max(dp[i],dp[j]+a[i])
print(max(dp))
#print(dp)