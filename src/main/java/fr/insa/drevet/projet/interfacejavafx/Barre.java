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
    
    // Création d'un barre "nulle"
    public Barre(){
        this(0, 0, 0, 0);
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
    
    @Override
    public String toString(){
        String res = "barre;" + this.idBarre + ";" + this.idType + ";" + this.noeudOrigine + ";" + this.noeudFin ;
        return res;
    }
    
    public void fromString(String ligne) throws IOException{
        if ((ligne == null) || ligne.contains(";")){
            throw new IOException ("Barre non conforme (" + ligne + ")");
        }else{
            ligne.strip(); //tous les blancs sont enlevés
            String[]tokens = ligne.split(";"); // Sépare la ligne à chaque ; pour mettre chaque partie dans la case d'un tableau
            
            // On vérifie que la barre contient le bon nombre de paramètres
            if (tokens.length<5){
                throw new IOException("Une Barre doit contenir 4 paramètres (" + ligne + ")");
            }
            
            // On commence à tokens[1] pour ne pas prendre en compte le commentaire en début de ligne
            this.idBarre = Integer.parseInt(tokens[1]);
            if (this.idBarre<1){
                throw new IOException ("L'id doit être strictement positif (" + ligne + ")");
            }
            
            this.idType = Integer.parseInt(tokens[2]);
            if (this.idType<1){
                throw new IOException ("L'id doit être strictement positif (" + ligne + ")");
            }
            
            this.noeudOrigine = Integer.parseInt(tokens[3]);
            if (this.noeudOrigine < 0){
                throw new IOException ("L'entier correspondant au noeud d'origine doit être positif(" + ligne + ")");
            }
            
            this.noeudFin = Integer.parseInt(tokens[4]);
            if (this.noeudFin < 0){
                throw new IOException ("L'entier correspondant au noeud de fin  doit être positif(" + ligne + ")");
            }
        }
    }
    
    
}
