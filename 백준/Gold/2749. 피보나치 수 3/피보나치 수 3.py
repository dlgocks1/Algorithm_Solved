import sys

# def fisano(m):
#     cnt,m1,m2 = 1,1,2
#     while True:
#         if m1%m==1 and m2%m ==1:
#             break
#         m1,m2 = m2,(m1+m2)%m
#         cnt+=1
#     return cnt

# print(fisano(1000000))
n = int(sys.stdin.readline())
dp = [0] * (1500001)
dp[1] = 1
for i in range(2,1500001):
    dp[i] = (dp[i-1] + dp[i-2]) % 1000000
print(dp[n%1500000])