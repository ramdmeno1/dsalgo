import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] ary = {0,0,0,0};
        List<List<Integer>> rs = threeSum(ary);
        for(List<Integer> el : rs) {
            System.out.println(el.toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if (null == nums || nums.length <= 2) return rs;
        Arrays.sort(nums);
        int len = nums.length;
        Set<String> foundTuples = new HashSet<String>();
        for (int i=0; i < len - 2; i++) {
            Integer[] tmp = twoSum(nums, -nums[i], i+1, len - 1);
            if (null != tmp && tmp.length == 3) {
                Arrays.sort(tmp);
                String key = String.valueOf(tmp[0] + tmp[1] + tmp[2]);
                if (!foundTuples.contains(key)) {
                    rs.add(Arrays.asList(tmp));
                    foundTuples.add(key);
                }
            }
        }
        return rs;
    }

    static Integer[] twoSum(int[] nums, int target, int s, int e) {
        int i = s;
        int j = e;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target)
                ++i;
            else if (sum > target)
                --j;
            else {
                return new Integer[] {-target, nums[i], nums[j]};
            }
        }
        return null;
    }
}
