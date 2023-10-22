import java.util.HashMap;

public class StringUniChars {

    public boolean areAllUniqueChars(String str) {
        return solution1(str);
    }

    private boolean solution1(String str) {
        if (str==null || str.isEmpty()) {
            return false;
        }
        HashMap<Character, Integer> occurrenceMap = new HashMap();
        Integer occurrCount;
        for (char c : str.toCharArray()) {
            occurrCount = occurrenceMap.get(c);
            occurrenceMap.put(c,occurrCount==null? 1 : occurrCount++);
            if(!(occurrCount==null) && occurrCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringUniChars suc = new StringUniChars();
        System.out.println(suc.areAllUniqueChars("awldfogjkda"));
    }
}
