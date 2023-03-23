import java.util.Scanner;

public class 최대값찾기 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int a;
        int maxNum=0;
        int maxIndex=1;
        for(int i=1;i<=9;i++){
            a=sc.nextInt();
            if(a>maxNum) {
                maxNum=a;
                maxIndex=i;
            }
        }
        System.out.println(maxNum);
        System.out.println(maxIndex);
        sc.close();
    }
}

