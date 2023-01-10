import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2164 {

    public BJ2164(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i = 1; i <= num; i++) {
            que.add(i);
        }

        while(que.size() != 1) {
            que.poll();
            int temp = que.poll();
            que.add(temp);
        }
        System.out.println(que.poll());
    }

    public static void main(String[] args) {
        BJ2164 bj2164 = new BJ2164();
    }
}
