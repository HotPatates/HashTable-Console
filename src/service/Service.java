package service;

import model.HashTable;
import model.Node;

public class Service {
    int hash(String S,int size){
        int Sum=0;
        char[] C=S.toCharArray();
        for(int i=0;i<C.length;i++){
            int k=C[i];
            Sum+=k;
        }
        return Sum%size;
    }
    public boolean add(String S, HashTable T){
        if (exists(S,T)){
            return false;
        }
        int size=T.getSize();
        Node[] Table=T.getTable();
        int index=hash(S,size);
        add(S,Table[index]);
        T.setTable(Table);
        return true;
    }
    void add(String S,Node N) {

        Node Next=N.getNext();
        if (Next == null) {
            Next = new Node(S);
            N.setNext(Next);
        } else {
            add(S,Next);
        }
    }

    public boolean exists(String S,HashTable T){
        int index=hash(S,T.getSize());
        Node N=T.getTable()[index];
        if (N==null){
            return false;
        }else{
        while (N.getNext()!=null){
            if (N.getNext().getContent().equals(S)){
                return true;
            }
            N=N.getNext();
        }
        return false;
    }
    }


    public boolean remove(String S,HashTable T){
        int index=hash(S,T.getSize());
        Node N=T.getTable()[index];
        while (N.getNext()!=null){
            if (N.getNext().getContent().equals(S)){
                N.setNext(N.getNext().getNext());
                return true;
            }
            N=N.getNext();
        }
        return false;
    }

    public void list(HashTable T){
        int size=T.getSize();
        Node[] Tab=T.getTable();
        for (int i=0;i<size;i++){
            if(Tab[i]!=null){
                Node N=Tab[i].getNext();
                String S2="╔═════╗";
                String S="║     ║";
                String S1=i+1<size?"╠═════╣":"╚═════╝";
                while (N!=null){

                    S=S+"~>║"+N.getContent()+"║";
                    S1=i+1==size?S1+"  ╚":S1+" ╠ ";
                    S2+="  ╔";
                    for (int j=0;j<N.getContent().length();j++){
                        S1+="═";
                        S2+="═";
                    }
                    S1+=i+1==size?"╝":"╣";
                    S2+="╗";
                    N=N.getNext();
                }
                if (i == 0) System.out.println(S2);
                System.out.println(S);
                System.out.println(S1);
            }
        }
    }
}
