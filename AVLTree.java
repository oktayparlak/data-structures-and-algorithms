public class AVLTree<T> {

    class AVLNode<Y> {

        public int key;
        public Y data;
        public AVLNode left;
        public AVLNode right;
        public int height;

        public AVLNode(Y data, int key) {
            this.data = data;
            this.key = key;
            left = null;
            right = null;
            height = 1;
        }

    }

    public AVLNode<T> root;

    public AVLTree() {
        root = null;
    }

    public int height(AVLNode<T> d) {
        if (d == null) {
            return 0;
        } else {
            return d.height;
        }
    }

    public AVLNode<T> rotateMyLeft(AVLNode<T> focus) {
        AVLNode<T> k = focus.left;
        focus.left = k.right;
        k.right = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode<T> rotateMyRight(AVLNode<T> focus) {
        AVLNode<T> k = focus.right;
        focus.right = k.left;
        k.left = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode<T> doubleRotateLeftSide(AVLNode focus) {
        focus.left = rotateMyRight(focus.left);
        return rotateMyLeft(focus);
    }

    public AVLNode<T> doubleRotateRightSide(AVLNode focus) {
        focus.right = rotateMyLeft(focus.right);
        return rotateMyRight(focus);
    }

    public int getBalance(AVLNode<T> focus) {
        if (focus == null) {
            return 0;
        }
        return Math.abs(height(focus.left) - height(focus.right));
    }

    public AVLNode<T> insert(AVLNode focus, T data, int key) {
        if (focus == null) {
            focus = new AVLNode(data, key);
        } else if (key < focus.key) {
            focus.left = insert(focus.left, data, key);
            if (getBalance(focus) == 2) {
                if (key < focus.left.key) {
                    focus = rotateMyLeft(focus);
                } else {
                    focus = doubleRotateLeftSide(focus);
                }
            }
        } else if (key > focus.key) {
            focus.right = insert(focus.right, data, key);
            if (getBalance(focus) == 2) {
                if (key > focus.right.key) {
                    focus = rotateMyRight(focus);
                } else {
                    focus = doubleRotateRightSide(focus);
                }
            }
        } else {
            // key is equal to focus.key, update data
            focus.data = data;
        }

        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        return focus;
    }

    public void insert(T data, int key) {
        root = insert(root, data, key);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(AVLNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data + " ");
        }
    }

    public boolean searchInTree(T data) {
        return searchInTree(root, data);
    }

    private boolean searchInTree(AVLNode node, T data) {

        if (node != null) {
            if (node.data.equals(data)) {
                return true;
            } else {
                if((searchInTree(node.left, data)) ||(searchInTree(node.right, data))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteInTree(T data) {
        deleteInTree(root, data);
    }

    private void deleteInTree(AVLNode node, T data) {

        if (node != null) {
            if (node.data == data) {
                node.data = null;
                System.out.println("Data deleted!");
            } else {
                if((searchInTree(node.left, data)) ||(searchInTree(node.right, data))) {
                    node.data = null;
                    System.out.println("Data deleted!");
                }
            }
        }
    }

}
