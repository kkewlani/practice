package intervals;

import model.Interval;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public List<Interval> merge(Interval[] arr1, Interval[] arr2) {
        if(arr1==null || arr2==null || arr1.length==0 ||  arr2.length==0) {
            return new ArrayList<>();
        }
        List<Interval> result = new ArrayList<>();


        for(int i=0; i<arr2.length; i++) {
            Interval interval2 = arr2[i];
            int j = 0;
            //iterate through all the elements in first list till you find the position of intersection
            // condition - skip all intervals where end < i2.start
            while(j< arr1.length && arr1[j].end < interval2.start) {
                j++;
            }

            while(j<arr1.length && interval2.end >= arr1[j].start) {
                result.add(new Interval(Math.min(arr1[j].start,interval2.start),Math.min(arr1[j].end,interval2.end)));
                j++;
            }
        }

        return result;
    }
}
