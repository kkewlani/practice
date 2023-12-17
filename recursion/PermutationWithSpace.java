import java.util.ArrayList;
import java.util.List;

/**
 * Given any string crete permutations by adding spaces in between characters
 */
public class PermutationWithSpace {

    public List<String> permuteWithSpace(String str) {

        List<String> result = new ArrayList<>();
        if(str.length()==0) {
            return result;
        }

        StringBuilder input = new StringBuilder(str);
        StringBuilder output = new StringBuilder();
        output.append(input.charAt(0));
        input.deleteCharAt(0);

        permuteHelper(input, output, result);

        return result;
    }

    private void permuteHelper(StringBuilder input, StringBuilder output, List<String> permutedStrings) {
        if(input.length() ==  0) {
            permutedStrings.add(output.toString());
            return;
        }

        StringBuilder op1 = new StringBuilder(output);
        StringBuilder op2 = new StringBuilder(output);

        op1.append(input.charAt(0));
        op2.append(" ").append(input.charAt(0));

        StringBuilder ip1 = input.deleteCharAt(0);
        StringBuilder ip2 = new StringBuilder(input);

        permuteHelper(ip1, op1, permutedStrings);
        permuteHelper(ip2, op2, permutedStrings);
    }

    public static void main(String[] args) {
        PermutationWithSpace ps = new PermutationWithSpace();
        ps.permuteWithSpace("abc").forEach(System.out::println);
    }
}
