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
public abstract class Figure {
    
    //Déclaration des attributs

    private Groupe groupe;
    
    // Getters
    
    public Groupe getGroupe(){
        return groupe;
    }
    
    // Setters
    
    void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }
    
    public abstract double maxX();
    
}
