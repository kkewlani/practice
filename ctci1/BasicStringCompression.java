/**
 * convert repeat characters to character with count in a given string and return only if the length reduced
 */
public class BasicStringCompression {

    public String compress(String s) {
        if(s == null || s.length()<3) {
            return s;
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index<s.length()) {
            char c = s.charAt(index);
            int count = 1;
            index++;
            while(index<s.length() && s.charAt(index)==c) {
                index++;
                count++;
            }
            sb.append(c).append(count);
        }
        if(s.length()<sb.length()) {
            return s;
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        BasicStringCompression sc = new BasicStringCompression();

        long start = System.nanoTime();
        System.out.println(sc.compress("aaddbbshslnfolhdldo"));
        long end = System.nanoTime();
        System.out.println("time took :" + (end-start));
    }
}
