from collections import deque
import sys

a,b = map(int,sys.stdin.readline().split())

q = deque()
q.append([a,1])
ans = 10**9

while q:
    num, cnt = q.popleft()
    if num>b:
        continue
    if num == b:
        ans = min(ans,cnt)
        break
    q.append([num*2,cnt+1])
    q.append([num*10+1,cnt+1])
if ans == 10**9:
    print(-1)
else:
    print(ans)