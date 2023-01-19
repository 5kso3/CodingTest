import java.util.Scanner;

public class BJ11047 {

    public BJ11047() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int goal = sc.nextInt();
        int result = 0;
        int[] list = new int[size];
        for(int i = 0; i < size; i++){
            list[i] = sc.nextInt();
        }

        for (int i = size - 1; i >= 0; i--) {
            while (goal >= list[i]) {
                goal -= list[i];
                result++;
            }
        }


        System.out.println(result);
    }

    public static void main(String[] args) {
        BJ11047 bj11047 = new BJ11047();
    }
}
