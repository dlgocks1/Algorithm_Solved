import sys

def fisano(m):
    cnt,m1,m2 = 1,1,2
    while True:
        if m1%m==1 and m2%m ==1:
            break
        m1,m2 = m2,(m1+m2)%m
        cnt+=1
    return cnt

n = int(sys.stdin.readline())
for i in range(n):
    p,m = map(int,sys.stdin.readline().split())
    print(i+1,fisano(m))