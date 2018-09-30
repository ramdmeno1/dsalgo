package stack;
import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int[] ary = {2,1,5,6,2,3};
        //int[] ary = {2,4};
        System.out.println(largestRectangleArea(ary));
    }

    public static int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        st.push(0);
        int max = 0;
        int i;
        for(i=1; i< heights.length; i++) {
            if (heights[i] >= heights[st.peek()]) {
                st.push(i);
                continue;
            }
            while(st.peek() != -1 && heights[i] <= heights[st.peek()]) {
                int top = st.pop();
                int area = (i - st.peek() - 1) * heights[top];
                if (area > max)
                    max = area;
            }
            st.push(i);
        }
        while(st.peek() != -1) {
            int top = st.pop();
            int area = (i - st.peek() - 1) * heights[top];
            if (area > max)
                max = area;
        }
        return max;
    }
}
