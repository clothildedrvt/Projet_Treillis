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
public class NoeudSimple extends Noeud{
    
    // Déclaration des attributs    
    private Point N;
    
    // Création d'un constructeur    
    public NoeudSimple(int idNoeud, Point N){
        super(idNoeud);
        this.N = N;
    }
    
    // Création d'un NoeudSimple "nul"
    public NoeudSimple(){
        this(0, null);
    }
    
    // Getters    
    public Point getN(){
        return this.N;
    }
    
    // Setters    
    public void setN(Point N){
        this.N = N;
    }
    
    /*
    Affichage
    NoeudSimple;<id>;(<double>;< double>)
    Exemple : NoeudSimple;3;(2.0,2.0)
    */
    
    @Override
    public String toString(){
        String res = "NoeudSimple;" + super.idNoeud + ";" + N.toString() ;
        return res;
    }
    
    public void fromString(String ligne) throws IOException{
        if ((ligne == null) || ligne.contains(";")){
            throw new IOException ("NoeudSimple non conforme (" + ligne + ")");
        }
        else{
            ligne.strip(); //tous les blancs sont enlevés
            String[]tokens = ligne.split(";"); //Sépare la ligne à chaque ; pour mettre chaque partie dans la case d'un tableau
            
            // On vérifie que le noeud simple a bien le bon nombre de paramètres
            if (tokens.length < 3){
                throw new IOException("Ce noeud simple ne contient pas le bon nombre de paramètre (" + ligne + ")");
            }
            
            // On commence à tokens[1] pour ne pas prendre en compte tokens[0] qui est le commentaire en début de ligne
            super.idNoeud = Integer.parseInt(tokens[1]);
            if (super.idNoeud < 1){
                throw new IOException ("L'id d'un Noeud doit être strictement positif (" + ligne + ")");
            }
            
            // On céer un nouveau point pour pouvoir appeler la méthode fromString de la classe Point
            Point p = new Point();
            p.fromString(tokens[2]);
        }
    }
 
}
