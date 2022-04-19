import sys

#input = sys.stdin.readline

n = int(sys.stdin.readline())

mingrade = [0] * 3
maxgrade = [0] * 3
max_tmp = [0] * 3
min_tmp = [0] * 3

for i in range(n):
    a,b,c = map(int,sys.stdin.readline().split())
    for j in range(3):
        if j == 0:
            min_tmp[j] = a + min(min_tmp[j],mingrade[j+1])
            max_tmp[j] = a + max(max_tmp[j],maxgrade[j+1])
        elif j ==1:
            min_tmp[j] = b + min(min_tmp[j],mingrade[j+1],mingrade[j-1])
            max_tmp[j] = b + max(max_tmp[j],maxgrade[j+1],maxgrade[j-1])
        else:
            min_tmp[j] = c + min(min_tmp[j], mingrade[j - 1])
            max_tmp[j] = c + max(max_tmp[j], maxgrade[j - 1])
    for j in range(3):
        maxgrade[j] = max_tmp[j]
        mingrade[j] = min_tmp[j]
print(max(maxgrade),min(mingrade))

#maplist = list()
#맵리스트입력받기
# mingrade, maxgrade = 10**9,0
# dx = [-1,0,1]
# q = deque()
# for i in range(3):
#     q.append([0,i,0])#sum, index, cnt
#     while q:
#         sum, index, cnt = q.popleft()
#         sum += maplist[cnt][index]
#         if cnt+1 == n:
#             mingrade = min(mingrade,sum)
#             maxgrade = max(maxgrade,sum)
#             continue
#         for j in dx:
#             if j+index <3 and j+index >=0:
#                 q.append([sum,j+index,cnt+1])
# print(maxgrade,end=" ")
# print(mingrade)
