import sys
import math

n,m = map(int,sys.stdin.readline().split())
nlist = list()

if n==0 or m==0:
    print(0)
    quit()
elif n==1 or m==1:
    print(1)
    quit()

maxnum = 1
for i in range(n):
    nlist.append(str(sys.stdin.readline().replace('\n','')))

for i in range(n):
    for j in range(0,m-1):
        for x in range(m-1,j,-1):
            if int(nlist[i][j]) == int(nlist[i][x]):
                if i+x-j >= n:
                    continue
                elif int(nlist[i+x-j][j]) == int(nlist[i+x-j][x]) == int(nlist[i][j]):# and abs(x-j) == abs(i-y):
                    maxnum = max(maxnum,(x-j+1)*(x-j+1))
print(maxnum)