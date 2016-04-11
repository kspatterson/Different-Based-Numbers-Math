/**
* Class representing a number expressed in a specific base
* and operations to convert this number to different bases.
* Currently allows up to base 20
*/
public class ConvertableNumber
{  
   private static final String NUMBERS = "0123456789ABCDEFGHIJK"; //Base up to 20
   private String number;
   private int base;
   private long base10Value;
   
   public ConvertableNumber(String number, int base)
   {
      this.number = number;
      this.base = base;
      this.base10Value = convertToBase10(); //Calculates base 10 value of number
   }
   
   public String getNumber()
   {
      return this.number;
   }
   
   public long getBase10Value()
   {
      return this.base10Value;
   }
   
   public int getBase()
   {
      return this.base;
   }
   
   //Converts number of any base to base 10
   public long convertToBase10()
   {
        long result = 0;
        int position = this.number.length();
        for (char c : this.number.toCharArray())
        {
            int value = NUMBERS.indexOf(c);
            result += value * power(this.base,--position);

        }
        return result;
   }
   
   //Converts num first to base 10 then to base N (denoted by param)
   public void convertToBaseN(int newBase)
   {
      if(this.base != 10)
      {
         this.base10Value = convertToBase10();
         this.base = 10;
         this.number = "" + this.base10Value;   
      }
      this.number = convertToBaseN(newBase, this.number);
      this.base = newBase;
   }
   
   //Recursively Called Method @param dividend -  the last calls quotient 
   private String convertToBaseN(int newBase, String dividend) //Recursively Called @param number
   {
      int quotient = Integer.parseInt(dividend) / newBase;
      int remainder = Integer.parseInt(dividend) % newBase;

      if(quotient == 0)
      {
          return "" + NUMBERS.charAt(remainder);       
      }
      else
      {
          return convertToBaseN(newBase, Integer.toString(quotient)) + NUMBERS.charAt(remainder);
      }            
   }
   
   //Recursively defined power method
   private long power(int base, int exponent)
   {
        if (exponent == 0) 
               return 1;
        return base * power(base, exponent-1);
   }
   
   public String toString()
   {
      return this.number + " Base:" + this.base; 
   }
}