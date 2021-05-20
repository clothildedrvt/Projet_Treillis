/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx;

import java.awt.Color;

/**
 *
 * @author dreve
 */
public class Point extends FigureSimple{
    
    // Déclaration des attributs
    
    private double px;
    private double py;
    
    // Création d'un constructeur
    
    public Point(double px, double py, Color couleur){
        super(couleur);
        this.px = px;
        this.py = py;
    }
    
    public Point(double px, double py){
        this(px, py, Color.black);
    }
    
    public Point(){
        this(0,0);
    }
    
    // Getters
    
    public double getPx(){
        return this.px;
    }
    
    public double getPy(){
        return this.py;
    }
    
    // Setters
    
    public void setPx(double px){
        this.px = px;
    }
    
    public void setPy(double py){
        this.py = py;
    }
    
    /*
    Affichage
    (<double>,<double>)
    Exemple : (2.0,3.0)
    */
    
    public String toStringPoint(){
        String res = "(" + this.px + "," + this.py + ")" ;
        return res;
    }
    
    public static Point demandePoint(){
        System.out.println("abscisse : ");
        double px = Lire.d();
        System.out.println("ordonée : ");
        double py = Lire.d();
        return new Point(px, py);
    }
    
    @Override
    public double maxX() {
        return this.px;
    }
    
    public static void main(String[] args) {
        Point exemple = new Point(3, 4);
        System.out.println(exemple.toStringPoint());
        Point test = new Point();
        System.out.println(test.toStringPoint());
    }
    
}
