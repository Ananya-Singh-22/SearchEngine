/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search.engine;

class AVLNode {
    String data;
    int height;
    AVLNode left;
    AVLNode right;

    public AVLNode(String data) {
        this.data = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

