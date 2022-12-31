from itertools import permutations as pm
from itertools import combinations
import re
import sys
import math

n = int(sys.stdin.readline())
numlist = map(int,sys.stdin.readline().split())

maxsum = 0
for i in pm(numlist):
    hap =0
    for j in range(len(i)-1):
        hap += abs(i[j] - i[j+1])
    maxsum = max(maxsum,hap)
print(maxsum)


