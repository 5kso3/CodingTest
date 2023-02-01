import java.util.Scanner;

public class BJ1850 {

    public BJ1850() {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        long max = Math.max(l, r);
        long min = Math.min(l, r);
        long rest = max % min;
        long temp = 0;
        while(rest != 0) {
            temp = rest;
            rest = min % rest;
            min = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < min; i++) {
            sb.append('1');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BJ1850 bj1850 = new BJ1850();
    }
}
