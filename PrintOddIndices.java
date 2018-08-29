package recursion;

public class PrintOddIndices {
    public static void main(String[] args) {
        int[] ary = {2,4,6,8,10,12};
        printOddIndices(ary);
    }

    public static void printOddIndices(int[] ary) {
        printOddIndicesHelper(ary, 0);
    }

    public static void printOddIndicesHelper(int[] ary, int i) {
        if (i >= ary.length) return;
        if ((i % 2) != 0)
            System.out.print(ary[i] + " ");
        printOddIndicesHelper(ary, ++i);
    }
}
