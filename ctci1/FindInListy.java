public class FindInListy {

    class Listy {
        private int size;
        int[] arr;

        public Listy(int size){
            this.size = size;
            arr = new int[size];
        }

        public int elementAt(int index) {
            if(index>=size) {
                return -1;
            } else {
                return arr[index];
            }
        }
    }


    public static int findNumber(Listy listy, int target) {
        if(listy==null || listy.elementAt(0)==-1) {
            return -1;
        }
        int end = 1;
        while(listy.elementAt(end)==-1 && listy.elementAt(end)<target) {
            end = end*2;
        }

        int start = 0;

        while(start<=end) {
            int mid = (start+end)/2;
            int middle = listy.elementAt(mid);
            if(middle==-1 && target<middle) {
                end = mid - 1;
            } else if(target>middle) {
                start = mid+1;
            } else {
                return mid;
            }
        }

        return listy.elementAt(end)==target ? end : -1;

    }

}
