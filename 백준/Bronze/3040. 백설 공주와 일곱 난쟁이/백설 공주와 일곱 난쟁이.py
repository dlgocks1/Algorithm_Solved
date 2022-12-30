import sys
from collections import deque

numlist= [int(sys.stdin.readline()) for i in range(9)]

for a in range(9):
    for b in range(a+1,9):
        if sum(numlist) - numlist[a] - numlist[b] == 100:
            for i in range(9):
                if i not in [a,b]:
                    print(numlist[i])