/*
 * Get full schedule of meetings 
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingsFullSchedule {
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 5), new Interval(2, 9),
                new Interval(6, 7), new Interval(8, 10), new Interval(9, 12)};
        System.out.println(meetingRoomsRequired(intervals));

        getFullScheduleOfMeetingRooms(intervals);
    }
    
   public static void getFullScheduleOfMeetingRooms(Interval[] intervals) {
        int[] start_time = new int[intervals.length];
        int[] end_time = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            start_time[i] = intervals[i].start;
            end_time[i] = intervals[i].end;
        }
        Arrays.sort(start_time);
        Arrays.sort(end_time);
        getFullScheduleOfMeetingRooms(start_time, end_time);
    }    

    public static int meetingRoomsRequired(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int maxCount = 0;
        int curCount = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval interval: intervals) {
            if (pq.isEmpty()) {
                pq.add(interval.end);
                ++curCount;
            } else {
                if (interval.start >= pq.peek()) {
                    pq.poll();
                    --curCount;
                }
                pq.add(interval.end);
                ++curCount;
            }
            if (curCount > maxCount)
                maxCount = curCount;
        }
        return maxCount;
    }
    
    static void getFullScheduleOfMeetingRooms(int[] start_time, int[] end_time) {
        int start = 1;
        int rooms = 1;
        int i = 1;
        int j = 0;
        while(i < start_time.length && j < end_time.length) {
            if (start_time[i] < end_time[j]) {
                System.out.print("[" + start + "," + start_time[i] + "," + rooms + "] ");
                start = start_time[i];
                ++rooms;
                ++i;
            } else {
                System.out.print("[" + start + "," + end_time[j] + "," + rooms + "] ");
                start = end_time[j];
                --rooms;
                ++j;
            }
        }
        System.out.println();
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
