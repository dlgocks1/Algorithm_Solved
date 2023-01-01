import sys
import math

target = int(sys.stdin.readline())
ans = abs(100-target)
m = int(sys.stdin.readline())
if m:
    numset = set(sys.stdin.readline().split())
else:
    numset = set()

for num in range(10000001):
    for N in str(num):
        if N in numset:
            #print("걸림")
            break
    else:
        ans = min(ans,len(str(num)) + abs(num-target))
print(ans)