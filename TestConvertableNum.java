import java.util.Scanner;

public class TestConvertableNum
{
   public static Scanner input = new Scanner(System.in);

   public static void main(String[]args)
   {  
      boolean repProgram;
      ConvertableNumber number;
      int menu;
      do
      {      
         number = getNumber();
         repProgram = true;
         
         System.out.println("Choose an Option below on what you would like to do with " + 
                            "that number\nEnter the respective number corresponding to " + 
                            "your choice\n[1]Switch Number to Another Base\n[2]Switch " +
                            "Numbers entirely\n[3]Exit the Program");
         menu = Integer.parseInt(input.nextLine());
         
         switch(menu)
         {
            case 1:  //CONVERTS USER ENTERED NUMBER TO USER SPECIFIED BASE    
               System.out.println("Which base would you like to convert your number to?\n" +
                                  "Please Enter the base now");
               int newBase = Integer.parseInt(input.nextLine());
               while(newBase > 20 || newBase < 2)//WHILE INVALID BASE ARGUMENT ATTMEPT TO GET VALID ONE
               {
                  System.out.println("Only handles bases from 2 to 20\nTry Again");
                  newBase = Integer.parseInt(input.nextLine());
               }
               System.out.println("Converted number");
               number.convertToBaseN(newBase);
               System.out.println(number);
               break;
               
            case 2:  //RESTARTS TO BEGGING OF PROGRAM PROMPTING FOR NEW NUMBER
               break;
               
            case 3:  //EXITS ENTIRE PROGRAM
               repProgram = false;
               break;
         }
      }while(repProgram);
      System.out.println("Goodbye!");
   }
   
   
   //METHOD THAT PROMPTS USER FOR NUMBER INCLUDING BASE
   public static ConvertableNumber getNumber()
   {
      String correctInput, num;
      int base;
      do
      {
         System.out.println("Please Enter the number you would like to convert " +
                            "in the base representation of it's base.");
         num = input.nextLine();
         System.out.println("Now please Enter the base you want that number to be in");
         base = Integer.parseInt(input.nextLine());
         while(base > 20 || base < 2)//WHILE INVALID BASE ARGUMENT ATTMEPT TO GET VALID ONE
         {
            System.out.println("Error: Only handles base 2 to base 20\n" +
                               "Try Again");
            base = Integer.parseInt(input.nextLine());
         }
         
         //VALIDATE USER'S INPUT   
         System.out.println("You've entered : " + num + " Base:" + base +
                            "\nIs this correct?\nEnter [Yes] or [No]");
         correctInput = yesNo();
      }while(correctInput == "no");
      
      //CREATE CONVERTABLE NUM OBJECT AND RETURN IT
      ConvertableNumber number = new ConvertableNumber(num, base);
      return number;
   }
   
   //METHOD GRABBING YES OR NO INPUT
   public static String yesNo() 
   {
      String yesNo = new String();
      do 
      {
         yesNo = input.nextLine();
         if (!yesNo.equalsIgnoreCase("yes")
              && !yesNo.equalsIgnoreCase("no")) 
         {
             System.out.println("Yes or No only!  Try again");
         }
      }while (!yesNo.equalsIgnoreCase("yes")
            	&& !yesNo.equalsIgnoreCase("no"));
               
      return yesNo;
   }
}