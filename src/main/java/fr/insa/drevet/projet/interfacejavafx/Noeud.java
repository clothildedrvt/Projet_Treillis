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
public class Noeud {
    
    // Déclaration des attributs
    protected int idNoeud;
    
    //Constructeur
    
    public Noeud(int idNoeud){
        this.idNoeud = idNoeud;
    }
    
    // Getters
    
    public int getIdNoeud(){
        return this.idNoeud;
    }
    
    // Setters
    
    public void setIdNoeud(int idNoeud){
        this.idNoeud = idNoeud;
    }
    
    /*
    Affichage
    */
    
    public String toStringNoeud(){
        String res = "Noeud;" + this.idNoeud ;
        return res;
    }
    
    
    
    public static void main(String[] args) {
        Noeud exempleN = new Noeud(2);
        System.out.println(exempleN.toStringNoeud());
    }
    
}
