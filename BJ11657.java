import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ11657 {

    public BJ11657() {
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int route = sc.nextInt();
        long[] result = new long[city + 1];
        ArrayList<int[]>[] list = new ArrayList[city + 1];
        for(int i = 1; i <= city; i++) {
            result[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < route; i++) {
            int s = sc.nextInt();
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            list[s].add(temp);
        }
        result[1] = 0;
        for(int i = 1; i < city; i++) {
            for(int j = 1; j <= city; j++) {
                if(result[j] != Integer.MAX_VALUE) {
                    for(int[] next : list[j]) {
                        if(result[j] + next[1] < result[next[0]]) {
                            result[next[0]] = result[j] + next[1];
                        }
                    }
                }
            }
        }
        long[] temp = result.clone();
        for(int j = 1; j <= city; j++) {
            if(result[j] != Integer.MAX_VALUE) {
                for(int[] next : list[j]) {
                    if(result[j] + next[1] < result[next[0]]) {
                        result[next[0]] = result[j] + next[1];
                    }
                }
            }
        }
        boolean flag = true;
        for(int i = 1; i <= city; i++) {
            if(temp[i] != result[i]) {
                flag = false;
                break;
            }
        }
        if(flag) {
            for(int i = 2; i <= city; i++) {
                if(result[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(result[i]);
                }
            }
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        BJ11657 bj1854 = new BJ11657();
    }
}
