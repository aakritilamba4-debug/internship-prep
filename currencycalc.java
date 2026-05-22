import java.util.Scanner;

public class currencycalc {
    @SuppressWarnings("unused")
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        double rate = 83.14; // USD TO INR RATE
        String basecrrncy; 
        String targetcrrncy;
        double amount;
        double convertamt;
        System.out.println("currency counter");
        System.out.println("Enter the base currency");
        basecrrncy = sc.nextLine();
         System.out.println(" enter the target cuurency");
        targetcrrncy = sc.nextLine();
         System.out.println("enter the amount");
        amount = sc.nextDouble();
        convertamt = amount * rate;
        System.out.println("converted amount is : " + convertamt + " " + targetcrrncy);
        sc.close();
     }
}
