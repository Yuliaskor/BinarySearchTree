import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    Node root;

    public class Node {
        T value;
        Node left, right;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }

    }

    private Node insertRec(Node node, T value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value.compareTo(node.value) < 0) {
            node.left = insertRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    public void insert(T value) {
        root = insertRec(root, value);
    }

    private T minValue(Node node) {
        T minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    private Node deleteRec(Node node, T value) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.value) < 0) {
            node.left = deleteRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = deleteRec(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.value = minValue(node.right);
            node.right = deleteRec(node.right, node.value);
        }
        return node;
    }

    public void delete(T value) {
        root = deleteRec(root, value);
    }

    private Node upperRec(Node node, T findElement) {
        if (node == null) {
            return null;
        }
        if (findElement.compareTo(node.value) == 0) {
            return node;
        }
        if (findElement.compareTo(node.value) < 0) {
            Node min = upperRec(node.left, findElement);
            if (min == null) {
                return node;
            }
            return min.value.compareTo(node.value) < 0 ? min : node;
        }
        if (findElement.compareTo(node.value) > 0) {
            return upperRec(node.right, findElement);
        }
        return null;
    }

    public T upper(T FindElement) {
        return upperRec(root, FindElement).value;
    }

    private Node lowerRec(Node node, T findElement) {
        if (node == null) {
            return null;
        }
        if (findElement.compareTo(node.value) == 0) {
            return node;
        }
        if (findElement.compareTo(node.value) < 0) {
            return lowerRec(node.left, findElement);

        }
        if (findElement.compareTo(node.value) > 0) {
            Node max = lowerRec(node.right, findElement);
            if (max == null) {
                return node;
            }
            return max.value.compareTo(node.value) > 0 ? max : node;
        }
        return null;
    }

    public T lower(T FindElement) {
        return lowerRec(root, FindElement).value;
    }

    private void postorder(Node node, ArrayList<T> list) {
        if (node == null) {
            return;
        }
        postorder(node.left, list);
        postorder(node.right,list);
        list.add(node.value);
    }

    public ArrayList<T> postorder() {
        ArrayList<T> list = new ArrayList<>();
        postorder(root, list);

        return list;
    }

    private void inorder(Node node, ArrayList<T> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.value);
        inorder(node.right, list);
    }

    public ArrayList<T> inorder() {
        ArrayList<T> list = new ArrayList<>();
        inorder(root, list);
        System.out.println(list);
        return list;
    }

    private void preorder(Node node, ArrayList<T> list) {
        if (node == null) {
            return;
        }
        list.add(node.value);
        preorder(node.left, list);
        preorder(node.right,list);
    }

    public ArrayList<T> preorder() {
        ArrayList<T> list = new ArrayList<>();
        preorder(root, list);
        System.out.println(list);
        return list;
    }
}
