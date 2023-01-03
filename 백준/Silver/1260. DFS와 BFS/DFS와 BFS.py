import sys
from collections import deque


def dfs(graph,v,visited):
    if visited[v]==False:
        visited[v] = True
        print(v, end =' ')
        for i in graph[v]:
            dfs(graph,i,visited)
    return False

n,m,v = map(int,sys.stdin.readline().split())

graph = dict()
for i in range(m):
   a,b = map(int,sys.stdin.readline().split())
   if a not in graph:
       graph[a] = []
   if b not in graph:
       graph[b] = []
   graph[a].append(b)
   graph[b].append(a)
for i in graph:
    graph[i].sort()

#DFS 깊이우선탐색 재귀
graph = (sorted(graph.items()))
#print(graph)
#print(len(graph))
numgraph = list(0 for _ in range(n+1))
for i in range(len(graph)):
    numgraph[graph[i][0]] = graph[i][1]
graph = numgraph    #dict은 keyerror??
#print(graph)
#이러면 또 typeError??
visited = [False] * (n+1)


if graph[v]==0:
    print(1)
    print(1)
    quit()

dfs(graph,v,visited)

print()
#BFS 큐
visited = [False] * (n+1)
queue = deque()
queue.append(v)
visited[v] = True

while queue:
    v = queue.popleft()
    print(v, end=' ')
    for i in graph[v]:
        if visited[i] == False:
            queue.append(i)
            visited[i]=True