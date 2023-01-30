import java.util.Scanner;

public class BJ1456 {

    public BJ1456() {
        Scanner sc = new Scanner(System.in);
        long start = sc.nextLong();
        long end = sc.nextLong();
        long[] list = new long[10000001];
        int result = 0;
        for(int i = 2; i < list.length; i++) {
            list[i] = i;
        }
        for(int i = 2; i < list.length; i++) {
            if(list[i] == 0) {
                continue;
            }
            for(int j = i + i; j < list.length; j = j + i) {
                list[j] = 0;
            }
        }

        for (int i = 0; i < 10000001; i++) {
            if(list[i] == 0) {
                continue;
            }
            long temp = list[i];
            while((double)list[i] <= (double)end / (double)temp) {
                if((double)list[i] >= (double)start / (double)temp) {
                    result++;
                }
                temp = temp * list[i];
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        BJ1456 bj1456 = new BJ1456();
    }
}
