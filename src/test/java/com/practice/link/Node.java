package com.practice.link;

public class Node<T> {
    T data;
    Node<T> next = null;

    public Node(final T data) {
        this.data = data;
    }
}
