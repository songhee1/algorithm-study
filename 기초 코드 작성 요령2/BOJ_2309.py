list=[]
for i in range(9):
    n=int(input())
    list.append(n)

tinyheight=list(range(7))
indextochange=6
moveindex=6

while True:
    sum=0
    for item in tinyheight:
        sum+=item
    if sum==100:
        break
    else:
        if moveindex==8:
            indextochange-=1
            moveindex
        else:
            moveindex+=1
            tinyheight[indextochange]=list[moveindex]
        