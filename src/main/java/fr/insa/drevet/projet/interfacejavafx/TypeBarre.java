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
public class TypeBarre {
    
    // Déclaration des attributs    
    private int idTypeBarre;
    private double cout;
    private double LMin;
    private double LMax;
    private double RMaxTension;
    private double RMaxCompression;
    
    // Création d'un constructeur    
    public TypeBarre(int idTypeBarre, double cout, double LMin, double LMax, double RMaxTension, double RMaxCompression){
        this.idTypeBarre = idTypeBarre;
        this.cout = cout;
        this.LMin = LMin;
        this.LMax = LMax;
        this.RMaxTension = RMaxTension;
        this.RMaxCompression = RMaxCompression;
    }
    
    // Création d'un TypeBarre "nul"
    public TypeBarre(){
        this(0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }
    
    // Getters    
    public int getIdTypeBarre(){
        return this.idTypeBarre;
    }    
    public double getCout(){
        return this.cout;
    }    
    public double getLMin(){
        return this.LMin;
    }    
    public double getLMax(){
        return this.LMax;
    }    
    public double getRMaxTension(){
        return this.RMaxTension;
    }    
    public double getRMaxCompression(){
        return this.RMaxCompression;
    }
    
    // Setters    
    public void setIdTypeBarre(int idTypeBarre){
        this.idTypeBarre = idTypeBarre;
    }    
    public void setCout(double cout){
        this.cout = cout;
    }    
    public void setLMin(double LMin){
        this.LMin = LMin;
    }    
    public void setLMax(double LMax){
        this.LMax = LMax;
    }    
    public void setRMaxTension(double RMaxTension){
        this.RMaxTension = RMaxTension;
    }    
    public void setRMaxCompression(double RMaxCompression){
        this.RMaxCompression = RMaxCompression;
    }
    
    /*
    Affichage
    TypeBarre;<id>;<double>;<double>;<double>;<double>;<double>
    Exemple : TypeBarre;1;100.0;1.0;5.0;1000.0;2000.0
    */
    
    @Override
    public String toString(){
        String res = "TypeBarre;" + this.cout + ";" + this.LMin + ";" + this.LMax + ";" + this.RMaxTension + ";" + this.RMaxCompression ;
        return res;
    }
    
    public void fromString (String ligne) throws IOException{
        if ((ligne == null) || ligne.contains(";")){
            throw new IOException ("Type de Barre non conforme (" + ligne + ")");
        }
        else{
            ligne.strip(); //tous les blancs sont enlevés
            String[]tokens = ligne.split(";"); //Sépare la ligne à chaque ; pour mettre chaque partie dans la case d'un tableau
            
            // On vérifie si le type de barre a bien le bon nombre de paramètres
            if (tokens.length <7){
                throw new IOException("Ce type de barre ne contient pas le bon nombre de paramètre (" + ligne + ")");
            }
            
            // On commence à tokens[1] pour ne pas prendre en compte le commentaire en début de ligne
            this.idTypeBarre = Integer.parseInt(tokens[1]);
            if (this.idTypeBarre<1){
                throw new IOException ("L'id doit être strictement positif (" + ligne + ")");
            }
            
            this.cout = Double.parseDouble(tokens[2]);
            if (this.cout < 0){
                throw new IOException("Le prix doit être positif (" + ligne + ")");
            }
            
            this.LMin = Double.parseDouble(tokens[3]);
            this.LMax = Double.parseDouble(tokens[4]);
            // LMin doit être plus petite que LMax
            if (this.LMin > this.LMax){
                throw new IOException("La longeur minimum du type de barre doit être plus petite que la longueur maximum (" + ligne + ")");
            }
            
            this.RMaxTension = Double.parseDouble(tokens[5]);
            if(this.RMaxTension <= 0){
                throw new IOException("La résistance maximale à la tension doit être positive (" + ligne + ")");
            }
            
            this.RMaxCompression = Double.parseDouble(tokens[6]);
            if (this.RMaxCompression <= 0){
                throw new IOException("La résistance maximale à la compression doit être positive (" + ligne + ")");
            }
        }
        
    }
    
    /*
    public static void main(String[] args) {
        TypeBarre exemple = new TypeBarre(1, 100.0, 1.0, 5.0, 1000.0, 2000.0);
        System.out.println(exemple.toString());
    }
    */

}
