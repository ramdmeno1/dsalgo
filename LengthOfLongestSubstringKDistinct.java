import java.util.HashMap;
import java.util.Map;

/*
Input: s = "ababffzzeee", k = 2
Output: 3
Explanation: T is "ece" which its length is 3
 */
public class LengthOfLongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
        //System.out.println(lengthOfLongestSubstringKDistinct("ababffzzeee", 2));
    }

    public static int lengthOfLongestSubstringKDistinct(String str, int k) {
        if (null == str || str.isEmpty() || k == 0) return 0;
        int s = 0; int e = 0; int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> dict = new HashMap<>();
        while(e < str.length() && s <= e) {
            char ch = str.charAt(e);
            if (dict.containsKey(ch)) {
                dict.put(ch, dict.get(ch)+1);
            } else {
                dict.put(ch, 1);
            }
            while(dict.size() > k) {
                char ch1 = str.charAt(s);
                int count = dict.get(ch1);
                if (count == 1)
                    dict.remove(ch1);
                else
                    dict.put(ch1, --count);
                ++s;
                continue;
            }
            if ((e - s + 1) > maxLen) {
                maxLen = e - s + 1;
            }
            e++;
        }
        return maxLen;
    }
}
