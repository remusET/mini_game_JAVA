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
public abstract class Element {
    
    public String description;
    
     public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public abstract String getType();
    
    
    
}
