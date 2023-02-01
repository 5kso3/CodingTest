import java.util.Scanner;

public class BJ1934 {

    public BJ1934() {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for(int i = 0; i < loop; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int min = Math.min(l, r);
            int max = Math.max(l, r);
            int rest = max % min;
            int temp = 0;
            while(rest != 0) {
                temp = rest;
                rest = min % rest;
                min = temp;
            }
            System.out.println(l * r / min);
        }
    }

    public static void main(String[] args) {
        BJ1934 bj1934 = new BJ1934();
    }
}
