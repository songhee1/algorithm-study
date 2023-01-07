N=int(input())
rest=N%5
total=[]
if rest%3==0 or (rest+=5 and rest%3==0):
    total.append(int(N//5+rest/3))
    rest+=5
    if rest%3==0:
         total.append(int(N//5-1+rest/3))


if N%3==0:
    total.append(int(N/3))

if len(total)==0:
    print(-1)
else: print(min(total))