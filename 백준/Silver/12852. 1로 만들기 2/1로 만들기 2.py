import sys

n = int(sys.stdin.readline())
dp = [(float('inf'), 0)] * (n+1)
q = [n]
dp[n] = (0,0)
while q:
    cur = q.pop(0)
    if cur == 1:
        break
    if cur % 3 == 0 and dp[cur // 3][0] > dp[cur][0] + 1:
        dp[cur // 3] = (dp[cur][0] + 1, cur)
        q.append(cur // 3)
    if cur % 2 == 0 and dp[cur // 2][0] > dp[cur][0] + 1:
        dp[cur // 2] = (dp[cur][0] + 1, cur)
        q.append(cur // 2)
    if dp[cur - 1][0] > dp[cur][0] + 1:
        dp[cur - 1] = (dp[cur][0] + 1, cur)
        q.append(cur - 1)

path = []
cur = 1
while cur != 0:
    path.append(cur)
    cur = dp[cur][1]
print(dp[1][0])
print(*reversed(path))