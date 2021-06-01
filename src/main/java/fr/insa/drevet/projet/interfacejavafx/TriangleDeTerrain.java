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
    
    // Création d'un TriangleDeTerrain "nul"
    public TriangleDeTerrain(){
        this(0, null, null, null);
    }
    
    //Création des segments  
    Segment segment1 = new Segment(point1, point2);
    Segment segment2 = new Segment(point2, point3);
    Segment segment3 = new Segment(point3, point1);
    
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
    
    /*
    Affichage
    
    */

    public String toString() {
        String res = "TriangleDeTerrain;" + this.idTriangle + ";" + this.point1 + ";" + this.point2 + ";" + this.point3 ;
        return res;
    }
    
    public void fromString(String ligne) throws IOException {
        if ((ligne == null) || ligne.contains(";")){
            throw new IOException ("Triangle de Terrain non conforme (" + ligne + ")");
        }
        else{
            ligne.strip(); //tous les blancs sont enlevés
            String[]tokens = ligne.split(";"); //Sépare la ligne à chaque ; pour mettre chaque partie dans la case d'un tableau
            
            // On vérifie si le triangle a bien le bon nombre de paramètres
            if (tokens.length <5){
                throw new IOException("Ce type de barre ne contient pas le bon nombre de paramètre (" + ligne + ")");
            }
            
            // On commence à tokens[1] pour ne pas prendre en compte le commentaire en début de ligne
            this.idTriangle = Integer.parseInt(tokens[1]);
            if(this.idTriangle<0){
                throw new IOException ("L'id doit être strictement positif (" + ligne + ")");
            }
            
            // On crée quatre nouveaux point pour appeler la méthode fromString de la classe Point
            Point point1 = new Point();
            point1.fromString(tokens[2]);
            Point point2 = new Point();
            point2.fromString(tokens[3]);
            Point point3 = new Point();
            point3.fromString(tokens[4]);
        }
    }
    
    
}
