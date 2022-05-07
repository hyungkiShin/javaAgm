package com.practice.link;

public class SingleLinkedList<T> {

    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) { // head 가 없으면 
            head = new Node<T>(data); // 새로 객체를 만들어 줄것이야.
        } else { // head 가 있으면,
            Node<T> node = this.head; // NodeType 의 변수로 받아서
            while (node.next != null) { // 해당 변수에 next 가 null 이 아니라면
                node = node.next;
                System.out.println("node.data = " + node.data);
            }
            node.next = new Node<T>(data);
        }
    }


    public void printAll() {
        if(head != null) {
            Node<T> node = this.head;
            System.out.println("node = " + node.data);
            while(node.next != null) {
                node = node.next;
                System.out.println("node = " + node.data);
            }
        }
    }

    public Node<T> search(T data) {
        if (this.head != null) {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchNode = this.search(isData);

        if(searchNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchNode.next;
            searchNode.next = new Node<T>(data);
            searchNode.next.next = nextNode;
        }
    }

    public boolean delNode(T isData) {
        if (this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            if(node.data == isData) {
                this.head = this.head.next;
                return true;
            } else {
                while (node.next != null) {
                    if(node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<>();
//        MyLinkedList.addNode(1);
//        MyLinkedList.addNode(2);
//        MyLinkedList.addNode(3);
//        MyLinkedList.addNode(3);
//
//        MyLinkedList.printAll();
//        MyLinkedList.addNodeInside(5,1);
//
//        MyLinkedList.printAll();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);

        MyLinkedList.delNode(20);

        MyLinkedList.printAll();
    }
}
