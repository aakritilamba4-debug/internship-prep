import java.util.Scanner;

public class Gradecalc 
{   

     public static void main(String[] args)
     {
        //input from user----
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of subject : ");
        int subject = sc.nextInt(); 
         float totalMarks = 0;
        for (int i = 1; i<subject; i++) 
        {   
            System.out.println("Enter marks for subject " + i + ": ");
            float marks = sc.nextFloat();
            while (marks<0 || marks > 100) 
            {
                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                marks = sc.nextFloat();    
            }
                
                totalMarks += marks;
        }
            float avrgMarks = totalMarks / subject;
             System.out.println("Average marks: " + avrgMarks);  
        if (avrgMarks >= 90)    
        {
           System.out.println("Grade: A");
        } 
        else if (avrgMarks >= 80)   
        {
            System.out.println("Grade: B");
        } 
        else if (avrgMarks >= 70) 
        {
            System.out.println("Grade: C");
        } 
        else if (avrgMarks >= 60) 
        {
            System.out.println("Grade: D");
        }    
        else 
        {
            System.out.println("Grade: F");
        }
        System.out.println("\n---result-----");
        System.out.println("Average Marks: " + avrgMarks);
        
        System.out.println("total marks: " + totalMarks);
        System.out.println("Thank you for using the grade calculator!");
        sc.close();
    }   
}