import java.util.ArrayList;
import java.util.Scanner;

public class BJ1541 {

    ArrayList<Integer> nums;
    ArrayList<Character> sign;

    public BJ1541() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String temp = "";
        nums = new ArrayList<>();
        sign = new ArrayList<>();
        sign.add('+');

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '-') {
                nums.add(Integer.parseInt(temp));
                temp = "";
                sign.add('-');
            } else if (line.charAt(i) == '+') {
                nums.add(Integer.parseInt(temp));
                temp = "";
                sign.add('+');
            } else {
                temp += line.charAt(i);
            }
        }
        nums.add(Integer.parseInt(temp));
        int result = 0;

        for (int i = 0; i < nums.size(); i++) {
            if(sign.get(i) == '-') {
                int minus = nums.get(i);
                i++;
                if(i < sign.size()) {
                    while(sign.get(i) != '-') {
                        minus += nums.get(i);
                        i++;
                        if(i >= sign.size()) {
                            break;
                        }
                    }
                }
                i--;
                result -= minus;
            } else {
                result += nums.get(i);
            }
        }

        System.out.println(result);
    }


    public static void main(String[] args) {
        BJ1541 bj1541 = new BJ1541();
    }
}
