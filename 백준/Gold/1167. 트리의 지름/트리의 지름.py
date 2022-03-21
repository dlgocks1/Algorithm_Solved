import sys

n = int(sys.stdin.readline())
arr = [[] for _ in range(n+1)]

for i in range(n):
    temparr = [*map(int,sys.stdin.readline().split())]
    v = temparr[0]
    for j in range(1,len(temparr)-1,2):
        arr[temparr[0]].append([temparr[j],temparr[j+1]])
        #arr[temparr[j]].append([temparr[0], temparr[j + 1]])

isvisited = [False] * (n+1)
ans = 0

def dfs(v,dist):
    isvisited[v] = True
    for mv,mt in arr[v]:
        if isvisited[mv] == False:
            distance[mv] = dist + mt
            dfs(mv,dist+mt)
distance = [-1] * (n+1)
distance[1] = 0
dfs(1,0)

now = (distance.index(max(distance)))
distance = [-1] * (n+1)
distance[now] = 0
isvisited = [False] * (n+1)
dfs(now,0)

print(max(distance))