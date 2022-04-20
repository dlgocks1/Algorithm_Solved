import math
from heapq import *
#sys.setrecursionlimit(10**9)
from collections import deque
import sys

xs, ys = map(int,sys.stdin.readline().split())
xe,ye,dx,dy = map(int,sys.stdin.readline().split())

bf = math.gcd(dx,dy)
dx //=bf
dy //=bf

curx, cury = xe, ye
while math.sqrt((curx - xs)**2 + (cury - ys)**2) > math.sqrt((curx + dx - xs)**2 + (cury + dy - ys)**2):
    curx += dx
    cury += dy
print(curx,cury)


# for x in range(-101,101):
#     if (dy/dx*(x-xe)+ye) == (-1*dx/dy*(x-xs) + ys):
#         print(x, int(dy/dx*(x-xe)+ye))
#         quit()

# y-1 = 2(x-2)
# y = 2x -3
# y -2 = -1/2(x-5)
# y = -0.5x + 4.5
# 2.5x = 7.5
#이걸 식으로