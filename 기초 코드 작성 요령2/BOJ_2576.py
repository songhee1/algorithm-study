sum=0
N=[]
for i in range(7):
    item=int(input())
    if item%2!=0:
        N.append(item)

if len(N)==0:
    print(-1)
else:  
    leastNum=N[0]
    for item in N:
         sum+=item
         if leastNum>item:
            leastNum=item
    print(sum)
    print(leastNum)