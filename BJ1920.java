import javax.security.sasl.SaslClient;
import java.util.Arrays;
import java.util.Scanner;

public class BJ1920 {

    public BJ1920() {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        int[] list = new int[loop];
        for (int i = 0; i < loop; i++) {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);

        loop = sc.nextInt();
        int[] numlist = new int[loop];
        for (int i = 0; i < loop; i++) {
            numlist[i] = sc.nextInt();
        }


        for(int i = 0; i < numlist.length; i++) {
            boolean flag = false;
            int start = 0;
            int end = list.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if(list[mid] == numlist[i]){
                    flag = true;
                    break;
                } else if (list[mid] < numlist[i]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if(flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args) {
        BJ1920 bj1920 = new BJ1920();
    }
}
