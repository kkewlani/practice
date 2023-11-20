public class SparseSearch {
    public static int sparseWordSearch(String[] words, String target) {
        if(words==null || words.length==0 || target==null || target.isEmpty()) {
            return -1;
        }

        int start=0, end= words.length-1;
        while(start<=end) {
            int mid = (start+end)/2;
            //figure out the middle word
            if(words[mid].isEmpty()) {
                //find mid
                int left = mid-1;
                int right = mid+1;
                while(left<right) {
                    if(left>=start && !words[left].isEmpty()){
                        mid=left;
                        break;
                    } else if(right<=end && !words[right].isEmpty()){
                        mid=right;
                        break;
                    } else {
                        left--;
                        right++;
                    }
                }
            }

            //word comparison
            String middle = words[mid];
            if(target.equals(middle)) {
                return mid;
            } else if (target.compareTo(middle) > 0) {
                start=mid+1;
            } else {
                end = mid-1;
            }
        }

        return target.equals(words[end]) ? end : -1;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"at","","","","ball","","car","","","dad","","","yo"};
        System.out.println("output: "+sparseWordSearch(words, "yo"));
    }
}
