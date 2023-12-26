package intervals;

import model.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        if(intervals==null || intervals.length<2) {
            return true;
        }
        // sort intervals
        //Arrays.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        //compare adjacent
        for(int i = 0; i<intervals.length-1; i++ ) {
            Interval curr = intervals[i];
            Interval next = intervals[i+1];

            // if overlap return false
            if(next.start<curr.end) {
                return false;
            }
            // else keep comparing
        }
        //no overlap return true
        return true;
    }
}
