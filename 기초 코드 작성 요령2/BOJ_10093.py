A,B=map(int, input().split())
list=[]
count=0
if A<B:
    N=A+1
    count=B-A-1
    while N<B:
        list.append(N)
        N+=1
elif A>B:
    N=B+1
    count=A-B-1
    while N<A:
        list.append(N)
        N+=1

print(count)
for i in list:
    print(i, end=" ")
