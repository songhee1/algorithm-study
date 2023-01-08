N=int(input())
AList=[]
BList=[]
lostWrite=0
#
# 1) b가 1인게 또 있는 경우 
# 2) 0이 1보다 먼저 들어온 경우 
# 3) 1이후에 0이 없는 경우
for i in range(N):
    a,b=map(int,input().split())
    if b==1 and (a not in AList) :
        AList.append(a)
    elif b==0 and (a in AList):
        AList.remove(a)
    elif b==1 and (a in AList):
        AList.remove(a)
        lostWrite+=1
        AList.append(a)
    elif b==0 and (a not in AList):
        lostWrite+=1

print(len(AList)+lostWrite)
        