import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1715 {

    public BJ1715() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int result = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            que.add(sc.nextInt());
        }

        while(que.size() != 1){
            int temp = que.poll() + que.poll();
            result += temp;
            que.add(temp);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BJ1715 bj1715 = new BJ1715();
    }
}
