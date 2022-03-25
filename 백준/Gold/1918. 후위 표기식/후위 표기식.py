import sys
import heapq
sys.setrecursionlimit(10**9)

n = sys.stdin.readline()
exp = ['+', '-', '*', '/', '(', ')']
stack = list()
res = ''

for i in n:
    # if i in exp:
    if i.isalpha():
        res+=i
    else:
        if i =='(':
            stack.append(i)
        elif i =='*' or i =='/':
            while stack and (stack[-1] == '*' or stack[-1] =='/'):
                res+= stack.pop()
            stack.append(i)
        elif i=='+' or i=='-':
            while stack and stack[-1] != '(':
                res+= stack.pop()
            stack.append(i)
        elif i==')':
            while stack and stack[-1] !='(':
                res+=stack.pop()
            stack.pop()
    # else:
    #     res += i

while stack:
    res +=stack.pop()

print(res)