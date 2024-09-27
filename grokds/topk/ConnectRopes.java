package topk;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class ConnectRopes {

    public int minimumCostToConnectRopes(int[] ropeLengths) {
        if(ropeLengths == null || ropeLengths.length <1) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        IntStream.range(0,ropeLengths.length).forEach(i -> minHeap.offer(ropeLengths[i]));
        int cost = 0;
        while (minHeap.size()>1) {
            int newConnectCost = minHeap.poll() + minHeap.poll() ;
            cost += newConnectCost;
            minHeap.offer(newConnectCost);
        }

        return cost;
    }
}
