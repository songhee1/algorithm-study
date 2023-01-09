heights=[]
for i in range(9):
    n=int(input())
    heights.append(n)

tinyheightindex=list(range(7))
indextochange=6

while True:
    sum=0
    for index in tinyheightindex:
        sum+=heights[index]
    
    if sum==100:
        break
    else:
        if tinyheightindex[indextochange]<8 and (tinyheightindex[indextochange]+1 not in tinyheightindex):
            tinyheightindex[indextochange]+=1
        else:
            if indextochange==0:
                break;
            else:
                indextochange-=1
            
answerlist=[]
for item in tinyheightindex:
    answerlist.append(heights[item])

answerlist.sort()
for item in answerlist:
    print(item)            