import sys
import math

n = int(sys.stdin.readline())
#a = list(map(int,sys.stdin.readline().split()))

dp = [0] * (n+1)
if n <=4:
    if n ==2:
        print("CY")
    else:
        print("SK")
    quit()
dp[1]= 1 #상근
dp[2]= 2 #창영
dp[3]= 1
dp[4]= 1

for i in range(5,n+1):
    if dp[i-1] ==2 or dp[i-3] ==2 or dp[i-4] ==2:
        dp[i] = 1
    else:
        dp[i] = 2
if dp[n] == 1:
    print("SK")
else:
    print("CY")
