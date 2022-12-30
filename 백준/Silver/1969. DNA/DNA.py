import sys
from collections import deque
from itertools import permutations as pm

n,m = map(int,sys.stdin.readline().split())

dnalist = [str(sys.stdin.readline().replace('\n','')) for i in range(n)]
dnadic = dict()
hamdistance = 0
for i in range(m):
    for j in range(n):
        if dnalist[j][i] not in dnadic:
            dnadic[dnalist[j][i]] = 1
        else:
            dnadic[dnalist[j][i]] +=1
    #print(dnadic)
    print(sorted(dnadic.items(),key=lambda x : (-x[1], x[0]))[0][0],end='')
    hamdistance += n-max(dnadic.values())
    dnadic.clear()
print()
print(hamdistance)