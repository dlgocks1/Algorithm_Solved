import sys

r,c = map(int,sys.stdin.readline().split())
numlist = list()
for i in range(r):
    numlist.append(list(map(int,sys.stdin.readline().split())))
t = int(sys.stdin.readline())
filterlist = list()
cnt=0

for i in range(r-2):#6 0 1 2 3 (4)
    for j in range(c-2):
        fillist = list()
        for x in range(i,i+3): #3 3 4 5 (6)
            for y in range(j,j+3):
                #print(x,y)
                fillist.append(numlist[x][y])
        fillist.sort()
        if int(fillist[4])>=t:
            cnt+=1
print(cnt)