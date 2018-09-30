import java.util.Arrays;

public class MeetingBandwidth {
    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 5, 50),
                new Interval(6, 7, 20),
                new Interval(2, 9, 100),
                new Interval(8, 10, 80),
                new Interval(9, 12, 200)};
        System.out.println(getMaxBandwidth(intervals));
    }

    public static int getMaxBandwidth(Interval[] intervals) {
        int[][] start_time = new int[intervals.length][2];
        int[][] end_time = new int[intervals.length][2];

        for(int i=0; i<intervals.length; i++) {
            start_time[i][0] = intervals[i].start;
            start_time[i][1] = intervals[i].bandwidth;
            end_time[i][0] = intervals[i].end;
            end_time[i][1] = intervals[i].bandwidth;
        }
        Arrays.sort(start_time, ( (int[] o1, int[] o2) -> (o1[0] - o2[0]) ));
        Arrays.sort(end_time, ( (int[] o1, int[] o2) -> (o1[0] - o2[0]) ));
        return getMaxBandwidth(start_time, end_time);
    }

    static int getMaxBandwidth(int[][] start_time, int[][] end_time) {
        int i = 1;
        int j = 0;
        int maxBandwidth = start_time[0][1];
        int curMaxBandwidth = start_time[0][1];
        while(i < start_time.length) {
            if (start_time[i][0] > end_time[j][0]) {
                curMaxBandwidth -= end_time[j][1];
                ++j;
            } else {
                curMaxBandwidth += start_time[i][1];
                ++i;
            }
            if (curMaxBandwidth > maxBandwidth)
                maxBandwidth = curMaxBandwidth;
        }
        return maxBandwidth;
    }

    static class Interval {
        int start;
        int end;
        int bandwidth;

        Interval(int start, int end, int bandwidth) {
            this.start = start;
            this.end = end;
            this.bandwidth = bandwidth;
        }
    }
}
