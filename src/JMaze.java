/*
 * Author: Joseph Copenhaver
 *
 * email: joseph.copenhaver@gmail.com
 *
 *
 */

import java.util.Collections;
import java.util.ArrayList;

public class JMaze {
   
   private int _width;
   
   private int _height;
   
   private int startOfVertWalls;
   
   private Boolean[] walls;
   // Interpret null equivalent to a wall is present
   
   
   /* 
    * Init method
    *
    */
   public JMaze(int width, int height) throws InstantiationException {
      
      if (width < 1 || height < 1)
         
         throw new InstantiationException();
      
      _height = height - 1;
   	  
   	  _width = width - 1;
   	  
   	  startOfVertWalls = width * _height;
      
      EquivalenceClass eqc = new EquivalenceClass(height * width);
   	  
      walls = new Boolean[(_width * height) + (_height * width)];
      
      ArrayList<Integer> wallNumbers = new ArrayList<Integer>(walls.length);
      
      for (int wall = 0; wall < walls.length; wall++)
         
         wallNumbers.add(wall);
      
      Collections.shuffle(wallNumbers);
      
      for(Integer wall : wallNumbers)
      {
         
         int cellA = wall - startOfVertWalls;
         
         int cellB = -1;
      	
         if (cellA >= 0)
         {
         	
         	cellA += (cellA/_width);
            
      	    cellB = cellA + 1;
      	    
         }
         else
         {
      	    
      	    cellA = wall;
      	    
      	    cellB = wall + width;
            
      	 }
      	
      	 if (eqc.merge(cellA, cellB))
         {
      	    
      		walls[wall] = false;
      		
         }
         
      }
      
   }
   
   
   /*
    * Display maze via STDOUT and simple characters
    *
    */
   public void print() {
      
      System.out.print("  ");
      
      for (int colNum = 1; colNum <= _width; colNum++)
         
         System.out.print("__");
      
      System.out.println('_');
      
      int hIndex = 0;
      
      int vIndex = startOfVertWalls;
      
      for (int rowNum = 0; rowNum < _height; rowNum++)
      {
         
         System.out.print('|');
         
         for (int colNum = 0; colNum <= _width; colNum++)
         {
            
            System.out.print(((walls[hIndex++] == null) ? '_' : ' ' ));
            
            if (colNum != _width)
               
               System.out.print(((walls[vIndex++] == null) ? '|' : '_' ));
            
         }
            
         System.out.println('|');
         
      }
      
      System.out.print('|');
      
      while(vIndex < walls.length)
      {
         
         System.out.print(((walls[vIndex++] == null) ? "_|" : "__" ));
         
      }
      
      System.out.println(" |");
      
   }
   
}
