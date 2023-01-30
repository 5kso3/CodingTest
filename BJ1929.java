import java.util.Scanner;

public class BJ1929 {

    public BJ1929() {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        boolean[] check = new boolean[end + 1];
        check[1] = true;

        for(int i = 2; i <= end; i++) {
            int temp = i * 2;
            int m = 2;
            while(temp <= end) {
                if(temp <= end) {
                    if(!check[temp]) {
                        check[temp] = true;
                    }
                }
                m++;
                temp = i * m;
            }
        }
        for(int i = start; i <= end; i++) {
            if(!check[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        BJ1929 bj1929 = new BJ1929();
    }
}
