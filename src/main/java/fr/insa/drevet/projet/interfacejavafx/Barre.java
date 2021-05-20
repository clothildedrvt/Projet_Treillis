/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx;

/**
 *
 * @author dreve
 */
public class Barre {
    
    // Déclaration des attributs
    
    private int idBarre;
    private int idType;
    private int noeudOrigine;
    private int noeudFin;
    
    // Création d'un constructeur
    
    public Barre(int idBarre, int idType, int noeud1, int noeud2){
        this.idBarre = idBarre;
        this.idType = idType;
        this.noeudOrigine = noeud1;
        this.noeudFin = noeud2;
    }
    
    // Getters
    
    public int getIdBarre(){
        return this.idBarre;
    }
    
    public int getIdType(){
        return this.idType;
    }
    
    public int getNoeudOrigine(){
        return this.noeudOrigine;
    }
    
    public int getNoeudFin(){
        return this.noeudFin;
    }
    
    // Setters
    
    public void setIdBarre(int idBarre){
        this.idBarre = idBarre;
    }
    
    public void setIdType(int idType){
        this.idType = idType;
    }
    
    public void setNoeudOrigine(int NoeudOrigine){
        this.noeudOrigine = NoeudOrigine;
    }
    
    public void setNoeudFin(int NoeudFin){
        this.noeudFin = NoeudFin;
    }
    
    /*
    Affichage
    Barre;<id>;<id>;<id>;<id>
    Exemple : Barre;3;1;1;2
    */
    
    public String toStringBarre(){
        String res = "barre;" + this.idBarre + ";" + this.idType + ";" + this.noeudOrigine + ";" + this.noeudFin ;
        return res;
    }
    
    /*
    public static boolean verification(int[]tab, int val){
        boolean b = false;
        for(int i : tab){
            if(i==val){
                b=true;
                break;
            }
        }
        return b;
    }
    */

    public static void main(String[] args) {
        Barre exemple1 = new Barre(1, 2, 2, 8);
        System.out.println(exemple1.toStringBarre());
        Barre exemple2 = new Barre(1, 6, 9, 7);
        System.out.println(exemple2.toStringBarre());
    }
    
}
