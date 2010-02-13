/*
 * Author: Joseph Copenhaver
 *
 * email: joseph.copenhaver@gmail.com
 *
 * Notes:
 * Methodology used allows for easy transition
 * to hash pool member instead of an array if
 * I ever feel like making the adjustment.
 *
 */

public class EquivalenceClass {
   
   private Integer[] members;
   // Interpret null mapping equivalent to member is root of class
   
   /*
    * Init method
    */
   public EquivalenceClass(int range) {
      
      members = new Integer[range];
      
   }
   
   
   /*
    * Attempt to combine two classes.
    * A true return means a merger occured.
    */
   public boolean merge(int memberA, int memberB) {
      
      memberA = getRoot(memberA);
      
      memberB = getRoot(memberB);
      
      if (memberA == memberB)
         
         return false;
      
      if (memberA > memberB)
      {
         
         members[memberA] = memberB;
         
      }
      else
      {
         
         members[memberB] = memberA;
         
      }
      
      return true;
      
      
   }
   
   
   /*
    * Retreive the root node of the
    * equivalence class given a member
    */
   public int getRoot(int member) {
      
      Integer parent = members[member];
      
      if (parent == null)
      {
         
         return member;
         
      }
      
      return (members[member] = getRoot(parent));
      
   }
   
}
