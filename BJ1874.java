import java.util.*;

public class BJ1874 {

    public BJ1874(){
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        int[] list = new int[loop];
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < loop; i++){
            list[i] = sc.nextInt();
        }

        int now = 1;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < loop; i++){
            if(list[i] >= now){
                while(list[i] >= now){
                    stack.push(now++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if(n > list[i]){
                    System.out.println("NO");
                    return;
                } else {
                    bf.append("-\n");
                }
            }
        }
        System.out.println(bf.toString());
    }


    public static void main(String[] args) {
        BJ1874 bJ1874 = new BJ1874();
    }
}
