package Arrays;

/**
 * @author jakadam on 2020-01-06
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example:
 *
 * Given [1,3],[2,6],[8,10],[15,18],
 *
 * return [1,6],[8,10],[15,18].
 *
 * Make sure the returned intervals are sorted.
 */


public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> a) {

        /*
            Sort the intervals based on their start and compare the end of lower interval with start of higher interval.
            If they overlap, compare the ends of both interval to determine the interval range.
        */
        Collections.sort(a, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });
        /*
            Alternative sorting logic
            Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        */

        int start =a.get(0).start;
        int end = a.get(0).end;

        ArrayList<Interval> res = new ArrayList<Interval>();


        int size=a.size();
        for(int i=1; i<size; i++){

            Interval cur=a.get(i);
            //if there is merge, compare end of first and second interval
            if(cur.start<=end)
                end=Math.max(cur.end, end);
            else{//there is no merge
                res.add(new Interval(start, end));
                start=cur.start;
                end=cur.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
/*
Tested on https://www.interviewbit.com/problems/merge-overlapping-intervals/
*/