package com.practice.link;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println("node = " + node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println("node = " + node.data);
            }
        }
    }

    public T searchFromHead(T isData) {
        if (this.head != null) { // head 가 존재 할 시
            Node<T> node = this.head; // 현재 head 를 Type 변수에 담아준다.
            while (node != null) { // node 가 null 이 아닐 동안
                if (node.data == isData) { // node.data 가 우리가 찾는 데이터 일경우
                    System.out.println("find this Data :" + node.data);
                    return node.data; // 해당 데이터를 반환한다.
                } else { // 그렇지 않을 경우
                    node = node.next; // 다음 node 를 찾는다.
                }
            } // null 일 경우 while 을 빠져나와.
        }
        return null; // null 을 반환한다.
    }

    public T searchFromTail(T isData) {
        if (this.tail != null) {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    System.out.println("find Tail 서 부터 : = " + node.data);
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
        }
        return null;
    }

    public boolean insertToFront(T existedData, T addData) {
        if( this.head == null) { // head 가 없을땐 생성
            this.head = new Node<>(addData);
            this.tail = this.head;
            return true;
        } else if (this.head.data == existedData) { // head 앞에 끼워넣을때
            Node<T> newHead = new Node<>(addData);
            this.head.next = this.head;
            this.head = newHead;
            return true;
        } else { // 찾는 데이터가 head 다음에 있을경우
            Node<T> node = this.head;
            while (node != null) {
                if(node.data == existedData) {
                    Node<T> nodePrev = node.prev;
                    nodePrev.next = new Node<>(addData);
                    nodePrev.next.next = node;
                    nodePrev.next.prev = nodePrev;
                    return true;
                } else {
                    node = node.next;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkded = new DoubleLinkedList<>();

        doubleLinkded.addNode(1);
        doubleLinkded.addNode(2);
        doubleLinkded.addNode(3);
        doubleLinkded.addNode(4);
        doubleLinkded.addNode(5);

        doubleLinkded.printAll();
        doubleLinkded.searchFromHead(1);
        doubleLinkded.searchFromTail(3);
    }
}
