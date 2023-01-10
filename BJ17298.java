import java.util.Scanner;
import java.util.Stack;

public class BJ17298 {


    public BJ17298(){
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        int[] list = new int[loop];
        int[] result = new int[loop];
        for (int i = 0; i < loop; i++) {
            list[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < loop; i++){
            while (!stack.isEmpty() && list[stack.peek()] < list[i]){
                result[stack.pop()] = list[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++){
            sb.append(result[i] + " ");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BJ17298 bj17298 = new BJ17298();
    }
}
