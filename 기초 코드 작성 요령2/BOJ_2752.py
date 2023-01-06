N_list=list(map(int, input().split()))
tmp=0
for i in range(0,3):
    least_num=N_list[i]
    for j in range(i,3):
        if least_num>N_list[j]:
            tmp=N_list[j]
            N_list[j]=least_num
            N_list[i]=tmp
            least_num=N_list[i]
for i in N_list:
    print(i, end=" ")

