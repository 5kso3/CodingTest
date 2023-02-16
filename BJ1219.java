import java.util.ArrayList;
import java.util.Scanner;

public class BJ1219 {

    public BJ1219() {
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        long[] result = new long[city];
        int[] earn = new int[city];
        int start = sc.nextInt();
        int end = sc.nextInt();
        int route = sc.nextInt();
        ArrayList<int[]>[] list = new ArrayList[city];
        for(int i = 0; i < city; i++) {
            list[i] = new ArrayList<>();
            result[i] = Long.MIN_VALUE;
        }
        for(int i = 0; i < route; i++) {
            int s = sc.nextInt();
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            list[s].add(temp);
        }
        for(int i = 0; i < city; i++) {
            earn[i] = sc.nextInt();
        }
        result[start] = earn[start];
        for(int i = 0; i < city - 1; i++) {
            for(int l = 0; l < city; l++) {
                for(int[] next : list[l]) {
                    if(result[l] != Long.MIN_VALUE && result[next[0]] < result[l] - next[1] + earn[next[0]]) {
                        result[next[0]] = result[l] - next[1] + earn[next[0]];
                    }
                }
            }
        }
        long temp = result[end];
        for(int i = 0; i < city + 100; i++) {
            for(int l = 0; l < city; l++) {
                for(int[] next : list[l]) {
                    if(result[l] == Long.MAX_VALUE) {
                        result[next[0]] = Long.MAX_VALUE;
                    }
                    if(result[l] != Long.MIN_VALUE &&  result[next[0]] < result[l] - next[1] + earn[next[0]]) {
                        result[next[0]] = Long.MAX_VALUE;
                    }
                }
            }
        }
        if(temp < result[end]) {
            System.out.println("Gee");
            return;
        }
        if(result[end] == Long.MIN_VALUE) {
            System.out.println("gg");
            return;
        } else {
            System.out.println(result[end]);
        }
    }

    public static void main(String[] args) {
        BJ1219 bj1219 = new BJ1219();
    }
}
