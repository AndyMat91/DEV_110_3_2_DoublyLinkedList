package org.example;

import java.util.List;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    private static class Node {
        public Object data; //данные
        public Node next; //ссылка на следующий узел
        public Node previous; //ссылка на предыдущий узел

        public Node(Object data) {
            this.data = data;
        }
    }

    public void addInBeginning(Object data) {
        if (data != null) {
            Node newNode = new Node(data);
            if (head != null) {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            } else {
                head = tail = newNode;
            }
        }
    }

    public Object extValueFromTheBeginningWithoutDeleting() {  //извлечение значения из начала списка без его удаления из списка;
        return head.data;
    }

    public Object extValueFromTheBeginningWithDeleting() {  //извлечение значения из начала списка с удалением его из списка;
        Object x = head.data;
        remove(head.data);
        return x;
    }

    public Object extValueFromTheEndWithoutDeleting() {  //извлечение значения из конца списка без удаления из списка;
        return tail.data;
    }

    public Object extValueFromTheEndWithDeleting() { //извлечение значения из конца списка с удалением;
        Object y = tail.data;
        remove(tail.data);
        return y;
    }

    public void addInEnd(Object data) {
        if (data != null) {
            Node newNode = new Node(data);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
        }
    }

    public boolean searchValue(Object data) {   //определение, содержит ли список заданное значение, или нет;
        if (data != null) {
            Node currentNode = head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    return true;
                } else if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void remove(Object data) {    //удаление заданного значения из списка;
        if (head == null || data == null) return;
        Node currentNode = head;
        Node previousNode = null;
        Node nextNode = head.next;
        if (searchValue(data)) {
            while (currentNode != null) {
                if (currentNode.data.equals(data)) {
                    if (currentNode == head) {
                        head = nextNode;
                       if (head != null)head.previous = null;
                    } else if (currentNode == tail) {
                        tail = currentNode.previous;
                        tail.next = null;
                    } else if (previousNode != null) {

                        previousNode.next = currentNode.next;
                        nextNode.previous = currentNode.previous;
                    }
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
                if (currentNode != null) nextNode = currentNode.next;
            }
        }
    }

    public boolean empty() {   //определение, является ли список пустым, или нет;
        return head == null;
    }

    public void printAllDirectOrder() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void printAllReverseOrder() {
        Node currentNode = tail;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.previous;
        }
        System.out.println();
    }

    public void addAllArrayValuesToTheBeginning(Object... x) {
        for (int i = x.length - 1; i >= 0; i--) {
            addInBeginning(x[i]);
        }
    }

    public void addAllCollectionValuesToTheBeginning(List<Object> x) {
        for (int i = x.size() - 1; i >= 0; i--) {
            addInBeginning(x.get(i));
        }
    }

    public void addAllArrayValuesToTheEnd(Object... x) {
        for (Object o : x) {
            addInEnd(o);
        }
    }

    public void addAllCollectionValuesToTheEnd(List<Object> x) {
        for (Object i : x) {
            addInEnd(i);
        }
    }

    public void absorbingTheListToTheTop(DoublyLinkedList x) {
        if (x.head == null) return;
        Node currentNodeX = x.tail;
        while (currentNodeX != null) {
            addInBeginning(currentNodeX.data);
            x.remove(currentNodeX.data);
            currentNodeX = currentNodeX.previous;
        }
    }

    public void absorbingTheListToTheEnd(DoublyLinkedList x) {
        if (x.head == null) return;
        Node currentNodeX = x.head;
        while (currentNodeX != null) {
            addInEnd(currentNodeX.data);
            x.remove(currentNodeX.data);
            currentNodeX = currentNodeX.next;
        }
    }
}