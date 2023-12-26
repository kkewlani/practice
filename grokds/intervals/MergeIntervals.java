package intervals;

import model.Interval;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size()<2) {
            return intervals;
        }

        List<Interval> mergedIntervals = new LinkedList<>();

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        Iterator<Interval> invlIterator = intervals.iterator();
        Interval interval = invlIterator.next();
        int start = interval.start;
        int end = interval.end;

        while(invlIterator.hasNext()) {
            interval = invlIterator.next();
            //overlaps
            if(interval.start <= end) {
                end = Math.max(end, interval.end);
            } else { // not overlap
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
}
