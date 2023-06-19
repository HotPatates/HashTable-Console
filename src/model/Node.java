package model;

public class Node {
    private String Content;
    private Node Next=null;
    public Node(String C){
        Content=C;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        Next = next;
    }
}
