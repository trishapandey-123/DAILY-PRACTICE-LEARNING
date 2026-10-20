import java.util.Scanner;
class LeapYear
  {
  public static void main(String [] args){
    Scanner sc=new Scanner(System.in);
    int n;
    System.out.println("Enter a year");
    n=sc.nextInt();
    if((n % 4 == 0 && n % 100 != 0) || (n % 400 == 0)) 
      {
      System.out.println("The year is leap year");
    }
    else{
      System.out.println("The year is ordinary year");
    }
  }
}
    
