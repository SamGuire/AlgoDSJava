package algorithms.greedy.interval;
import java.util.*;
public class IntervalAlgo {

    public class Schedule {
        public List<Interval> intervals;

        public Schedule() {
            this.intervals = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Interval interval : intervals) {
                String s = String.format("%d -> %d (%d), ",interval.start,interval.finish,interval.cost);
                sb.append(s);
            }
            return sb.toString();
        }


    }
    public class Interval {
        int start,finish,cost;
        public Interval(int start,int finish,int cost) {
            this.start = start;
            this.finish = finish;
            this.cost = cost;
        }
    }

    public IntervalAlgo(){}

    public Schedule maxSubsetOfNonOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        Schedule schedule = new Schedule();
        for (int[] interval : intervals) {
            Interval candidate = new Interval(interval[0],interval[1],0);
            if (schedule.intervals.size() == 0) {
                schedule.intervals.add(candidate);
            } else {
                Interval lastAdded = schedule.intervals.get(schedule.intervals.size()-1);
                if (lastAdded.finish <= candidate.start) {
                    schedule.intervals.add(candidate);
                }
            }
        }
        return schedule;
    }
}
