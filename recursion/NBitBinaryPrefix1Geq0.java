import java.util.ArrayList;
import java.util.List;

/**
 * Give n, print binary number of n digits such that each prefix of the number should have more 1s than 0s
 */
public class NBitBinaryPrefix1Geq0 {

    public List<String> binaryPrefixWith1Geq0(int n) {
        List<String> result = new ArrayList<>();
        if(n==0) {
            return result;
        }
        binary1Geq0Helper(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void binary1Geq0Helper(int n, int oCount, int zCount, StringBuilder output, List<String> result) {
        if(n==0) {
            result.add(output.toString());
            return;
        }

        if(oCount>zCount) {
            StringBuilder output1 = new StringBuilder(output);
            output1.append("0");
            binary1Geq0Helper(n-1, oCount, zCount+1, output1, result);
        }
        StringBuilder output2 = new StringBuilder(output);
        output2.append("1");
        binary1Geq0Helper(n-1, oCount+1, zCount, output2, result);
    }

    public static void main(String[] args) {
        NBitBinaryPrefix1Geq0 bm1 = new NBitBinaryPrefix1Geq0();
        bm1.binaryPrefixWith1Geq0(3).forEach(System.out::println);
    }
}
