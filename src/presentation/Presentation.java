package presentation;
import model.HashTable;

import java.util.Scanner;
import service.Service;
public class Presentation {
   public static void run(){
        Service Operator=new Service();
        Scanner S= new Scanner(System.in);
        int size=S.nextInt();
        HashTable T=new HashTable(size);
        while (true) {
            String cmd = S.nextLine();
            String[] List = cmd.split(" ");
            if (List[0].equals("add")) {
                System.out.println(Operator.add(List[1], T));
            } else if (List[0].equals("rmv")) {
                Operator.remove(List[1], T);
            } else if (List[0].equals("ls")) {
                Operator.list(T);
            }
        }
     }

}
