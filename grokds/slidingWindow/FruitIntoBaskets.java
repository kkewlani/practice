package slidingWindow;

import java.util.HashMap;

public class FruitIntoBaskets {
    public int findLength(char[] arr) {
        int k =2;
        if(arr==null || arr.length==0) {
            return 0;
        }
        int maxLength = 0;
        HashMap<Character, Integer> fruitCount = new HashMap<>();
        int windowStart=0;
        for(int windowEnd=0; windowEnd<arr.length; windowEnd++) {
            char curr = arr[windowEnd];
            fruitCount.put(curr, fruitCount.getOrDefault(curr, 0)+1);

            while(fruitCount.size()>k) {

                //reduce frequency and if 0 then remove from map
                char firstFruit = arr[windowStart];
                int firstFruitFreq = fruitCount.get(firstFruit);
                if(firstFruitFreq-1 == 0) {
                    fruitCount.remove(firstFruit);
                } else {
                    fruitCount.put(firstFruit, firstFruitFreq-1);
                }

                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        FruitIntoBaskets f = new FruitIntoBaskets();
        System.out.println(f.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
    }
}
