/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granddevoir;

import java.util.ArrayList;

/**
 *
 * @author remus
 */
public class Personnage extends Element{
    
    public String name;
    public int vitalite;
    public int vitaliteMax;
    public ArrayList<Objet> inv = new ArrayList<>();

    public Personnage(String name, int vitaliteMax) {
        this.name = name;
        this.vitaliteMax = vitaliteMax;
    }
    
    public String getType(){
        return "PERSONNAGE";
    }

    public String getName() {
        return name;
    }

    public int getVitalite() {
        return vitalite;
    }

    public int getVitaliteMax() {
        return vitaliteMax;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVitalite(int vitalite) {
        this.vitalite = vitalite;
    }

    public void setVitaliteMax(int vitaliteMax) {
        this.vitaliteMax = vitaliteMax;
    }
    
    public boolean ajouterObjet(Objet o){
        return inv.add(o);
    }
    
    public boolean retirerObjet(Objet o){
        return inv.remove(o);
    }
    
    public void afficherInventaire(){
        System.out.println("In inventar ai: ");
       for(int i = 0 ; i < inv.size() ; i++)
            System.out.println(inv.get(i).toString());
    }

    public Personnage() {}
    
    
    
    
    
    
    
}