package intervals;

import model.Interval;

import java.util.*;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null || intervals.isEmpty()) {
            return Arrays.asList(newInterval);
        }
        List<Interval> mergedIntervals = new ArrayList<>();

        int i=0;
        // find the position of new interval while adding intervals to merge list
        // skip all intervals that have end < newInterval.start
        while(i< intervals.size() && intervals.get(i).end < newInterval.start) {
            mergedIntervals.add(intervals.get(i++));
        }

        // from this position start merge process
        // to merge newInterval.end > start
        while(i< intervals.size() && newInterval.end > intervals.get(i).start) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }

        // merge process complete - add interval to the merged list
        mergedIntervals.add(newInterval);

        // if any intervals remaining add them to merged lists
        while(i< intervals.size()) {
            mergedIntervals.add(intervals.get(i++));
        }

        return mergedIntervals;
    }


}
