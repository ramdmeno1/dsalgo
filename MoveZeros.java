import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] ary = {0, 4, 0, 1, 5, 1, 0, 0};
        partition(ary);
        System.out.println(Arrays.toString(ary));
    }

    static void partition(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
            if (array[j] == 0 && i < j) {
                --j; continue;
            }
            if (array[i] == 0) {
                swap(array, i, j);
                --j;
            }
            ++i;
        }
    }

    static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }
}
