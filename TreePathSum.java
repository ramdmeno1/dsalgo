public class TreePathSum {
    private int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreePathSum obj = new TreePathSum();
        System.out.println(obj.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        maxPathSum0(root);
        return max;
    }

    public int maxPathSum0(TreeNode root) {
        if (root == null) return 0;
        int leftVal = maxPathSum0(root.left);
        int rightVal = maxPathSum0(root.right);
        int lr = leftVal + root.val;
        int rr = rightVal + root.val;
        int lrr = leftVal + root.val + rightVal;
        int retVal = Math.max(root.val, Math.max(lr, rr));
        max = Math.max(max, Math.max(retVal, lrr));
        return retVal;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
