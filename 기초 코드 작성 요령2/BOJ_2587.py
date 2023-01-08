nList=[]
for i in range(5):
    n=int(input())
    nList.append(n)
average=0
middleNum=0

index=0
tmp=0
for i in range(5):
    for j in range(i+1,5):
        if nList[j]<nList[index]:
            tmp=nList[index]
            nList[index]=nList[j]
            nList[j]=tmp
    index+=1

sum=0
for item in nList:
    sum+=item

print(sum//5)
print(nList[2])
        

        