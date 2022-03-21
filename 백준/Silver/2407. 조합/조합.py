import sys

n,m = map(int,sys.stdin.readline().split())

def nCm(n, m):
    numerator = 1
    denominator = 1
    k = min(n-m, m)
    for i in range(1, k+1):
        denominator *= i
        numerator *= n+1-i
    return numerator//denominator


print(nCm(n,m))

