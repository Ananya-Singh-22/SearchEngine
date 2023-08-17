/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search.engine;

class AVLTree {
    private AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    // Method to get the height of a node
    private int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Method to get the balance factor of a node
    private int getBalanceFactor(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // Method to update the height of a node
    private void updateHeight(AVLNode node) {
        if (node != null) {
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }

    // Method to perform a left rotation
    private AVLNode leftRotate(AVLNode z) {
        AVLNode y = z.right;
        AVLNode T2 = y.left;

        y.left = z;
        z.right = T2;

        updateHeight(z);
        updateHeight(y);

        return y;
    }

    // Method to perform a right rotation
    private AVLNode rightRotate(AVLNode z) {
        AVLNode y = z.left;
        AVLNode T2 = y.right;

        y.right = z;
        z.left = T2;

        updateHeight(z);
        updateHeight(y);

        return y;
    }

    // Method to insert a node into the AVL tree
    public void insert(String data) {
        this.root = insertNode(this.root, data);
    }

    private AVLNode insertNode(AVLNode node, String data) {
        if (node == null) {
            return new AVLNode(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertNode(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertNode(node.right, data);
        } else {
            // Duplicate values are not allowed
            return node;
        }

        updateHeight(node);

        int balanceFactor = getBalanceFactor(node);

        // Left Left Case
        if (balanceFactor > 1 && data.compareTo(node.left.data) < 0) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balanceFactor < -1 && data.compareTo(node.right.data) > 0) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balanceFactor > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balanceFactor < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Method to search for a node in the AVL tree
    public boolean search(String data) {
        return searchNode(this.root, data);
    }

    private boolean searchNode(AVLNode node, String data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.data) < 0) {
            return searchNode(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            return searchNode(node.right, data);
        } else {
            return true;
        }
    }
}