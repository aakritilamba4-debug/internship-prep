import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> nm = new ArrayList<>();
        ArrayList<Integer> grd = new ArrayList<>();
        System.out.println("enter the number of student");
        int n = s.nextInt();
        s.nextLine();
        for(int i=0;i<n;i++)
        {
            System.out.println("enter the name of student");
            String nme = s.nextLine();
            System.out.println("enter the marks of student");
            int gd = s.nextInt();
            s.nextLine();
            nm.add(nme);
            grd.add(gd);

        }
        int ttl=0;
        int hgst= grd.get(0);
        int lwst= grd.get(0);
        for(int gd : grd){
            ttl= ttl + gd; 
            if(gd>hgst){
                hgst=gd;

            }
            else if(gd<lwst)
            {
                lwst=gd;

            }
        }
        double avg;
        avg = (double) ttl/n;
        System.out.println("student report");
        for(int i=0; i<n; i++){
            System.out.println( nm.get(i) + ":"+ grd.get(i));
        }
        System.out.println("avg score " + avg);
       System.out.println("highest score " + hgst);
       System.out.println("lowest score " + lwst); 
       s.close();
    }
}
