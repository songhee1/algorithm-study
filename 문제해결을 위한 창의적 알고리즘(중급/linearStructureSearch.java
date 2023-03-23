
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class linearStructureSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int findNum = sc.nextInt();
        for (int i = 1; i <= n; i++)
            if (findNum == nums[i - 1]) {
                System.out.print(i);
                return;
            }
        System.out.print(-1);
        sc.close();
        return;
    }
}
