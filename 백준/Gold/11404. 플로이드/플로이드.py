import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
dist=[[10**9] * (n+1) for _ in range(n+1)]

for i in range(m):
    a,b,c = map(int,sys.stdin.readline().split())
    dist[a][b] = min(c,dist[a][b])

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if i != j and dist[i][k] + dist[k][j] < dist[i][j]:
                dist[i][j] = dist[i][k] + dist[k][j]
            if i==j:
                dist[i][j] = 0

for i in range(1,n+1):
    for j in range(1,n+1):
        if dist[i][j] == 10**9:
            print(0,end=' ')
        else:
            print(dist[i][j],end=' ')
    print()
