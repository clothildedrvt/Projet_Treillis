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
public class NoeudSimple extends Noeud{
    
    // Déclaration des attributs
    
    private Point N;
    
    // Création d'un constructeur
    
    public NoeudSimple(int idNoeud, Point N){
        super(idNoeud);
        this.N = N;
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
    
    public String toStringNoeudSimple(){
        String res = "NoeudSimple;" + super.idNoeud + ";" + N.toStringPoint() ;
        return res;
    }
    
    
    
    public static void main(String[] args) {
        Point P = new Point(4,3);
        NoeudSimple exemple = new NoeudSimple(4, P);
        System.out.println(exemple.toStringNoeudSimple());
    }
    
}
