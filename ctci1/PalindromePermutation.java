/**
 * Figure out if the given string has a palindrome permutation
 */
public class PalindromePermutation {

    boolean isPermutationPalindrome(String s) {
        int[] charCount = new int[26];
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');
        for(char i : s.toCharArray()) {
            if(i>=a && i<=z) {
                charCount[i-a]++;
            } else if (i>=A && i<=Z) {
                charCount[i-A]++;
            }
        }
        boolean foundOdd = false;
        for(int i: charCount) {
            if(i%2 == 1) {
                if (foundOdd) {
                    return false;
                } else {
                    foundOdd = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        System.out.println(pp.isPermutationPalindrome("tacT CoA"));
    }
}
