/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.drevet.projet.interfacejavafx.gui;

import fr.insa.drevet.projet.interfacejavafx.gui.DessinCanvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.event.*;

/**
 *
 * @author dreve
 */
public class MainDessin extends BorderPane{
    
    // Déclaration des attributs
    
    private RadioButton rbSelect;
    private RadioButton rbPoint;
    private RadioButton rbSegment;
    private Button bGroupe;
    private Button bCouleur;
    private DessinCanvas cDessin;
    
    // Création d'un constructeur
    
    public MainDessin(){
        this.rbSelect = new RadioButton("Select");
        this.rbPoint = new RadioButton("Point");
        // this.rbPoint.setOnMouseClicked(eh);
        this.rbSegment = new RadioButton("Segment");
        
        this.bGroupe = new Button("Groupe");
        this.bGroupe.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t){
                System.out.println("Bouton Groupe cliqué");
            }
        });
        this.bCouleur = new Button("Couleur");
        this.bCouleur.setOnAction((t)->{
            System.out.println("Bouton Couleur cliqué"); 
        });
        /*
        this.bCouleur.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent t){
                System.out.println("entered couleur en : " + t.getX() + "," + t.getY());
            }
        });
        */
        VBox vbGauche = new VBox(this.rbSelect, this.rbPoint, this.rbSegment, this.bGroupe, this.bCouleur);
        this.setLeft(vbGauche); 
        
        this.cDessin = new DessinCanvas(200.0, 200.0);
        this.setCenter(this.cDessin);
    }
}
