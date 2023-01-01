import sys
import math

n,m = map(int,sys.stdin.readline().split())
visited = [False for i in range(n+1)]
stack = list()

def dfs(cnt):
    if cnt == m:
        for i in stack:
            print(i,end=' ')
        print()
        return
    for i in range(1,n+1):
        if visited[i] == False:
            visited[i] = True
            stack.append(i)
            dfs(cnt+1)
            stack.pop()
            visited[i] = False
dfs(0)