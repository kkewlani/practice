import java.util.ArrayList;
import java.util.List;

/**
 * Given  string create all permutations by changing character cases,  it also has digits in there
 */
public class PermutationWithCaseChange {

    public List<String> permuteWithCaseChange(String str) {
        List<String> result = new ArrayList<>();
        if(str == null || str.isEmpty()) {
            return result;
        }
        permuteHelper(new StringBuilder(str), new StringBuilder(), result);
        return result;
    }

    private void permuteHelper(StringBuilder input, StringBuilder output, List<String> permutedStrings) {
        if(input.length()==0) {
            permutedStrings.add(output.toString());
            return;
        }

        while(Character.isDigit(input.charAt(0))) {
            output.append(input.charAt(0));
            input.deleteCharAt(0);
        }

        StringBuilder output1 = new StringBuilder(output);
        StringBuilder output2 = new StringBuilder(output);
        output1.append(Character.toUpperCase(input.charAt(0)));
        output2.append(Character.toLowerCase(input.charAt(0)));



        input.deleteCharAt(0);
        permuteHelper(new StringBuilder(input), output1, permutedStrings);
        permuteHelper(new StringBuilder(input), output2, permutedStrings);

    }

    public static void main(String[] args) {
        PermutationWithCaseChange ps = new PermutationWithCaseChange();
        ps.permuteWithCaseChange("a327983b8474c").forEach(System.out::println);
    }

}
