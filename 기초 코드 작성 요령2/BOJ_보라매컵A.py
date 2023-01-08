N=int(input())
militaryList=list(map(int,input().split()))
max_chicken_people=0
for item in militaryList:
    if item>N:
        max_chicken_people+=N
    elif item<=N:
        max_chicken_people+=item   

print(max_chicken_people)