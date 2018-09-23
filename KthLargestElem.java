public class KthLargestElem {
    public static void main(String[] args) {
        int[] ary = {6,5,0,2,4,7,8,9};
        for(int i=1; i<9; i++)
            System.out.print(kthLargestElem(ary, i) + " ");
    }

    public static int kthLargestElem(int[] ary, int k) {
        if (k < 0 || k > ary.length) return -1;
        return kthLargestElemRec(ary, 0, ary.length - 1, k);
    }

    public static int kthLargestElemRec(int[] ary, int s, int e, int k) {
        int pivot = partition(ary, s, e);
        if (pivot == (k - 1)) {
            return ary[pivot];
        }
        if (pivot < (k - 1)) {
            return kthLargestElemRec(ary, pivot+1, e, k);
        } else {
            return kthLargestElemRec(ary, s, pivot-1, k);
        }
    }

    static int partition(int[] ary, int s, int e) {
        int i = s - 1;
        int j;
        int pivotElem = ary[e];
        for (j = s; j<e; j++) {
            if (ary[j] > pivotElem) {
                ++i;
                swap(ary, i, j);
            }
        }
        swap(ary, i+1, e);
        return i+1;
    }

    static void swap(int[] ary, int i, int j) {
        int tmp = ary[i];
        ary[i] = ary[j];
        ary[j] = tmp;
    }
}
