import java.util.ArrayList;
import java.util.List;

public class IntervalJointPoints {
    public static void main(String[] args) {
        Interval[] l1 = {new Interval(3, 8), new Interval(100, 150)};
        Interval[] l2 = {new Interval(2, 5), new Interval(7, 10), new Interval(120, 160)};
        List<Interval> result = findJointPoints(l1, l2);
        System.out.println(result.toString());
    }

    public static List<Interval> findJointPoints(Interval[] l1, Interval[] l2) {
        List<Interval> rs = new ArrayList<Interval>();
        if (l1 == null || l2 == null || l1.length == 0 || l2.length == 0)
            return rs;
        int i = 0;
        int j = 0;
        while (i < l1.length && j < l2.length) {
            if (isEarlier(l1[i], l2[j])) {
                if (l2[j].start >= l1[i].end) {
                    ++i;
                    continue;
                }
                rs.add(new Interval(l2[j].start, Math.min(l1[i].end, l2[j].end)));
                ++i;
            } else {
                if (l1[i].start >= l2[j].end) {
                    ++j;
                    continue;
                }
                rs.add(new Interval(l1[i].start, Math.min(l1[i].end, l2[j].end)));
                ++j;
            }
        }
        return rs;
    }

    static boolean isEarlier(Interval i1, Interval i2) {
        return i1.start < i2.start ? true : false;
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
}
