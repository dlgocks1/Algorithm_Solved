from collections import deque
import sys

n = int(sys.stdin.readline())
arr = [[] for _ in range(n+1)]

for i in range(n-1):
    s, e = map(int,sys.stdin.readline().split())
    arr[s].append(e)
    arr[e].append(s)
head = [0] * (n+1)

def bfs():
    isvisited= [False] * (n+1)
    q = deque()
    isvisited[1] = True
    for i in arr[1]:
        head[i] = 1
        q.append(i)
    while q:
        now = q.pop()
        isvisited[now] = True
        for i in arr[now]:
            if isvisited[i] == False:
                head[i] = now
                q.append(i)
bfs()
for i in range(2,n+1):
    print(head[i])