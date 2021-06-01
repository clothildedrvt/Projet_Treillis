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
public class Appui extends Noeud{
    
    // Déclaration des attributs    
    private Point P;
    private Double pos;
    private int idTT;
    
    // Création d'un constructeur    
    public Appui(int idNoeud, Point P, Double pos, int idTT) {
        super(idNoeud);
        this.P = P;
        this.pos = pos;
        this.idTT = idTT;
    }
   
    // Création d'un Appui "nul"
    public Appui(){
        this(0, null, 0.0, 0);
    }
    
    // Getters    
    public Point getP() {
        return P;
    }
    public Double getPos(){
        return pos;
    }
    public int getIdTT() {
        return idTT;
    }
   
    // Setters   
    public void setP(Point P) {
        this.P = P;
    }
    public void setPos(Double pos) {
        this.pos = pos;
    }
    public void setIdTT(int idTT) {
        this.idTT = idTT;
    }
   
    /*
    Affichage
    Appui;<id>;<Point>;<Point>;<TriangleDeTerrain>
    Exemple : Appui;1;(3,4);(6,5);TT1
    */
    
    @Override
    public String toString(){
        String res = "Appui;" + super.idNoeud + ";" + this.P + ";" + this.pos + ";" + this.idTT ;
        return res;
    }
    
    public void fromString(String ligne) throws IOException {
        if ((ligne == null) || ligne.contains(";")){
            throw new IOException ("Appui non conforme (" + ligne + ")");
        }else{
            ligne.strip(); //tous les blancs sont enlevés
            String[]tokens = ligne.split(";"); //Sépare la ligne à chaque ; pour mettre chaque partie dans la case d'un tableau
            
            // On vérifie que l'appui contient le bon nombre de paramètres 
            if (tokens.length <5){
                throw new IOException("Cet appui ne contient pas le bon nombre de paramètre (" + ligne + ")");
            }
            
            // On commence à tokens[1] et non à tokens[0] pour ne pas prendre en compte le commentaire en début de ligne
            super.idNoeud = Integer.parseInt(tokens[1]);
            if (super.idNoeud <1){
                throw new IOException ("L'id doit être strictement positif (" + ligne + ")");
            }
            
            // On créer un point pour pouvoir appeler la méthode fromString de la classe Point
            Point pointP = new Point();
            pointP.fromString(tokens[2]);
            
            this.pos = Double.parseDouble(tokens[3]);
            if (this.pos<0 || this.pos>1){
                throw new IOException ("La position du noeud est incorrecte (" + ligne + ")");
            }
            
            this.idTT = Integer.parseInt(tokens[4]);
            if (this.idTT<0){
                throw new IOException ("");
            }
        }
    }
    
}
