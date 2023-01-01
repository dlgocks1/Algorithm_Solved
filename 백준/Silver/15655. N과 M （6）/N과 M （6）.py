import sys
import math

n,m = map(int,sys.stdin.readline().split())
numlist = list(map(int,sys.stdin.readline().split()))
numlist.sort()
visited = [False for i in range(max(numlist)+1)]
stack = list()

def dfs(cnt):
    if cnt == m:
        for i in stack:
            print(i,end=' ')
        print()
        return
    for i in numlist:
        if visited[i] == False:
            if len(stack)>=1 and stack[-1] > i:
                continue
            visited[i] = True
            stack.append(i)
            dfs(cnt+1)
            stack.pop()
            visited[i] = False
dfs(0)