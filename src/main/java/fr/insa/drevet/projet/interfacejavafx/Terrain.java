/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author dreve
 */
public class Terrain {
    
    // Déclaration des attributs
    
    private ZoneConstructible zone;
    private Map<Integer, TriangleDeTerrain> ensTT;
    
    
    // Création d'un constructeur
    public Terrain(ZoneConstructible zone, Map<Integer, TriangleDeTerrain> ensTT) {
        this.zone = zone;
        this.ensTT = ensTT;
    }
    
    // Création d'un Terrain "nul"
    public Terrain(){
        this(null, null);
    }
    
    // Getters
    public ZoneConstructible getZone() {
        return zone;
    }
    public Map<Integer, TriangleDeTerrain> getEnsTT() {
        return ensTT;
    }
    
    // Setters
    public void setZone(ZoneConstructible zone) {
        this.zone = zone;
    }
    
    // Pour l'attribut ensTriangles on ne peut pas faire un setter "normal" : comme c'est une Map, il y a plus de vérifications à faire
    public void addTT (TriangleDeTerrain TT) throws IOException{
        // Initialisation de la map si c'est le premier triangle ajouté
        if(this.ensTT == null){
            this.ensTT = new HashMap<>();
        }
        // Il faut que l'id soit unique
        if(this.ensTT.containsKey(TT.getIdTriangle())){
            throw new IOException ("L'id du triangle de terrain est déjà utilisé");
        }
        // Ne pas avoir deux fois le même contenu dans 2 id différents
        for(TriangleDeTerrain lTT : this.ensTT.values()){ // l pour local
            if(lTT.equals(TT)){
                throw new IOException ("Ce triangle existe déjà");
            }
        }
        // Ajout du triangle à l'ensemble (id = clé)
        this.ensTT.put(TT.getIdTriangle(), TT);
    }
    
    
}
