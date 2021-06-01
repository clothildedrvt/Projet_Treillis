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
public class ZoneConstructible {
    
    // Déclaration des attributs    
    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;
    
    // Création d'un constructeur    
    public ZoneConstructible(double xMin, double xMax, double yMin, double yMax) throws IOException {
        this.xMin = xMin;
        this.xMax = xMax;
        if(xMin>xMax){
            throw new IOException("Inverser les abscisses max et min de la zone");
        }
        this.yMin = yMin;
        this.yMax = yMax;
        if (yMin>yMax){
            throw new IOException("Inverser les ordonnées max et min de la zone");
        }
    }
    
    // Création d'une ZoneConstructible "nulle"
    public ZoneConstructible() throws IOException{
        this(0,0,0,0);
    }
    
    // Getters    
    public double getXMin() {
        return xMin;
    }
    public double getXMax() {
        return xMax;
    }
    public double getYMin() {
        return yMin;
    }
    public double getYMax() {
        return yMax;
    }
    
    // Setters    
    public void setXMin(double xMin) {
        this.xMin = xMin;
    }
    public void setXMax(double xMax) {
        this.xMax = xMax;
    }
    public void setYMin(double yMin) {
        this.yMin = yMin;
    }
    public void setYMax(double yMax) {
        this.yMax = yMax;
    }
    
    /*
    Affichage
    ZoneConstructible;<double>;<double>;<double>;<double>
    Exemple : ZoneConstructible;1;5;-1;8
    */
    
    @Override
    public String toString(){
        String res = "ZoneConstructible;" + this.xMin + ";" + this.xMax + ";" + this.yMin + ";" + this.yMax;
        return res;
    }

    public void fromString(String ligne) throws IOException{
        if ((ligne == null) || ligne.contains(";")){
            throw new IOException ("Zone Constructible non conforme (" + ligne + ")");
        }
        else{
            ligne.strip(); //tous les blancs sont enlevés
            String[]tokens = ligne.split(";"); //Sépare la ligne à chaque ; pour mettre chaque partie dans la case d'un tableau
            
            // On vérifie si la zone constructible a bien le bon nombre de paramètres
            if (tokens.length <5){
                throw new IOException("Cette zone constructible ne contient pas le bon nombre de paramètre (" + ligne + ")");
            }
            
            // On commence à tokens[1] pour ne pas prendre en compte tokens[0] qui est le commentaire en début de ligne
            this.xMin = Double.parseDouble(tokens[1]);
            this.xMax = Double.parseDouble(tokens[2]);
            // On vérifie que l'abscisse minimale est bien inférieure à l'abscisse maximale
            if(this.xMax<this.xMin){
                throw new IOException("xMin > xMax (" + ligne + ")");
            }
            
            this.yMin = Double.parseDouble(tokens[3]);
            this.yMax = Double.parseDouble(tokens[4]);
            // On vérifie que l'ordonnée minimale est bien inférieure à l'ordonnée maximale
            if(this.yMax<this.yMin){
                throw new IOException("yMin > yMax (" + ligne + ")");
            }
        }
    }
    
}
