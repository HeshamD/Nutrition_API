package DataStructure;

public class LinkedList {
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public void addFirst(int value){
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        }else {
            newNode.next = first;
            first = newNode;
        }
    }

    public void addLast(int value){
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
    }
    public boolean isEmpty(){
        if(first == null) return true;
        return false;
    }

    public boolean contains(int value){
        if(indexOf(value)==-1) return false;
        return true;
    }
    public int indexOf(int item){
        int index = 0;
        Node current = first;
        while (current!=null){
            if(index == item){
                return current.value;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // 0 -> 3 -> 4
    public void removeLast(){
        if(isEmpty())return;
        if(first==last) first=last=null;
        var prev = getPrev(last);
        last = prev;
        last.next = null;
    }

    private Node getPrev(Node node){
        var current = first;
        while (current!=null){
            if (current.next == node){
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
