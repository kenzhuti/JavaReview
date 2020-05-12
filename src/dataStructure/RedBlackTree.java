package dataStructure;

public class RedBlackTree {
    private final int R = 0;
    private final int B = 1;

    private Node root = null; // 红黑树的根结点

    class Node {
        int data; // 存的具体数字
        int color = R;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 插入
     * @param root
     * @param data
     */
    public void insert(Node root, int data) { // root节点一定不为空
        if (data > root.data) { // 表示插入右边
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        }
    }

    public void leftRotate(Node node) {
        if (node.parent == null) { // 根结点
            Node E = root;
            Node S = E.right;
            // 1. 移动S的左子树
            E.right = S.left;
            S.left.parent = E;
            // 2. 修改E的指针
            E.parent = S;
            S.parent = null;
            // 3. 修改S的指针
            S.parent = null;
        } else {
            // 如果有父节点，那么就要操作三个点
            if (node == node.parent.left) {
                node.parent.left = node.right; // 就是把S浮上来变成了新的左子树
            } else {
                node.parent.right = node.right;
            }
            node.right = node.right.left; // S点左子树的指针挂到了E点上面
            node.right.left.parent = node;

            node.right.parent = node.parent; // 修S节点的左子树指针
        }
    }

}
