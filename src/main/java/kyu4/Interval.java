package kyu4;

import java.util.Arrays;
import java.util.Comparator;

public class Interval {
    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int[][] merged = merge(intervals);
        int sum = 0;
        for (int i = 0; i < merged.length; i++) {
            sum += merged[i][1] - merged[i][0];
        }
        return sum;
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) return 1;
                else if (o1[0] < o2[0]) return -1;
                else return 0;
            }
        });

        int[][] merged = new int[intervals.length][2];
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if (currentStart == currentEnd) continue;
            if (currentStart <= end) {
                end = Math.max(currentEnd, end);
            } else {
                merged[i][0] = start;
                merged[i][1] = end;
                start = currentStart;
                end = currentEnd;
            }
        }
        merged[0][0] = start;
        merged[0][1] = end;
        return merged;
    }
}