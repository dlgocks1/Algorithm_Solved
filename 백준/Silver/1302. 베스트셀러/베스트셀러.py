import sys

n = int(sys.stdin.readline())
bookdict = dict()
for _ in range(n):
    book = sys.stdin.readline().strip()
    if(book in bookdict):
        bookdict[book] +=1
    else:
        bookdict[book] = 1

print(sorted(bookdict.items(),key=lambda x:(-x[1],x[0]),reverse=False)[0][0])