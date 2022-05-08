package com.practice.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestApp {

    Tree myTree = new Tree();

    @BeforeEach
    void insertNodeData() {
        // CASE1: Node 가 하나도 없을 때
        myTree.insertNode(2);
        myTree.insertNode(3);
        myTree.insertNode(4);
        myTree.insertNode(6);
    }

    @Test
    @DisplayName("searchNode")
    void searchNode() {
        final Node search = myTree.search(3);
        System.out.println("search = " + search.right.value);
    }
}
