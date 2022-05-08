package com.practice.tree;

public class Node {

    Node left;
    Node right;
    int value;

    Node (int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}