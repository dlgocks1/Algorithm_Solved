import sys

a,b,c = map(int,sys.stdin.readline().split())

def gop(b):
    if b==1:
        return a%c
    elif b%2==1:
        return (gop(b//2)**2*a%c)
    else:
        return (gop(b//2)**2%c)

print(gop(b))