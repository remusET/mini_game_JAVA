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
public class Niveau {
    static int n = 3;
    public Element [][] carte = new Element[n][n];
    public Personnage PJ;
    public String titre;

    public Niveau(Personnage PJ, String titre) {
        this.PJ = PJ;
        this.titre = titre;
    }
    
    public void setElement(int i, int j, Element k){
        if(carte[i][j] == null)
            carte[i][j] = k;
        else 
            System.out.println("Caseta e ocupata");
    }
    
    public Element getElement(int i, int j){
        return carte[i][j];
    }
    
    public String decritCarte(int i,int j){
        if(carte[i][j] == null)
            return "Case Vide";
        else
            return carte[i][j].getType();
    }
    
    public String decritCarte(){
        for(int i = 0; i < n;i++)
            for(int j = 0;j< n;j++)
                if(carte[i][j] == null)
                    return "Case vide";
                else
                    return carte[i][j].getType();
        
        return " ";
    }
        
       
                
    
    public Personnage getPersonnagePrincipal(){
        return PJ;
    }
            
    public void setPersonnagePrincipal(Personnage p){
        this.PJ = p;
    }      

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Niveau(Personnage PJ) {
        this.PJ = PJ;
    }
    
    public void moveDown(){
       for(int i = 1;i <= n; i++)
             for(int j = 1 ; j <= n; j++)
                if(carte[i - 1][j - 1] == PJ)
                    if(i - 1 == n - 1) //daca esti pe ultimul rand
                    {
                        System.out.println("Nu o poti lua in sus");
                        System.out.println("Personajul ramane pe " + (i - 1) + " " + (j - 1));
                        break;
                    }
                else
                    {
                     if(carte[i][j - 1].getType() == "DECOR" )//daca dai in decor
                        {
                            System.out.println("Nu poti trece prin decor");
                            System.out.println("Personajul ramane pe " + (i - 1) + " " + (j - 1));
                            
                        }  
                     else if(carte[i][j - 1].getType() == "PERSONNAGE")//daca te intalnesti cu un personaj
                          {
                            System.out.println("Te-ai intalnit cu un adversar si l-ai infrant");
                            carte[i - 1][j - 1] = null;
                            carte[i][j - 1] = PJ;
                            PJ.setVitalite(PJ.getVitalite() - 10);
                            System.out.println("Personajul are acum " + PJ.getVitalite() + " viata");
                            System.out.println("Personajul este acum pe pozitia:" + (i) + " " + (j - 1));
                            
                          }
                     else if(carte[i][j - 1].getType() == "OBJET")
                     {
                            System.out.println("Ai dat peste un obiect");
                            PJ.ajouterObjet((Objet)carte[i][j - 1]);
                            carte[i - 1][j - 1] = null;
                            carte[i][j - 1] = PJ;
                            if(PJ.getVitalite() != PJ.getVitaliteMax())  
                                PJ.setVitalite(PJ.getVitalite() + 5);
                            System.out.println("Personajul are acum " + PJ.getVitalite() + " viata");
                            System.out.println("Personajul este acum pe pozitia:" + (i) + " " + (j - 1));
                            
                     }
                     else
                        {
                        carte[i][j - 1] = PJ;
                        carte[i - 1][j - 1] = null;
                        System.out.println("Personajul este acum pe pozitia:" + (i) + " " + (j - 1));
                        
                        }
                     break;
                    }
    }
    
    public void moveUp(){
        for(int i = 1;i <= n; i++)
             for(int j = 1 ; j <= n; j++)
                if(carte[i - 1][j - 1] == PJ)
                    if(i - 1 == 0) //daca esti pe primul rand
                    {
                        System.out.println("Nu o poti lua in sus");
                        System.out.println("Personajul ramane pe " + (i - 1) + " " + (j - 1));
                        break;
                    }
                else
                    {
                     if(carte[i - 2][j - 1].getType() == "DECOR" )//daca dai in decor
                        {
                            System.out.println("Nu poti trece prin decor");
                            System.out.println("Personajul ramane pe " + (i - 1) + " " + (j - 1));
                        }  
                     else if(carte[i - 2][j - 1].getType() == "PERSONNAGE")//daca te intalnesti cu un personaj
                          {
                            System.out.println("Te-ai intalnit cu un adversar si l-ai infrant");
                            carte[i - 2][j - 1] = PJ;
                            carte[i - 1][j - 1] = null;
                            PJ.setVitalite(PJ.getVitalite() - 10);
                            System.out.println("Personajul are acum " + PJ.getVitalite() + " viata");
                            System.out.println("Personajul este acum pe pozitia:" + (i - 2) + " " + (j - 1));
                          }
                     else if(carte[i - 2][j - 1].getType() == "OBJET")
                     {
                            System.out.println("Ai dat peste un obiect");
                            PJ.ajouterObjet((Objet)carte[i - 2][j - 1]);
                            carte[i - 2][j - 1] = PJ;
                            carte[i - 1][j - 1] = null;
                            if(PJ.getVitalite() != PJ.getVitaliteMax())  
                                PJ.setVitalite(PJ.getVitalite() + 5);
                            System.out.println("Personajul are acum " + PJ.getVitalite() + " viata");
                            System.out.println("Personajul este acum pe pozitia:" + (i - 2) + " " + (j - 1));
                     }
                     else
                        {
                        carte[i - 2][j - 1] = PJ;
                        carte[i - 1][j - 1] = null;
                        System.out.println("Personajul este acum pe pozitia:" + (i - 2) + " " + (j - 1));
                        }
                     break;
                    }
    }

    public void moveLeft(){
        for(int i = 1;i <= n; i++)
             for(int j = 1 ; j <= n; j++)
                if(carte[i - 1][j - 1] == PJ)
                    if(j - 1 == 0) //daca esti pe prima coloana
                    {
                        System.out.println("Nu o poti lua in stanga");
                        System.out.println("Personajul ramane pe " + (i - 1) + " " + (j - 1));
                        break;
                    }
                else
                    {
                     if(carte[i - 1][j - 2].getType() == "DECOR" )//daca dai in decor
                        {
                            System.out.println("Nu poti trece prin decor");
                            System.out.println("Personajul ramane pe " + (i - 1) + " " + (j - 1));
                        }  
                     else if(carte[i - 1][j - 2].getType() == "PERSONNAGE")//daca te intalnesti cu un personaj
                          {
                            System.out.println("Te-ai intalnit cu un adversar si l-ai infrant");
                            carte[i - 1][j - 2] = PJ;
                            carte[i - 1][j - 1] = null;
                            PJ.setVitalite(PJ.getVitalite() - 10);
                            System.out.println("Personajul are acum " + PJ.getVitalite() + " viata");
                            System.out.println("Personajul este acum pe pozitia:" + (i - 1) + " " + (j - 2));
                          }
                     else if(carte[i - 1][j - 2].getType() == "OBJET")
                     {
                            System.out.println("Ai dat peste un obiect");
                            PJ.ajouterObjet((Objet)carte[i - 1][j - 2]);
                            carte[i - 1][j - 2] = PJ;
                            carte[i - 1][j - 1] = null;
                            if(PJ.getVitalite() != PJ.getVitaliteMax())  
                                PJ.setVitalite(PJ.getVitalite() + 5);
                            System.out.println("Personajul are acum " + PJ.getVitalite() + " viata");
                            System.out.println("Personajul este acum pe pozitia:" + (i - 1) + " " + (j - 2));
                     }
                     else
                        {
                        carte[i - 1][j - 2] = PJ;
                        carte[i - 1][j - 1] = null;
                        System.out.println("Personajul este acum pe pozitia:" + (i - 1) + " " + (j - 2));
                        }
                     break;
                    }
    }

    public void moveRight(){
        for(int i = 1;i <= n; i++)
             for(int j = 1 ; j <= n; j++)
                if(carte[i - 1][j - 1] == PJ)
                    if(i - 1 == n - 1) //daca esti pe ultima coloana
                    {
                        System.out.println("Nu o poti lua in dreapta");
                        System.out.println("Personajul ramane pe " + (i - 1) + " " + (j - 1));
                        break;
                    }
                else
                    {
                     if(carte[i - 1][j].getType() == "DECOR" )//daca dai in decor
                        {
                            System.out.println("Nu poti trece prin decor");
                            System.out.println("Personajul ramane pe " + (i - 1) + " " + (j - 1));
                        }  
                     else if(carte[i - 1][j].getType() == "PERSONNAGE")//daca te intalnesti cu un personaj
                          {
                            System.out.println("Te-ai intalnit cu un adversar si l-ai infrant");
                            carte[i - 1][j] = PJ;
                            carte[i - 1][j - 1] = null;
                            PJ.setVitalite(PJ.getVitalite() - 10);
                            System.out.println("Personajul are acum " + PJ.getVitalite() + " viata");
                            System.out.println("Personajul este acum pe pozitia:" + (i - 1) + " " + (j));
                          }
                     else if(carte[i - 1][j].getType() == "OBJET")
                     {
                            System.out.println("Ai dat peste un obiect");
                            PJ.ajouterObjet((Objet) carte[i - 1][j]);
                            carte[i - 1][j] = PJ;
                            carte[i - 1][j - 1] = null;
                            if(PJ.getVitalite() != PJ.getVitaliteMax())  
                                PJ.setVitalite(PJ.getVitalite() + 5);
                            System.out.println("Personajul are acum " + PJ.getVitalite() + " viata");
                            System.out.println("Personajul este acum pe pozitia:" + (i - 1) + " " + (j));
                     }
                     else
                        {
                        carte[i - 1][j] = PJ;
                        carte[i - 1][j - 1] = null;
                        System.out.println("Personajul este acum pe pozitia:" + (i - 1) + " " + (j));
                        }
                     break;
                    }
    }
    
    public boolean endGame(){
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                if(carte[i][j] != PJ)
                    return true;
        return false;        
    }
}
