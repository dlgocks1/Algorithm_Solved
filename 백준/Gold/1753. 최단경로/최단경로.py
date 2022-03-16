import sys
import heapq

v1,e = map(int,sys.stdin.readline().split())
k = int(sys.stdin.readline())
arr = [[] for _ in range(v1+2)]

for i in range(e):
    u,v,w = map(int,sys.stdin.readline().split())
    arr[u].append([v,w])

def dijkstra(s):
    cost = [float("inf") for _ in range(v1+2)]
    cost[s] = 0
    q = []
    heapq.heappush(q, [0, s])
    while q:
        w, c = heapq.heappop(q)
        if cost[c] != w: continue
        for nx, nt in arr[c]:
            if cost[nx] > w + nt:
                cost[nx] = w + nt
                heapq.heappush(q, [cost[nx], nx])
    return cost

ans = dijkstra(k)
for i in range(1,v1+1):
    if ans[i] == float("inf"):
        print("INF")
    else:
        print(ans[i])
