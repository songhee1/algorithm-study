for i in range(3):
    aSum=0
    N=list(map(int,input().split()))
    for item in N:
        if item==0:
            aSum+=1  
    
    if aSum==1:
        print('A')
    elif aSum==2:
        print('B')
    elif aSum==3:
        print('C')
    elif aSum==4:
        print('D')
    else:
        print('E')

