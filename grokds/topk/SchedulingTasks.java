package topk;

import java.sql.Array;
import java.util.*;

/**
 * You are given a list of tasks that need to be run, in any order, on a server. Each task will take one CPU interval to execute but once a task has finished, it has a cooling period during which it can’t be run again. If the cooling period for all tasks is ‘K’ intervals, find the minimum number of CPU intervals that the server needs to finish all tasks.
 *
 * If at any time the server can’t execute any task then it must stay idle.
 *
 * Input: [a, a, a, b, c, c], K=2
 * Output: 7
 * Explanation: a -> c -> b -> a -> c -> idle -> a
 *
 *
 * Input: [a, b, a], K=3
 * Output: 5
 * Explanation: a -> b -> idle -> idle -> a
 *
 */
public class SchedulingTasks {
    public int scheduleTasks(char[] tasks, int k) {
        if(tasks==null || k < 0) {
            return -1;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for(int i =0; i< tasks.length; i++) {
            frequency.put(tasks[i], frequency.getOrDefault(tasks[i], 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue()-e1.getValue());

        maxHeap.addAll(frequency.entrySet());

        int count = 0;

        while(!maxHeap.isEmpty()) {
            ArrayList<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int gap = k+1;
            for(; gap>0 && !maxHeap.isEmpty(); gap--) {
                count++;
                Map.Entry<Character, Integer> curr = maxHeap.poll();
                if(curr.getValue() > 1) {
                    curr.setValue(curr.getValue()-1);
                    waitList.add(curr);
                }
            }
            maxHeap.addAll(waitList);
            if(!maxHeap.isEmpty()){
                count+=gap;
            }
        }

        return count;
    }
}
