/**
 * One away edit strings - find if just one character change ( insert. update, remove) leads to other string
 */
public class OneAwayString {

    boolean isOneAway(String first, String second) {

        boolean foundDiff = false;
        boolean foundMiss = false;

        int index1 = 0, index2 = 0;

        String small = first.length()>second.length() ? second : first;
        String big = first.length()>second.length() ? first : second;

        while(index1 < small.length() && index2 < big.length()) {
            if(small.charAt(index1)!=big.charAt(index2)) {
                if(foundDiff) {
                    return false;
                }
                foundDiff = true;
                if(small.length()==big.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        OneAwayString o = new OneAwayString();
        System.out.println(o.isOneAway("pale", "ple"));
        System.out.println(o.isOneAway("pales", "pale"));
        System.out.println(o.isOneAway("pale", "bale"));
        System.out.println(o.isOneAway("pale", "bake"));
    }
}
