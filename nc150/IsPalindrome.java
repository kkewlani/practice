public class IsPalindrome {

    /**
     * Can also use Character.isLetterOrDigit
     */
    public boolean isPalindrome(String st) {
        if(st == null || st.length()==0) {
            return false;
        }

        String str = st.toLowerCase();
        int i=0, k=str.length()-1;
        while(i<k) {
            char s = str.charAt(i);
            char e = str.charAt(k);
            if(!isValidChar(s)) {
                i++;
                continue;
            } else if (!isValidChar(e)) {
                k--;
                continue;
            }
            if(s==e) {
                i++;
                k--;
            } else {
                return false;
            }
        }
        return true;
    }

    boolean isValidChar(char c) {
        System.out.println(c+" "+((c>=48 && c<=57) || (c>=97 && c<=122)));
        return (c>=48 && c<=57) || (c>=97 && c<=122);
    }

    public static void main(String[] args) {
        IsPalindrome i = new IsPalindrome();
        i.isPalindrome("ab");
    }


    /**
     * from NC
     *
     */
    public boolean isPalindromeV1(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
