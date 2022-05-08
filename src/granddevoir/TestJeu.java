/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granddevoir;

import java.util.Scanner;

/**
 *
 * @author remus
 */
public class TestJeu {

    /**
     * @param args the command line arguments
     */
    
        
    
    public static void main(String[] args) {
       
       Personnage p = new Personnage("George" , 100);
       p.setVitalite(p.getVitaliteMax());
       Personnage e1= new Personnage("e1" , 100);
       Personnage e2 = new Personnage("e2" , 100);
              
       Element o1 = new Objet();
       Element o2 = new Objet();
       Element o3 = new Objet();
       o1.setDescription("o licoare vit + 5");
       
       Element d1 = new Decor();
       Element d2 = new Decor();
       Element d3 = new Decor();
       
       
       Niveau n = new Niveau(p , "Level 1" );
       n.setElement(1, 2, e2);
       n.setElement(0, 1, e1);
       n.setElement(0, 2, d1);
       n.setElement(1, 1, p);
       n.setElement(0, 0, d3);
       n.setElement(2, 0, d2);
       n.setElement(2, 1, o2);
       n.setElement(2, 2, o3);
       
       while(n.endGame()){
        Scanner key = new Scanner(System.in);
        System.out.println("Press W/A/S/D");
        char c = key.next().charAt(0);
       
       
       if(c == 'S' || c == 's')
           n.moveDown();
       
       if(c == 'A' || c == 'a')
           n.moveLeft();
       
       if(c == 'W' || c == 'w')
           n.moveUp();
       
       if(c == 'D' || c == 'd')
           n.moveRight();
       }          
       
      
       
       
       
       
       
    }
    
}
