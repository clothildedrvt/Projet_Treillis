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
public class Appui extends Noeud{
    
    // Déclaration des attributs
    
    private Point P;
    private Point PT;
    private TriangleDeTerrain TT;
    
    // Création d'un constructeur
    
    public Appui(Point P, Point PT, TriangleDeTerrain TT, int idNoeud) {
        super(idNoeud);
        this.P = P;
        this.PT = PT;
        this.TT = TT;
    }
    
    // Getters
    
    public Point getP() {
        return P;
    }

    public Point getPT() {
        return PT;
    }

    public TriangleDeTerrain getTT() {
        return TT;
    }
    
    // Setters
    
    public void setP(Point P) {
        this.P = P;
    }

    public void setPT(Point PT) {
        this.PT = PT;
    }

    public void setTT(TriangleDeTerrain TT) {
        this.TT = TT;
    }
    
}
