package study.java.datastructure.algo.ds;

public class BinaryTreeMain {

    private Node root;

    public static void main(String[] args) {
        BinaryTreeMain theTree = new BinaryTreeMain();

        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice Pres");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(35, "Chief Tech");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesman 1");

        theTree.inOrderTraversal(theTree.root);
//
//        System.out.println(theTree.findNode(21));
    }

//    public void addNode(int key, String name) {
//        Node newNode = new Node(key, name);
//        Node focusNode = root;
//        Node parent;
//
//        if (root == null) {
//            root = newNode;
//            return;
//        }
//
//        while (true) {
//            parent = focusNode;
//
//            if (newNode.getKey() < parent.getKey()) {
//                focusNode = focusNode.getLeftChild();
//
//                if (focusNode == null) {
//                    parent.setLeftChild(newNode);
//                    return;
//                }
//            } else if (newNode.getKey() > parent.getKey()) {
//                focusNode = focusNode.getRightChild();
//
//                if (focusNode == null) {
//                    parent.setRightChild(newNode);
//                    return;
//                }
//            }
//        }
//    }

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
            return;
        }

        Node focusNode = root;
        Node parent;

        while (true) {
            parent = focusNode;

            if (key < parent.getKey()) {
                focusNode = focusNode.getLeftChild();

                if (focusNode == null) {
                    parent.setLeftChild(newNode);
                    return;
                }
            } else if (key > parent.getKey()) {
                focusNode = focusNode.getRightChild();

                if (focusNode == null) {
                    parent.setRightChild(newNode);
                    return;
                }
            }
        }
    }

    public boolean removeNode(int key) {
        // Find the node to be replaced using the key value
        Node parent = root;
        Node focusNode = root;

        // We need to boolean value to keep track of whether the focusNode is on the left or right in order to set
        // the parent.leftChild or rightChild value later to the replacement value.
        Boolean leftChild = true;

        while (focusNode.getKey() != key) {
            parent = focusNode;

            if (key < focusNode.getKey()) {
                leftChild = true;
                focusNode = focusNode.getLeftChild();
            }
            else {
                leftChild = false;
                focusNode = focusNode.getRightChild();
            }

            if (focusNode == null)
                return false;
        }

        // Node doesn't have children
        // In this case, we can just set the focusNode parent to either left or right child to null depending on whether
        // it's on the left or right using leftChild boolean
        if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {
            if (focusNode == root)
                root = null;

            else if (leftChild)
                parent.setLeftChild(null);

            else
                parent.setRightChild(null);
        }
        // Node doesn't have right child
        // As the node doesn't have a right child, we can just set the parent.left or right child to the focusNode.leftChild() value;
        else if (focusNode.getRightChild() == null) {
            if (focusNode == root)
                root = focusNode.getLeftChild();

            else if (leftChild)
                parent.setLeftChild(focusNode.getLeftChild());

            else
                parent.setRightChild(focusNode.getLeftChild());
        }
        // Node doesn't have left child
        // Vice versa to above
        else if (focusNode.getLeftChild() == null) {
            if (focusNode == root)
                root = focusNode.getRightChild();

            else if (leftChild)
                parent.setLeftChild(focusNode.getRightChild());

            else
                parent.setRightChild(focusNode.getRightChild());
        }
        // Node have both children
        // Since both nodes have children, we need to find the replacement value. i.e. the lowest value in the right
        // side of the tree.
        else {
            // Find the lowest value
            Node replacement = getReplacementNode(focusNode);

            if (focusNode == root)
                root = replacement;

            else if (leftChild)
                parent.setLeftChild(replacement);

            else
                parent.setRightChild(replacement);

            // Finally, set the replacement left child to focusNode.leftChild()
            // We don't need to do replacement right child because in the replacement method, we have already done that
            // If we do it here, in case our replacement value is right next to our focusNode, it will point to itself
            replacement.setLeftChild(focusNode.getLeftChild());
        }
        return true;
    }

    public Node getReplacementNode(Node nodeToReplace) {
        // We need three Nodes, replacementParent, replacement and FocusNode

        // replacementParent will be used to keep track of the parent of our replacement node in case we have to go
        // further down until the end of leftChild();

        // replacement is our replacement node to be returned

        // focusNode will be used to traverse until we reach the lowest value in the right branch
        Node replacementParent = nodeToReplace;
        Node replacement = nodeToReplace;
        Node focusNode = nodeToReplace.getRightChild();

        // Find the lowest value in the right side branch.
        // To do that, first we set the first focusNode to the right side node of our nodeToReplace, if there is no
        // more leftChild, i.e. Null, we know that is the lowest value, if there is more leftChild, we know that
        // it is not the lowest value in our right branch.
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.getLeftChild();
        }
        // Now we have our lowest value

        // If our lowest value goes further than nodeToReplace.rightChild(), we have to move it up to our nodeToReplace
        // location. Since it is the last leftChild branch, we don't have to do anything to our left side

        // For our replacement right child, we have to set the parent of our replacement left child to that value
        // i.e. replacementParent.rightChild() == replacement.rightChild(); this is why we need replacementParent

        // Finally, set the replacement.rightChild() to focusNode.rightchild().
        if (replacement != nodeToReplace.getRightChild()) {
            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(nodeToReplace.getRightChild());
        }
        // If our replacement is nodeToReplace.rightChild(), i.e. immediately after nodeToReplace we can't do
        // replacement.rightChild() because it would point to itself.

        // Finally, we can return the replacement value. Remember, if the replacement node goes further than
        // nodeToReplace.rightChild(), we need to move it to the nodeToReplace which means setting the replacement.rightChild()
        // value to its parent.leftChild() and setting its rightChild value to nodeToReplace.rightChild();

        // This doesn't work when its immediately after the nodeToReplace because it would just point to itself
        return replacement;
    }

    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.getLeftChild());

            System.out.println(focusNode);

            inOrderTraversal(focusNode.getRightChild());
        }
    }

    public void preOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);

            preOrderTraversal(focusNode.getLeftChild());

            preOrderTraversal(focusNode.getRightChild());
        }
    }

    public void postOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.getLeftChild());

            postOrderTraversal(focusNode.getRightChild());

            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;

        while (focusNode.getKey() != key) {
            if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            } else if (key > focusNode.getKey()) {
                focusNode = focusNode.getRightChild();
            }

            if (focusNode == null) {
                System.out.println("Key not found");
                return null;
            }
        }
        return focusNode;
    }

}

class Node {

    private int key;
    private String name;
    private Node leftChild;
    private Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }

}
