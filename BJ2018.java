import java.util.Scanner;

public class BJ2018 {

    int loop;
    int[] numList;
    int start, end;
    int result;

    public BJ2018() {
        result = 1;
        Scanner sc = new Scanner(System.in);
        loop = sc.nextInt();
        numList = new int[loop];

        if(loop == 1){
            System.out.println(1);
            return;
        } else {
            for (int i = 0; i < loop; i++) {
                numList[i] = i + 1;
            }
            int sum = numList[0];
            start = 0;
            end = 0;
            while(start != loop - 1 || end != loop - 1) {
                if(sum < loop){
                    if(end != loop - 1){
                        sum += numList[++end];
                    }
                } else if (sum == loop){
                    result++;
                    if( end != loop - 1) {
                        sum += numList[++end];
                    }
                } else {
                    if(start != loop - 1){
                        sum -= numList[start++];
                    }
                }
            }

            System.out.println(result);
        }


    }

    public static void main(String[] args){
        BJ2018 bj2018 = new BJ2018();
    }

}
