import sys

n = int(sys.stdin.readline())
arr = [*map(int,sys.stdin.readline().split())]
arr = sorted(arr)
dp = [0] * n
dp[0] = arr[0]
for i in range(1,n):
    dp[i] = arr[i] + dp[i-1]
print(sum(dp))