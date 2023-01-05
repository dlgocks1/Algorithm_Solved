import sys
import math

n = int(sys.stdin.readline())
#a = list(map(int,sys.stdin.readline().split()))
a= list()
for i in range(n):
    a.append(int(sys.stdin.readline()))

dp = [0] * n
for i in range(n):
    dp[i] = 1

for i in range(1,len(a)):
    for j in range(i):
        if a[i] > a[j]:
            dp[i] = max(dp[i],dp[j]+1)
print(n-max(dp))
#print(dp)