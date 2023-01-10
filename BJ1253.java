import java.util.Arrays;
import java.util.Scanner;

public class BJ1253 {

    public BJ1253() {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        long[] nums = new long[loop];
        for (int i = 0; i < loop; i++) {
            nums[i] = sc.nextLong();
        }
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < loop; i++) {
            int start = 0;
            int end = loop - 1;
            while (start < end) {
                if(nums[start] + nums[end] == nums[i]){
                    if(start != i && end != i){
                        result++;
                        break;
                    } else if(start == i){
                        start++;
                    } else if(end == i){
                        end--;
                    }
                } else if(nums[start] + nums[end] < nums[i]){
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BJ1253 bJ1253 = new BJ1253();
    }
}
