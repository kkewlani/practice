import java.util.*;

/**
 * String Encode and Decode
 * Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
 *
 * Please implement encode and decode
 *
 * Example 1:
 *
 * Input: ["neet","code","love","you"]
 *
 * Output:["neet","code","love","you"]
 * Example 2:
 *
 * Input: ["we","say",":","yes"]
 *
 * Output: ["we","say",":","yes"]
 * Constraints:
 *
 * 0 <= strs.length < 100
 * 0 <= strs[i].length < 200
 * strs[i] contains only UTF-8 characters.
 */

/**
 * Clarifying ques should be:
 * 1. are there only words? or can be sentences ?
 * 2. what special characters can be part fo the string?
 * 3. behavior when string is null and empty in input for decoding
 * 4. expected behavior with empty or null list
 * 5. Can empty string be part of the input list ?
 */

// This uses stringBuffer isEmpty method - available from Java15 +
public class StringEncodeDecode {
    public String encode(List<String> strs) {
        if(strs==null || strs.isEmpty()) {
            return null;
        }
        StringBuffer st = new StringBuffer();
        for (String str: strs) {
            st.append(str).append("|");
        }
        st.deleteCharAt(st.length()-1);
        return st.toString();
    }

    public List<String> decode(String str) {
        if(str == null) {
            return new ArrayList<String>();
        }
        if(str.length() == 0) {
            return Collections.singletonList("");
        }
        StringBuffer buf = new StringBuffer();
        List<String> result = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (c=='|') {
                result.add(buf.toString());
                buf = new StringBuffer();
            } else {
                buf.append(c);
            }
        }
        if(!buf.isEmpty()) {
            result.add(buf.toString());
            buf = new StringBuffer();
        }
        return result;
    }
}
