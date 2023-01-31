import java.util.Scanner;

public class BJ1747 {

    public BJ1747() {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int size = 10000000;
        boolean[] check = new boolean[size + 1];
        check[1] = true;

        for(int i = 2; i <= size; i++) {
            for(int j = i + i; j <= size; j+=i) {
                check[j] = true;
            }
        }

        for(int i = start; i <= size; i++) {
            if(!check[i]) {
                String temp = Integer.toString(i);
                boolean flag = true;
                for(int j = 0; j < temp.length() / 2; j++) {
                    if(temp.charAt(temp.length() - 1 - j) != temp.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }


    public static void main(String[] args) {
        BJ1747 bj1747 = new BJ1747();
    }
}
