import java.util.Arrays;

public class CheckAnagram {
    public static void main(String[] args) {
        System.out.println(checkContainsAnagram("teea", "atee"));
        System.out.println(checkContainsAnagram("friendship", "ned"));
    }

    public static boolean checkContainsAnagram(String input, String pattern) {
        if (null == input || null == pattern) return false;
        if (input.length() < pattern.length()) return false;
        pattern = getSortedString(pattern);
        int k = pattern.length();
        int i = 0;
        int j = i + k - 1;
        while(j < input.length()) {
            String inputSection = input.substring(i, j+1);
            if (isAnagrams(inputSection, pattern)) return true;
            ++i; ++j;
        }
        return false;
    }

    static boolean isAnagrams(String inputSection, String pattern) {
         return getSortedString(inputSection).equals(pattern);
    }

    static String getSortedString(String s) {
        if (null == s) return s;
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
