import java.util.ArrayList;
import java.util.List;

/**
 * Given n create combination of balanced parentheses
 */
public class BalancedParentheses {


    public List<String> generateBalancedParentheses(int n) {
        List<String> result = new ArrayList<>();
        parenthesesHelper2(n,n,new StringBuilder(),result);
        return result;
    }

    private void parenthesesHelper(int open, int close, StringBuilder output, List<String> balancedParentheses) {
        if(open == 0 && close == 0) {
            balancedParentheses.add(output.toString());
            return;
        }

        if(open>0) {
            if(open<close) {
                StringBuilder output2 = new StringBuilder(output);
                output2.append(")");
                parenthesesHelper(open, close-1, output2, balancedParentheses);
            }

            StringBuilder output1 = new StringBuilder(output);
            output1.append("(");
            parenthesesHelper(open-1, close, output1, balancedParentheses);
        } else {
            StringBuilder output2 = new StringBuilder(output);
            output2.append(")");
            parenthesesHelper(open, close-1, output2, balancedParentheses);
        }

        //use open or close
        if(open<close && open>0) {
            StringBuilder output1 = new StringBuilder(output);
            output1.append("(");
            parenthesesHelper(open-1, close, output1, balancedParentheses);

            StringBuilder output2 = new StringBuilder(output);
            output2.append(")");
            parenthesesHelper(open, close-1, output2, balancedParentheses);
        } else if (open==close && open > 0) {
            //can only append open
            StringBuilder output1 = new StringBuilder(output);
            output1.append("(");
            parenthesesHelper(open-1, close, output1, balancedParentheses);

        } else if (open==0 && close>0) {
            StringBuilder output2 = new StringBuilder(output);
            output2.append(")");
            parenthesesHelper(open, close-1, output2, balancedParentheses);
        }
    }

    //Optimized if else
    private void parenthesesHelper2(int open, int close, StringBuilder output, List<String> balancedParentheses) {
        if(open == 0 && close == 0) {
            balancedParentheses.add(output.toString());
            return;
        }

        if(open!=0) {
            StringBuilder output1 = new StringBuilder(output);
            output1.append("(");
            parenthesesHelper2(open-1, close, output1, balancedParentheses);
        }
        if(open<close) {
            StringBuilder output2 = new StringBuilder(output);
            output2.append(")");
            parenthesesHelper2(open, close-1, output2, balancedParentheses);
        }
    }

    public static void main(String[] args) {
        BalancedParentheses b = new BalancedParentheses();
        b.generateBalancedParentheses(3).forEach(System.out::println);
    }
}
