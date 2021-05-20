/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx;

import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author dreve
 */
public class Groupe extends Figure{
    
    // Déclaration des attributs
    
    private List<Figure> contient;
    
    // Création d'un constructeur
    
    public Groupe(){
        this.contient = new ArrayList<Figure>();
    }
    
    public void add(Figure f){
        if(f.getGroupe() != this){
            if(f.getGroupe() != null){
                throw new Error("Figure déjà dans un autre groupe");
            }
            this.contient.add(f);
            f.setGroupe(this);
        }
    }
    
    public static String indente(String toIndente, String prefix){
        return prefix + toIndente.replaceAll("\n","\n" + prefix);
    }
    
    public String toStringGroupe(){
        String res = "Groupe {\n";
        for (int i = 0; i<this.contient.size(); i++){
            res = res + indente(this.contient.get(i).toString(), " ") + "\n";
        }
        return res + "}";
    }
    
    public void sousGroupe(List<Figure> lf){
        for(int i =0; i<lf.size(); i++){
            Figure f = lf.get(i);
            if(f.getGroupe() != this){
                throw new Error(f + "n'appartient pas au groupe" + this);
            }
            this.contient.remove(f);
            f.setGroupe(null);
        }
        Groupe sg = new Groupe();
        for(int i = 0; i<lf.size(); i++){
            sg.add(lf.get(i));
        }
        this.add(sg);
    }
    
    public Point choisiPoint(){
        List<Point> lp = new ArrayList<>();
        System.out.println("Liste des points disponibles : ");
        int nbr = 0;
        for(int i = 0; i<this.contient.size(); i++){
            Figure f = this.contient.get(i);
            if(f instanceof Point){
                nbr++;
                lp.add((Point) f);
                System.out.println(nbr + ") " + f);
            }
        }
        if (nbr == 0){
            System.out.println("Aucun point disponible");
            return null;
        }
        else{
            int rep = -1;
            while(rep<0 || rep>nbr){
                System.out.println("Votre choix (0 pour annuler) : ");
                rep = Lire.i();
            }
            if (rep ==0){
                return null;
            }
            else{
                return lp.get(rep-1);
            }
        }
    }
    
    public List<Figure> choisiFigures(){
        List<Figure> res = new ArrayList<>();
        int rep = -1;
        while(rep!=0){
            System.out.println("Liste des figures disponibles : ");
            for(int i = 0; i<this.contient.size(); i++){
                System.out.println((i+1) + ") " + this.contient.get(i));
            }
            System.out.println("Votre choix (0 pour finir) : ");
            rep = Lire.i();
            if(rep>0 && rep<=this.contient.size()){
                Figure f = this.contient.get(rep-1);
                if(res.contains(f)){
                    System.out.println("Déjà séléctionnée!");
                }
                else{
                    res.add(f);
                }
                System.out.println(res.size() + "figure(s) séléctionnée(s)");
            }
        }
        return res;
    }
    
    public void menuTexte(){
        int rep = -1;
        while (rep != 0){
            System.out.println("1) Afficher le groupe");
            System.out.println("2) Ajouter un point");
            System.out.println("3) Ajouter un segment avec deux nouveaux points");
            System.out.println("4) Ajouter un segment sur deux points existants");
            System.out.println("5) Créer un sous-groupe");
            System.out.println("0) Quitter");
            System.out.println("Votre choix :");
            rep = Lire.i();
            if(rep == 1){
                System.out.println(this);  
            }
            else if(rep == 2){
                Point p = Point.demandePoint();
                this.add(p);
            }
            else if(rep == 3){
                Segment s = Segment.demandeSegment();
                this.add(s);
            }
            else if(rep == 4){
                System.out.println("Choisissez le début du segment");
                Point debut = this.choisiPoint();
                if(debut != null){
                    System.out.println("Choisissez la fin du segment");
                    Point fin = this.choisiPoint();
                    Segment s = new Segment(debut, fin);
                    this.add(s);
                }
            }
            else if(rep == 5){
                List<Figure> select = this.choisiFigures();
                this.sousGroupe(select);
            }
        }
    }

    @Override
    public double maxX() {
        if (this.contient.isEmpty()){
            return 0;
        }
        else{
            double max = this.contient.get(0).maxX();
            for (int i =1; i<this.contient.size(); i++){
                double cur = this.contient.get(i).maxX();
                if(cur>max){
                    max=cur;
                }
            }
            return max;
        }
    }
}
