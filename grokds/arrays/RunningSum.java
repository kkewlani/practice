package arrays;

public class RunningSum {

    public static int[] runningSum(int[] values){
        if(values==null || values.length==0) {
            return new int[0];
        }
        int[] runningSum = new int[values.length];
        int sum = 0;
        for (int i=0; i < values.length; i++) {
            sum +=values[i];
            runningSum[i]=sum;
        }
        return runningSum;
    }

    public static void main(String[] args) {
        for (int i: runningSum(new int[]{1,1,1,1,1})) {
            System.out.print(i +" ");
        }
    }
}
