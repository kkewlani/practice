package slidingWindow;

public class MaxSumSubArrayK {
    public int findMaxSumSubArray(int k, int[] arr) {
        if(arr==null || k > arr.length) {
            return -1;
        }
        int windowStart = 0;
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
           windowSum += arr[windowEnd];
           if(windowEnd >= k-1) {
               maxSum = Math.max(maxSum, windowSum);
               windowSum -= arr[windowStart];
               windowStart++;
           }
        }
        return Math.max(maxSum, -1);
    }
}
