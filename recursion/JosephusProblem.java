import java.util.ArrayList;

/**
 * Given n and k , assume a list of n numbers and k as the index to be removed from this list till only one
 * element remains. Return the Position (starting form 1) of last element remaining as the answer
 */
public class JosephusProblem {

    public int getLastStandingNumber(int n, int k) {
        ArrayList<Integer> elements = new ArrayList<>(n);
        for(int i=0; i<n; i++) {
            elements.add(i+1);
        }
        return getLastStandingHelper(elements, k-1, 0);
    }

    private int getLastStandingHelper(ArrayList<Integer> elements, int k, int index) {
        if(elements.size() == 1) {
            return elements.get(0);
        }
        index = (index+k)%elements.size();
        elements.remove(index);
        return getLastStandingHelper(elements, k, index);
    }

    public static void main(String[] args) {
        JosephusProblem jp = new JosephusProblem();
        System.out.println(jp.getLastStandingNumber(5,2));
    }

}
