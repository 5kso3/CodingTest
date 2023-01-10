import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ1940 {

    public  BJ1940(){
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        int goal = sc.nextInt();
        int[] nums = new int[loop];
        for(int i = 0; i < loop; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int start = 0;
        int end = loop - 1;
        int result = 0;
        while(start != end) {
            int sum = nums[start] + nums[end];
            if(sum < goal) {
                start++;
            } else if(sum == goal){
                result++;
                start++;
            } else {
                end--;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BJ1940 bj1940 = new BJ1940();
    }
}
