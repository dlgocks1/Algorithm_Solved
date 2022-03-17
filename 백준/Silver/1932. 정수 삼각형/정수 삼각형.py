import sys

n = int(sys.stdin.readline())
arr = [[] for _ in range(n)]
dp = [[] for _ in range(n)]

for i in range(n):
    temparr = list(map(str,sys.stdin.readline().split()))
    arr[i]= temparr
    dp[i] = [0] * len(temparr)
dp[0] = int(arr[0][0])
if n<=1:
    print(arr[0][0])
    quit()

dp[1][0] = dp[0] + int(arr[1][0])
dp[1][1] = dp[0] + int(arr[1][1])
if n<=2:
    print(max(dp[1]))
    quit()
for i in range(2,n):
    dp[i][0] = dp[i-1][0] + int(arr[i][0])
    dp[i][i] = dp[i-1][i-1] + int(arr[i][i])
    for j in range(1,i):
        dp[i][j] = max(dp[i-1][j-1],dp[i-1][j]) + int(arr[i][j])
print(max(dp[n-1]))
