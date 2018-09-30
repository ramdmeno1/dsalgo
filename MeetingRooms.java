/*
 * Minimum number of meeting rooms needed
 * Find overlapping intervals
*/
import java.util.*;

public class MeetingRooms {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 5), new Interval(2, 9),
                new Interval(6, 7), new Interval(8, 10), new Interval(9, 12)};

        System.out.println(meetingRoomsRequired(intervals));
        List<List<Interval>> allOverlappingIntervals = overlappingIntervals(intervals);
        for (List<Interval> overlappingIntervals : allOverlappingIntervals) {
            System.out.println(overlappingIntervals.toString());
        }
    }

    public static int meetingRoomsRequired(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Point[] points = getPoints(intervals);
        int maxCount = 0;
        int curCount = 0;
        for (Point point : points) {
            if (point.isStart)
                ++curCount;
            else
                --curCount;
            if (curCount > maxCount)
                maxCount = curCount;
        }
        return maxCount;
    }

    public static List<List<Interval>> overlappingIntervals(Interval[] intervals) {
        List<List<Interval>> overlappingIntervals = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return overlappingIntervals;
        Point[] points = getPoints(intervals);
        int activeIntervalsCount = 0;
        List<Interval> currActiveIntervals = new ArrayList<>();
        for (Point point : points) {
            if (point.isStart) {
                ++activeIntervalsCount;
                currActiveIntervals.add(intervals[point.intervalId]);
            } else {
                --activeIntervalsCount;
                currActiveIntervals.remove(intervals[point.intervalId]);
            }
            if (activeIntervalsCount >= 2) {
                overlappingIntervals.add(new ArrayList<>(currActiveIntervals));
            }
        }
        return overlappingIntervals;
    }

    static Point[] getPoints(Interval[] intervals) {
        Point[] points = new Point[2 * intervals.length];
        int i = 0;
        for (int j = 0; j < intervals.length; j++) {
            points[i++] = new Point(intervals[j].start, true, j);
            points[i++] = new Point(intervals[j].end, false, j);
        }
        Arrays.sort(points, ((o1, o2) -> (o1.time - o2.time)));
        return points;
    }

    static class Point {
        int time;
        boolean isStart;
        int intervalId;

        Point(int time, boolean isStart, int intervalId) {
            this.time = time;
            this.isStart = isStart;
            this.intervalId = intervalId;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "time=" + time +
                    ", isStart=" + isStart +
                    ", intervalId=" + intervalId +
                    '}';
        }
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
}
