import java.util.*;

public class BJ1744 {

    public BJ1744() {
        PriorityQueue<Integer> minusQue = new PriorityQueue<>();
        PriorityQueue<Integer> plusQue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> zeroList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for(int i = 0; i < size; i++) {
            int input = sc.nextInt();
            if(input < 0) {
                minusQue.add(input);
            } else if (input == 0){
                zeroList.add(input);
            } else {
                plusQue.add(input);
            }
        }
        int result = 0;

        while(minusQue.size() > 1) {
            result += minusQue.poll() * minusQue.poll();
        }
        if(!minusQue.isEmpty()) {
            if(zeroList.isEmpty()) {
               result += minusQue.poll();
            }
        }

        while(plusQue.size() > 1) {
            int l = plusQue.poll();
            int r = plusQue.poll();
            int plus = l + r;
            int mul = l * r;
            if(plus > mul) {
                result += plus;
            } else {
                result += mul;
            }
        }
        if(!plusQue.isEmpty()) {
            result += plusQue.poll();
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BJ1744 bj1744 = new BJ1744();
    }
}
