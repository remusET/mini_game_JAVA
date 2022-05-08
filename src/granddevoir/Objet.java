/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granddevoir;

/**
 *
 * @author remus
 */
public class Objet extends Element{
    public String name;

    public Objet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public Objet() {
    }
    
    
    public String getType(){
        return "OBJET";
    }
    
}
