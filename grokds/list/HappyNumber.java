package list;

import java.util.ArrayList;
import java.util.HashSet;

public class HappyNumber {

    public static boolean find(int num) {
        int slow = calculateDigitSquareSum(num);
        int fast = calculateDigitSquareSum(calculateDigitSquareSum(num));
        while(slow!=fast) {
            slow = calculateDigitSquareSum(slow);
            fast = calculateDigitSquareSum(calculateDigitSquareSum(fast));
        }
        if(slow==1) {
            return true;
        } else {
            return false;
        }

    }
    public static boolean find2(int num) {

        HashSet<Integer> sumSet = new HashSet<>();
        int sumOfsquares = num;
        sumSet.add(sumOfsquares);
        while(sumOfsquares!=1) {
            sumOfsquares = calculateDigitSquareSum(sumOfsquares);
            if(!sumSet.add(sumOfsquares)){
                return false;
            }
        }
        return true;
    }

    private static int calculateDigitSquareSum(int num) {
        ArrayList<Integer> digits = getDigits(num);
        int sumOfsquares = 0;
        for(int digit: digits) {
            sumOfsquares += (digit*digit);
        }
        return sumOfsquares;
    }

    private static ArrayList<Integer> getDigits(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        while(num != 0) {
            digits.add(num%10);
            num = num/10;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(12));
    }

}
