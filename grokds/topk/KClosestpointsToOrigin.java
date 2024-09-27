package topk;

import model.Point;

import java.util.*;
import java.util.stream.IntStream;

public class KClosestpointsToOrigin {
    public List<Point> findClosestPoints(Point[] points, int k) {
        // TODO: Write your code here

        if(points==null || points.length < k || k < 1) {
            return new ArrayList<>();
        }

        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k, (p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin() );

        IntStream.range(0, k).forEach(p -> maxHeap.offer(points[p]));

        IntStream.range(k,points.length).forEach( p -> {
            if(maxHeap.peek().distFromOrigin() > points[p].distFromOrigin()) {
                maxHeap.poll();
                maxHeap.offer(points[p]);
            }
        });

        return new ArrayList<Point>(maxHeap);
    }

}
