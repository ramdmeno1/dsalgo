//https://leetcode.com/problems/house-robber/description/

public class HouseRobber {
    public static void main(String[] args) {
        //int[] ary = {2,7,9,3,1};
        int[] ary = {2,1,1,2};
        System.out.println(rob(ary));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max = Math.max(nums[0], nums[1]);
        if (nums.length > 2) {
            int[] res = new int[nums.length];
            res[nums.length - 1] = nums[nums.length - 1];
            res[nums.length - 2] = nums[nums.length - 2];
            int i = nums.length - 3;
            while(i >= 0) {
                int j = i+2;
                while(j < nums.length) {
                    res[i] = Math.max(res[i], nums[i] + res[j]);
                    if (res[i] > max)
                        max = res[i];
                    j++;
                }
                --i;
            }
        }
        return max;
    }
}
