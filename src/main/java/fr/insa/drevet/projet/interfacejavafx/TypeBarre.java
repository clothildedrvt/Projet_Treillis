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
    
    public String toStringTypeBarre(){
        String res = "TypeBarre;" + this.cout + ";" + this.LMin + ";" + this.LMax + ";" + this.RMaxTension + ";" + this.RMaxCompression ;
        return res;
    }
    
    public static void main(String[] args) {
        TypeBarre exemple = new TypeBarre(1, 100.0, 1.0, 5.0, 1000.0, 2000.0);
        System.out.println(exemple.toStringTypeBarre());
    }

}
