/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dreve
 */
public class Treillis {
    
    // Déclaration des attributs
    private ZoneConstructible zone;
    private Map<Integer, TriangleDeTerrain> ensTriangles;
    private Map<Integer, Barre> ensBarre;
    private Map<Integer, Noeud> ensNoeud;
    private Map<Integer, TypeBarre> catalogueBarres;
    
    // Création d'un constructeur
    public Treillis(ZoneConstructible zone, Map<Integer, TriangleDeTerrain> ensTriangles, Map<Integer, Barre> ensBarre, Map<Integer, Noeud> ensNoeud, Map<Integer, TypeBarre> catalogueBarres) {
        this.zone = zone;
        this.ensTriangles = ensTriangles;
        this.ensBarre = ensBarre;
        this.ensNoeud = ensNoeud;
        this.catalogueBarres = catalogueBarres;
    }
    
    // Création d'un Treillis "nul"
    public Treillis(){
        this(null, null, null, null, null); 
    }
    
    // Getters
    public ZoneConstructible getZone() {
        return zone;
    }
    public Map<Integer, TriangleDeTerrain> getEnsTriangles() {
        return ensTriangles;
    }
    public Map<Integer, Barre> getEnsBarre() {
        return ensBarre;
    }
    public Map<Integer, Noeud> getEnsNoeud() {
        return ensNoeud;
    }
    public Map<Integer, TypeBarre> getCatalogueBarres() {
        return catalogueBarres;
    }
        
    // Setters
    public void setZone(ZoneConstructible zone) {
        this.zone = zone;
    }
    
    // Pour les autres attributs on ne peut pas faire des setters "normaux" : comme ce sont des Maps, il y a plus de vérifications à faire
    public void addTriangleDeTerrain (TriangleDeTerrain TT) throws IOException{
        // Initialisation de la map si c'est le premier triangle ajouté
        if(this.ensTriangles == null){
            this.ensTriangles = new HashMap<>();
        }
        // Il faut que l'id soit unique
        if(this.ensTriangles.containsKey(TT.getIdTriangle())){
            throw new IOException ("L'id du triangle de terrain est déjà utilisé");
        }
        // Ne pas avoir deux fois le même contenu dans 2 id différents
        for(TriangleDeTerrain lTT : this.ensTriangles.values()){ // l pour local
            if(lTT.equals(TT)){
                throw new IOException ("Ce triangle existe déjà");
            }
            
        }
        // Ajout du triangle à l'ensemble (id = clé)
        this.ensTriangles.put(TT.getIdTriangle(), TT);
    }
    
    public void addBarre (Barre barre) throws IOException{
        // Initialisation de la map si première barre ajoutée
        if (this.ensBarre == null){
            this.ensBarre = new HashMap<>();
        }
        // Il faut que l'id soit unique
        if(this.ensBarre.containsKey(barre.getIdBarre())){
            throw new IOException("L'id de cette barre est déjà utilisé");
        }
        // Ne pas avoir deux fois le même contenu dans 2 id différents
        for (Barre lbarre : this.ensBarre.values()){ // l pour local
            if(lbarre.equals(barre)){
                throw new IOException("Cette barre existe déjà");
            }
        }
        // Ajout de la barre à l'ensemble (id = clé)
        this.ensBarre.put(barre.getIdBarre(), barre);
    }
    
    public void addNoeud (Noeud noeud) throws IOException{
        // Initialisation de la map si première barre ajoutée
        if (this.ensNoeud == null){
            this.ensNoeud = new HashMap<>();
        }
        // Il faut que l'id soit unique
        if(this.ensNoeud.containsKey(noeud.getIdNoeud())){
            throw new IOException("L'id de ce noeud est déjà utilisé");
        }
        // Ne pas avoir deux fois le même contenu dans 2 id différents
        for (Noeud lnoeud : this.ensNoeud.values()){ // l pour local
            if(lnoeud.equals(noeud)){
                throw new IOException("Ce noeud existe déjà");
            }
        }
        // Ajout de la barre à l'ensemble (id = clé)
        this.ensNoeud.put(noeud.getIdNoeud(), noeud);
    }
    
    public void addTypeBarre (TypeBarre type) throws IOException{
        // Initialisation de la map si première barre ajoutée
        if (this.catalogueBarres == null){
            this.catalogueBarres = new HashMap<>();
        }
        // Il faut que l'id soit unique
        if(this.catalogueBarres.containsKey(type.getIdTypeBarre())){
            throw new IOException("L'id de ce type de barre est déjà utilisé");
        }
        // Ne pas avoir deux fois le même contenu dans 2 id différents
        for (TypeBarre ltype : this.catalogueBarres.values()){ // l pour local
            if(ltype.equals(type)){
                throw new IOException("Ce type de barre existe déjà");
            }
        }
        // Ajout du type de barre au catalogue (id = clé)
        this.catalogueBarres.put(type.getIdTypeBarre(), type);
    }
    
    public void lecture (String fichier) throws IOException{
        try{
            // Lecture du fichier
            BufferedReader br = new BufferedReader(new FileReader(fichier));
            // On lit le fichier ligne par ligne
            String ligne = br.readLine();
            // On vérifie si le fichier est vide , sinon on continue la lecture
            if (ligne == null){
                throw new IOException("Le fichier est vide");
            }
            else {
                while((ligne != null) && (ligne.substring(0,2).equalsIgnoreCase("//"))){
                    ligne = br.readLine();
                }
            }
            
            // On vérifie si le fichier contient une zone constructible
            if((ligne == null) || !(ligne.substring(0,17).equalsIgnoreCase("ZoneConstructible"))){ // si une substring du début de la ligne jusqu'au caractère 17 est différent de ZoneConstructible : pas de ligne contenant une zone constructible
                throw new IOException("Le fichier n'a pas de zone constructible");
            }
            else{
                this.zone = new ZoneConstructible();
                this.zone.fromString(ligne);
                ligne = br.readLine();
            }
            
            // On vérifie si le fichier contient un triangle de terrain
            if((ligne == null) || !(ligne.substring(0,8).equalsIgnoreCase("Triangle"))){
                throw new IOException("Le fichier n'a pas de triangle");
            }
            else{
                TriangleDeTerrain t = new TriangleDeTerrain();
                t.fromString(ligne);
                this.addTriangleDeTerrain(t);
                ligne = br.readLine();
                // Continuer de lire tant que la fin du Triangle n'a pas été annoncée "FINTRIANGLE"
                while((ligne != null) && !(ligne.substring(0,11).equalsIgnoreCase("FINTRIANGLE"))){
                    if((ligne == null) || !(ligne.substring(0, 8).equalsIgnoreCase("Triangle"))){
                        throw new IOException("La partie triangle ne contient pas que des triangles");
                    }
                    else{
                        t = new TriangleDeTerrain();
                        t.fromString(ligne);
                        this.addTriangleDeTerrain(t);
                        ligne = br.readLine();
                    }
                }
            }
            
            // On vérifie si le fichier contient bien un type de Barre
            if((ligne == null) || !(ligne.substring(0,9).equalsIgnoreCase("TypeBarre"))){
                throw new IOException("Le fichier n'a pas de TypeBarre");
            }
            else{
                TypeBarre type = new TypeBarre();
                type.fromString(ligne);
                this.addTypeBarre(type);
                ligne = br.readLine();
                // Continuer de lire tant que la fin du Type des barres n'a pas été annoncée "FINCATALOGUE"
                while((ligne != null) && !(ligne.substring(0,12).equalsIgnoreCase("FINCATALOGUE"))){
                    if((ligne == null) || !(ligne.substring(0, 9).equalsIgnoreCase("TypeBarre"))){
                        throw new IOException("La partie catalogue ne contient pas que des types de barre");
                    }
                    else{
                        type = new TypeBarre();
                        type.fromString(ligne);
                        this.addTypeBarre(type);
                        ligne = br.readLine();
                    }
                }
            }
            
            // On vérifie si le fichier contient bien des appuis
            if((ligne== null) || !(ligne.substring(0,5).equalsIgnoreCase("Appui"))){
                throw new IOException("Le fichier n'a pas d'appuis");
            } 
            else{
                Appui a = new Appui();
                a.fromString(ligne);
                this.addNoeud(a);
                ligne = br.readLine();
            }
            
            // On vérifie si le fichier contient bien des barres
            if((ligne == null) || !(ligne.substring(0,5).equalsIgnoreCase("Barre"))){
                throw new IOException("Le fichier n'a pas de barre");
            }
            else{
                Barre b = new Barre();
                b.fromString(ligne);
                this.addBarre(b);
                ligne = br.readLine();
                // Continuer de lire tant que la fin du Triangle n'a pas été annoncée "FINTRIANGLE
                while((ligne != null) && !(ligne.substring(0,9).equalsIgnoreCase("FINBARRES"))){
                    if((ligne == null) || !(ligne.substring(0, 5).equalsIgnoreCase("Barre"))){
                        throw new IOException("La partie barre ne contient pas que des barres");
                    }
                    else{
                        b = new Barre();
                        b.fromString(ligne);
                        this.addBarre(b);
                        ligne = br.readLine();
                    }
                }
            }
                        
            br.close();    
        }
        catch(FileNotFoundException err){
            System.out.println("Erreur : le fichier n'existe pas " + err);
        }
        catch(IOException err){
            System.out.println("Erreur " + err);
        }
        
    }
    
}
