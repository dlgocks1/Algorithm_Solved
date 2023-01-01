import sys
import math

# def fibonacci(n):
#     global dp
#     if n == 0 or n==1:
#         return 1
#     if dp[n] != -1:
#         return dp[n]
#     else:
#         dp[n] = fibonacci(n - 1) + fibonacci(n - 2)
#         return dp[n]

n = int(sys.stdin.readline())
if n ==0:
    print(0)
    quit()
if n ==1 or n==2:
    print(1)
    quit()
dp = [-1 for i in range(n+1)]
dp[0] = 0
dp[1] = 1
dp[2] = 1
for i in range(3,n+1):
    dp[i] = (dp[i - 1] + dp[i - 2]) %1000000007
# fibonacci(n)
print(dp[n])