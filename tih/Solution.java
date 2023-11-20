class Solution {
    //private static lowerAlphabets
    public static boolean isPalindrome(String s) {
        if(s==null || s.length()==0) {
            return false;
        }
        char[] chars = s.toLowerCase().toCharArray();
        int start = 0, end = chars.length-1, alphabetCount = 0;
        while(start<end) {
            System.out.println("start:"+chars[start]+",end:"+chars[end]);
            while(start<end && !isAlphabet(chars[start])) {
                start++;
            }
            while(start<end && !isAlphabet(chars[end])) {
                end--;
            }


            System.out.println(chars[start]+"!="+chars[end]+", result:"+(chars[start]!=chars[end]));
            if(chars[start]!=chars[end]) {
                return false;
            }
            start++;
            end--;
            System.out.println("start:"+start+",end:"+end);
        }
        return true;
    }

    private static boolean isAlphabet(char c) {
        int charVal = c;
        System.out.println("char:"+c+",val:"+charVal);
        if(c>=97 && c<=122) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    
}
