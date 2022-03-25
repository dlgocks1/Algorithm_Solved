import sys
import heapq
sys.setrecursionlimit(10**9)

n = int(sys.stdin.readline())
arr = dict()
for i in range(n):
    a1, a2, a3 = map(str,sys.stdin.readline().split())
    arr[a1] = [a2,a3]

#전위순회
def preorder(v):
    if v=='.':
        return
    print(v,end='')
    preorder(arr[v][0])
    preorder(arr[v][1])

def inorder(v):
    if v=='.':
        return
    inorder(arr[v][0])
    print(v,end='')
    inorder(arr[v][1])

def postorder(v):
    if v=='.':
        return
    postorder(arr[v][0])
    postorder(arr[v][1])
    print(v,end='')

preorder('A')
print()
inorder('A')
print()
postorder('A')
