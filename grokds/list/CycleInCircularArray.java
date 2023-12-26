package list;

public class CycleInCircularArray {

    public boolean loopExists(int[] arr) {
        for(int i : arr) {
            if(hasValidLoop(arr, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasValidLoop(int[] arr, int index) {
        int n = arr.length;
        int nextIndex = index % n;
        int start = arr[nextIndex];
        if(start==0) {
            return false;
        }

        boolean forwardMoving = start > 0;
        int maxTry = n * 2;
        int slow = start , fast = start ;
        int slowIndex = nextIndex, fastIndex = nextIndex;
        while(maxTry>0) {
            slowIndex = (n + slow + slowIndex) % n;
            slow = arr[slowIndex];
            fastIndex = (n + fast + fastIndex) % n;
            if(isOppositeMove(arr[fastIndex], forwardMoving)) {
                return false;
            }
            fast = arr[(n + arr[fastIndex] + fastIndex) % n];
            if(isOppositeMove(slow, forwardMoving) || isOppositeMove(fast, forwardMoving)) {
                return false;
            }
            if(slow==fast && start==slow) {
                return true;
            }

            maxTry--;
        }
        return false;
    }

    private boolean isOppositeMove(int value, boolean isForward) {
        return (value>0 && !isForward)||(value < 0 && isForward);
    }



    public boolean simpleSolution(int[] arr) {
        for(int i =0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0;
            int slow = i;
            int fast = i;

            do {
                slow = findNextIndex(arr, isForward, slow);
                fast = findNextIndex(arr, isForward, fast);
                if(fast!=-1) {
                    fast = findNextIndex(arr, isForward, fast);
                }
            } while(slow!=-1 && fast!=-1 && slow!=fast);

            if (slow!=-1 && slow==fast) {
                return true;
            }

        }

        return false;
    }
    private int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction =  arr[currentIndex] >= 0;
        if(direction != isForward) {
            return -1;
        }
        int nextIndex = (arr[currentIndex] + currentIndex ) % arr.length;
        if(nextIndex < 0) {
            nextIndex += arr.length;
        }

        if(currentIndex==nextIndex) {
            return -1;
        }
        return nextIndex;
    }

}
