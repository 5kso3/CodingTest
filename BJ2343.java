import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BJ2343 {

    public BJ2343() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
            end = end + A[i];
        }
        start = A[A.length - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for(int i = 0; i < N; i++){
                if(sum + A[i] > mid){
                    count++;
                    sum = 0;
                }
                sum = sum + A[i];
            }
            if(sum != 0) {
                count++;
            }
            if(count > M){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }

    public static void main(String[] args) {
        BJ2343 bj2343 = new BJ2343();
    }
}
