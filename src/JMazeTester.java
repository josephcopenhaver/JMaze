/*
 * Author: Joseph Copenhaver
 *
 * email: joseph.copenhaver@gmail.com
 *
 */

class JMazeTester
{
   
   public static void main(String[] args) throws Exception
   {
      
      while (true)
      {
         
         (new JMaze(promptInt("Width"), promptInt("Height"))).print();
         
         System.out.println('\n');
         
      }
      
   }
   
   
   /*
    * Simple helper function to retreive data from STDIN
    * and display a prompt header.
    *
    */
   public static int promptInt(String x)
   {
      
      System.out.print(x + ": ");
      
      return Integer.parseInt(System.console().readLine());
      
   }
   
}
