from itertools import combinations
import re
import sys
import math

while True:
    num = list(map(int,sys.stdin.readline().split()))
    if num[0] == 0:
        quit()
    k,lottolist = num[0],num[1:]
    for i in combinations(lottolist,6):
        #print(str(i).replace('(','').replace(')','').replace('|\,',''))
        for j in i:
            print(j,end=' ')
        print()
    print()
