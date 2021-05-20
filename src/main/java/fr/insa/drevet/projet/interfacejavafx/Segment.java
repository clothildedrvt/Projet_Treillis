/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx;

import java.awt.Color;
import java.lang.Math.*;


/**
 *
 * @author dreve
 */
public class Segment extends FigureSimple{
    
    //Déclaration des attributs
    
    private Point pointOrigine;
    private Point pointFin;
    
    //Constructeur
    
    public Segment(Point p1, Point p2, Color couleur){
        super(couleur);
        this.pointOrigine = p1;
        this.pointFin = p2;
    }
    
    public Segment(Point p1,Point p2){
        this(p1, p2, Color.black);
    }
    
    //Getters
    
    public Point getPointOrigine(){
        return this.pointOrigine;
    }
    
    public Point getPointFin(){
        return this.pointFin;
    }
    
    //Setters
    
    public void setPointOrigine(Point p1){
        this.pointOrigine = p1;
    }
    
    public void setPointFin(Point p2){
        this.pointFin = p2;
    }
    
    /*
    Affichage
    Segment;<Point>;<Point>
    Exemple : Segment;(4,3);(2,8)
    */
    
    public String toStringSegment(){
        String res = "Segment;" + pointOrigine.toStringPoint() + ";" + pointFin.toStringPoint();
        return res;
    }
    
    public static Segment demandeSegment(){
        System.out.println("point début : ");
        Point debut = Point.demandePoint();
        System.out.println("point fin : ");
        Point fin = Point.demandePoint();
        return new Segment(debut, fin);
    }
    
    @Override
    public double maxX() {
        return Math.max(this.pointOrigine.maxX(), this.pointFin.maxX());
    }
    
    public static void main(String[] args) {
        Point p1 = new Point(4,3);
        Point p2 = new Point (2,8);
        Segment exemple = new Segment(p1, p2);
        System.out.println(exemple.toStringSegment());
    }

}
