import sys
import math

numlist = [0,1,2,3,4,5,6,7,8,9]
isvisited = [False for i in range(10)]
k = int(sys.stdin.readline())
blist = list(map(str,sys.stdin.readline().split()))
stack = list()
stack2 = list()

def dfs(v,cnt):
    global blist
    if cnt == k and isvisited[v]==False:
        stack.append(v)
        stack2.append(list(stack))
        stack.pop()
        # for i in range(10):
        #     if blist[cnt-1] == '<' and v<i:
        #         if isvisited[i] == False:
        #             stack.append(i)
        #             stack2.append(list(stack))
        #             #print(stack)
        #             stack.pop()
        #     if blist[cnt-1] == '>' and v>i:
        #         if isvisited[i] == False:
        #             stack.append(i)
        #             stack2.append(list(stack))
        #             #print(stack)
        #             stack.pop()
        return
    if isvisited[v] == False:
        isvisited[v] = True
        stack.append(v)
        for i in range(10):
            if blist[cnt] == '<' and v<i:
                dfs(i, cnt + 1)
            if blist[cnt] == '>' and v>i:
                dfs(i,cnt+1)
        stack.pop()
        isvisited[v] = False

for i in numlist:
    dfs(i,0)
stack2.sort()
for i in stack2[-1]:
    print(i,end='')
print()
for i in stack2[0]:
    print(i,end='')