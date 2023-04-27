package algorithms.greedy.interval;

public class Client {
    public static void main(String[] args) {
        IntervalAlgo algo = new IntervalAlgo();
        int[][] intervals = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        IntervalAlgo.Schedule schedule = algo.maxSubsetOfNonOverlappingIntervals(intervals);
        System.out.println(schedule);
    }
}
