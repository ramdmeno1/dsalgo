package recursion;

public class SubStrings {
    public static void main(String[] args) {
        String s = "ab";
        substrings(s);
        System.out.println();
        substringsRecur(s);
    }

    public static void substringsRecur(String s) {
        if (null == s || s.isEmpty()) return;
        substringsRecurHelper(s, 0, 1);
    }

    public static void substringsRecurHelper(String s, int i, int j) {
        if (i >= s.length()) return;
        if (j <= s.length())
            System.out.print(s.substring(i,j) + " ");
        if (j > s.length()) {
            substringsRecurHelper(s, i+1, i+2);
        } else {
            substringsRecurHelper(s, i, j+1);
        }
    }

    public static void substrings(String s) {
        if (null == s || s.isEmpty()) return;
        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<=s.length(); j++) {
                System.out.print(s.substring(i,j) + " ");
            }
        }
    }
}
