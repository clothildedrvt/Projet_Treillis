/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author dreve
 */
public class DessinCanvas extends Canvas{
    
    // Constructeur
    
    public DessinCanvas(double w, double h){
        super(w, h);
        GraphicsContext context = this.getGraphicsContext2D();
        context.setFill(Color.RED);
        context.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}
