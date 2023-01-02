import sys
import math

Red,Green,Blue = 0,1,2
n = int(sys.stdin.readline())
dp = [[0,0,0] for i in range(n)]
rgb = list()

for i in range(n):
    rgb.append(list(map(int,sys.stdin.readline().split())))

for i in range(1,n):
    rgb[i][Red] = min(rgb[i-1][Green], rgb[i-1][Blue]) + rgb[i][Red]
    rgb[i][Green] = min(rgb[i - 1][Red], rgb[i - 1][Blue]) +rgb[i][Green]
    rgb[i][Blue] = min(rgb[i - 1][Green], rgb[i - 1][Red]) +rgb[i][Blue]

print(min(rgb[n-1][Red],rgb[n-1][Green],rgb[n-1][Blue]))

