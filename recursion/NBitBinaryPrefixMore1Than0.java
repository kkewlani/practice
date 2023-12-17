import java.util.ArrayList;
import java.util.List;

/**
 * Give n, print binary number of n digits such that each prefix of the number should have more 1s than 0s
 */
public class NBitBinaryPrefixMore1Than0 {

    public List<String> binaryPrefixWithMore1(int n) {
        List<String> result = new ArrayList<>();
        if(n==0) {
            return result;
        } else if(n==1) {
            result.add("1");
        } else if (n==2) {
            result.add("11");
        } else {
            StringBuilder output = new StringBuilder("11");
            binaryMore1sHelper(n-2, output, result);
        }
        return result;
    }

    private void binaryMore1sHelper(int n, StringBuilder output, List<String> result) {
        if(n==0) {
            result.add(output.toString());
            return;
        }

        if(output.charAt(output.length()-1)=='1') {
            StringBuilder output1 = new StringBuilder(output);
            output1.append("0");
            binaryMore1sHelper(n-1, output1, result);
        }
        StringBuilder output2 = new StringBuilder(output);
        output2.append("1");
        binaryMore1sHelper(n-1, output2, result);
    }

    public static void main(String[] args) {
        NBitBinaryPrefixMore1Than0 bm1 = new NBitBinaryPrefixMore1Than0();
        bm1.binaryPrefixWithMore1(5).forEach(System.out::println);
    }
}
