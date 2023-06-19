package model;

public class HashTable {
    private int size=5;
    private Node[] Table;

    public HashTable(int size) {
        this.size = size;
        this.Table=new Node[size];
        for(int i=0;i<size;i++) {
            Table[i] = new Node("");
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node[] getTable() {
        return Table;
    }

    public void setTable(Node[] table) {
        Table = table;
    }
}
