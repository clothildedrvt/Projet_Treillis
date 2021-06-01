/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx;

import java.io.IOException;

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
    
    // Constructeur d'un Noeud "nul"
    public Noeud(){
        this(0);
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
    
    @Override
    public String toString(){
        String res = "Noeud;" + this.idNoeud ;
        return res;
    }
    
    public void fromString(String ligne) throws IOException{
        if ((ligne == null) || ligne.contains(";")){
            throw new IOException ("Noeud non conforme (" + ligne + ")");
        }
        else{
            ligne.strip(); //tous les blancs sont enlevés
            String[]tokens = ligne.split(";"); //Sépare la ligne à chaque ; pour mettre chaque partie dans la case d'un tableau
            
            // On vérifie que le Noeud contient bien le bon nombre de paramètres
            if (tokens.length < 2){
                throw new IOException("Ce noeud ne contient pas le bon nombre de paramètre (" + ligne + ")");
            }
            
            // On commence à tokens[1] pour ne pas prendre en compte le commentaire en début de ligne
            this.idNoeud = Integer.parseInt(tokens[1]);
            if (this.idNoeud<1){
                throw new IOException ("L'id doit être strictement positif (" + ligne + ")");
            }
        }
    } 
    
}
