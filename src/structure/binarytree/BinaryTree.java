package structure.binarytree;

/**
 * BinaryTree binaryTree = new BinaryTree();
 * binaryTree.insert(7);
 * binaryTree.insert(4);
 * binaryTree.insert(9);
 * binaryTree.insert(1);
 * binaryTree.insert(6);
 * binaryTree.insert(8);
 * binaryTree.insert(10);
 */
public class BinaryTree {

    //根节点
    private TreeNode root;

    public void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
            return;
        }
        //最新的爹节点
        TreeNode current = root;
        while (true) {
            //如果我们的插入的值小于节点的值，就往节点左侧塞，否则往右侧塞
            if (value < current.val) {
                if (current.left == null) {
                    //如果发现左侧没了，那就将本节点作为新的左侧父节点
                    current.left = node;
                    break;
                }
                //否则继续往下找
                current = current.left;
            } else {
                //采用和左侧一样的方式
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

    public void PreorderTraversal(){
        PreorderTraversal(root);
    }

    public void MidTraversal(){
        MidTraversal(root);
    }

    public void PostTraversal(){
        PostTraversal(root);
    }
    //递归遍历
    //前序遍历(先访问根节点，再遍历左子树，再遍历右子树)
    public void PreorderTraversal(TreeNode node) {

        if (node == null) {
            return;
        }
        //根节点
        System.out.println(node.val);
        //左树
        PreorderTraversal(node.left);
        //右树
        PreorderTraversal(node.right);
    }

    //中序遍历(先遍历左子树，再访问根节点，再遍历右子树)
    public void MidTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        MidTraversal(node.left);
        System.out.println(node.val);
        MidTraversal(node.right);
    }

    //后序遍历(先遍历左子树，然后遍历右子树，最后访问树的根节点)
    public void PostTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        PostTraversal(node.left);
        PostTraversal(node.right);
        System.out.println(node.val);
    }


    //节点
    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
