import sys

TC = int(sys.stdin.readline())
load = list()
for _ in range(TC):
    N, M, W = map(int,sys.stdin.readline().split())
    load = [[] for _ in range(N+1)]
    for _ in range(M):
        S, E, T = map(int,sys.stdin.readline().split())
        load[S].append([E,T])
        load[E].append([S,T])
    for _ in range(W):
        S, E ,T = map(int,sys.stdin.readline().split())
        load[S].append([E,-T])

    distance = [10001] * (N+1)
    distance[1] = 0
    Iscycle = False

    for k in range(1,N+1):
        for i in range(1,N+1):
            for mx, mt in load[i]:
                if distance[mx] > distance[i] + mt:
                    distance[mx] = distance[i] + mt
                    if k == N:
                        Iscycle = True
                        break
    #print(distance)
    if Iscycle:
        print("YES")
    else:
        print("NO")