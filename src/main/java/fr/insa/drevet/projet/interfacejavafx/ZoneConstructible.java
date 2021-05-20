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
public class ZoneConstructible {
    
    // Déclaration des attributs
    
    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;
    
    // Création d'un constructeur
    
    public ZoneConstructible(double xMin, double xMax, double yMin, double yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        if(xMin>xMax){
            throw new Error("Inverser les abscisses max et min de la zone");
        }
        this.yMin = yMin;
        this.yMax = yMax;
        if (yMin>yMax){
            throw new Error("Inverser les ordonnées max et min de la zone");
        }
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
    
    public String toStringZoneConstructible(){
        String res = "ZoneConstructible;" + this.xMin + ";" + this.xMax + ";" + this.yMin + ";" + this.yMax;
        return res;
    }

    public static void main(String[] args) {
        ZoneConstructible exemple = new ZoneConstructible(1,5,-1,8);
        System.out.println(exemple.toStringZoneConstructible());
    }
    
}
