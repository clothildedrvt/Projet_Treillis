/*
Copyright 2000- Francois de Bertrand de Beuvron
This file is part of CoursBeuvron.
CoursBeuvron is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
CoursBeuvron is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.insa.drevet.projet.interfacejavafx;

import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//import recup.Lire;

/**
 *
 * @author francois
 */
public class Point extends FigureSimple {
    
    public static double RAYON_IN_DRAW = 8; //fixe le rayon des points.

    // Déclaration des attributs
    private double px;
    private double py;

    // Création d'un constructeur
    public Point(double px, double py, Color couleur) {
        super(couleur);
        this.px = px;
        this.py = py;
    }

    // Création d'un point nooir si la couleur n'est pas précisée
    public Point(double px, double py) {
        this(px, py, Color.BLACK);
    }

    // Création d'un Point "nul"
    public Point() {
        this(0, 0);
    }

    /**
     * initialise comme une copie du point
     */
    public Point(Point modele) {
        this(modele.px,modele.px,modele.getCouleur());
    }
    
    // Getters
    public double getPx() {
        return px;
    }
    public double getPy() {
        return py;
    }

    // Setters
    public void setPx(double px) {
        this.px = px;
    }
    public void setPy(double py) {
        this.py = py;
    }

    @Override
    public String toString() {
        return "(" + px + "," + py + ')';
    }

    public void fromString (String ligne) throws IOException{
        if ((ligne == null) || ligne.contains(";")){
            throw new IOException ("Point non conforme (" + ligne + ")");
        }
        else{
            ligne.strip(); //tous les blancs sont enlevés
            String[]tokens = ligne.split(";"); //Sépare la ligne à chaque ; pour mettre chaque partie dans la case d'un tableau
            
            // On vérifie que le point a bien le bon nombre de paramètres
            if (tokens.length <3){
                throw new IOException("Ce Point ne contient pas le bon nombre de paramètre (" + ligne + ")");
            }
            
            // On commence à tokens[1] pour ne pas prendre en compte le commentaire en début de ligne
            this.px = Double.parseDouble(tokens[1]);
            this.py = Double.parseDouble(tokens[2]);
        }
    }
    
    public static Point demandePoint() {
        System.out.println("abscisse : ");
        double px = Lire.d();
        System.out.println("ordonnée : ");
        double py = Lire.d();
        return new Point(px, py);
    }

    @Override
    public double maxX() {
        return this.px;
    }
    @Override
    public double minX() {
        return this.px;
    }
    @Override
    public double maxY() {
        return this.py;
    }
    @Override
    public double minY() {
        return this.py;
    }

    @Override
    public double distancePoint(Point p) {
        double dx = this.px - p.px;
        double dy = this.py - p.py;
        return Math.sqrt(dx*dx+dy*dy);
    }

    @Override
    public void dessine(GraphicsContext context) {
        context.setFill(this.getCouleur());
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    //dessine un oval/rond pour être plus visible.
    }

    @Override
    public void dessineSelection(GraphicsContext context) {
        context.setFill(Figure.COULEUR_SELECTION);
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);      
    }

    public void save(Writer w, Numeroteur<Figure> num) throws IOException {
        if(! num.objExist(this)) {
            int id = num.creeID(this);
            w.append("Point;"+id+";"+this.px+";"+this.py+
                    ";" + FigureSimple.saveColor(this.getCouleur()) + "\n");
        }
    }

}