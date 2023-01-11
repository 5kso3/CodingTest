import java.util.Arrays;
import java.util.Scanner;

public class BJ2751 {

    private int[] list;

    public BJ2751(){
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        list = new int[loop];
        for(int i = 0; i < loop; i++){
            list[i] = sc.nextInt();
        }

        int[] result = margeSort(0, loop - 1);

        StringBuilder sb = new StringBuilder();
        for(int num : result){
            sb.append(num);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        BJ2751 bj2751 = new BJ2751();
    }

    private int[] margeSort(int s, int e) {
        if(s == e){
            int[] result = new int[1];
            result[0] = list[s];
            return result;
        }

        int[] result = new int[(e - s) + 1];
        int[] left = margeSort(s, (s + e) / 2);
        int[] right = margeSort((s + e)/2 + 1, e);
        int l = 0;
        int r = 0;
        for (int i = 0; i < e - s + 1; i++) {
            if(l == left.length) {
                result[i] = right[r++];
            } else if(r == right.length) {
                result[i] = left[l++];
            } else {
                if(left[l] > right[r]){
                    result[i] = right[r++];
                } else {
                    result[i] = left[l++];
                }
            }
        }
        return result;
    }
}
