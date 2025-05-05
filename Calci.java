
package Sample;
import java.util.Scanner;

public class Calci {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=0;
        int prod=1;
        int a, b, x,n;
        double c,d;

        while (true) {
            System.out.println("Calculator App");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            x = sc.nextInt();
            

            if (x == 0) {
                System.out.println("Exiting the calculator.");
                sc.close();
                break;
               
            }


            switch (x) {
                case 1:{
                
                	System.out.println("Enter how many numbers need to add");
                    n=sc.nextInt();
                    int[] ar=new int[n];
                    for(int i=0;i<n;i++) {
                	  ar[i]=sc.nextInt();
                	  sum=sum+ar[i];
                	}
                	
                	System.out.println(sum);
                    System.out.print("Enter first number: ");
                    a = sc.nextInt();
                    System.out.print("Enter second number: ");
                    b = sc.nextInt();

                    System.out.println("Result: " + (a + b));
                    break;
                    }
                case 2:{

                    System.out.print("Enter first number: ");
                    a = sc.nextInt();
                    System.out.print("Enter second number: ");
                    b = sc.nextInt();

                    System.out.println("Result: " + (a - b));
                    break;}
                case 3:{

                	System.out.println("Enter how many numbers need to multiply");
                    n=sc.nextInt();
                    int[] ar=new int[n];
                    for(int i=0;i<n;i++) {
                	  ar[i]=sc.nextInt();
                	  prod=prod*ar[i];
                	}
                    System.out.println(prod);
                	System.out.print("Enter first number: ");
                    c = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    d= sc.nextDouble();
                    System.out.println("Result: " + (c*d));
                    break;}
                    case 4:{
                	System.out.print("Enter first number: ");
                    c = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    d= sc.nextDouble();
                	if(d!=0) {
                       System.out.println("Result: " + (c/d));
                    } 
                    else {
                    	System.out.println("exception occurs");
                    }
                    break;
                    }
                    
                default:{
                    System.out.println("Invalid choice. Please try again.");
            }
        
          
       }
       
      }
    }
    
}

