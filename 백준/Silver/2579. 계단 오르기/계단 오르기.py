import sys

n = int(sys.stdin.readline())
arr= list()
for i in range(n):
    arr.append(int(sys.stdin.readline()))

if n<=2:
    print(sum(arr))
    quit()
dp= [0] * (301)
dp[0] = arr[0]
dp[1] = arr[1]+arr[0]
dp[2] = max(arr[0]+arr[2],arr[1]+arr[2])

for i in range(3,n):
    dp[i] = max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i])
print(dp[n-1])