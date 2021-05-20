/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx;

import fr.insa.drevet.projet.interfacejavafx.Segment;
import fr.insa.drevet.projet.interfacejavafx.Point;

/**
 *
 * @author dreve
 */
public class TriangleDeTerrain {
    
    // Déclaration des attributs
    
    private int idTriangle;
    private Point point1;
    private Point point2;
    private Point point3;
    
    // Création d'un constructeur

    public TriangleDeTerrain(int idTriangle, Point point1, Point point2, Point point3) {
        this.idTriangle = idTriangle;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }
    
    // Getters 
    
    public int getIdTriangle() {
        return idTriangle;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public Segment getSegment1() {
        return segment1;
    }

    public Segment getSegment2() {
        return segment2;
    }

    public Segment getSegment3() {
        return segment3;
    }
    
    // Setters

    public void setIdTriangle(int idTriangle) {
        this.idTriangle = idTriangle;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }    
    
    //Création des segments
    
    Segment segment1 = new Segment(point1, point2);
    Segment segment2 = new Segment(point2, point3);
    Segment segment3 = new Segment(point3, point1);
    
    
    
    /*
    Affichage
    */
    
}
