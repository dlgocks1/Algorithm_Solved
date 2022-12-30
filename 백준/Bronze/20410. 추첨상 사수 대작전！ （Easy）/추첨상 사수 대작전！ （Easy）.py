import sys
from collections import deque
from itertools import permutations as pm

m,seed,x1,x2 = map(int,sys.stdin.readline().split())

for a in range(100):
    for c in range(100):
        if x1 == (a*seed+c)%m:
            if x2 == (a*(a*seed+c)+c)%m:
                print(a,c)
                quit()