package slidingWindow;

public class SmallestSubArrayGreaterSum {

    /**
     * Brute Force Approach
     */
    public int findMinSubArray2(int sum, int[] arr) {
       if(arr==null) {
           return -1;
       }

       int minWindowSize = Integer.MAX_VALUE;
       for(int i=0;i<arr.length;i++) {
           int windowSum = 0;
           int windowStart = i;
           while(windowSum<sum && windowStart<arr.length) {
               windowSum +=arr[windowStart];
               windowStart++;
           }
           if(windowSum>=sum) {
               minWindowSize = Math.min(windowStart-i, minWindowSize);
           }
           System.out.println("i:"+i+", minWindowSize:"+ minWindowSize);

       }


        return minWindowSize==Integer.MAX_VALUE ? -1 : minWindowSize;
    }

    //Sliding Window style
    public int findMinSubArray(int sum, int[] arr) {
        if(arr==null) {
            return -1;
        }

        int minWindowSize = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;
        for(int windowEnd=0; windowEnd<arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while(windowSum>=sum && windowStart<=windowEnd) {
                minWindowSize = Math.min(minWindowSize, windowEnd-windowStart+1);
                windowSum -=arr[windowStart];
                windowStart++;
            }
        }
        return minWindowSize==Integer.MAX_VALUE ? 0 : minWindowSize;
    }

    public static void main(String[] args) {
        SmallestSubArrayGreaterSum s = new SmallestSubArrayGreaterSum();
        s.findMinSubArray(7,new int[]{2,1,5,2,3,2});
    }
}
