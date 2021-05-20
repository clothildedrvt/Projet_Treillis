/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx;

import java.awt.Color;

/**
 *
 * @author dreve
 */
public abstract class FigureSimple extends Figure{
    
    // Déclaration des attributs
    
    private Color couleur;
    
    // Création d'un constructeur

    public FigureSimple(Color couleur) {
        this.couleur = couleur;
    }
    
}
