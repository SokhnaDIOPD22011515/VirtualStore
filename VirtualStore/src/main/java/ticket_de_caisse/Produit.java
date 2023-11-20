package ticket_de_caisse;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Produit {
    private String nomArticle;
    private int quantite;
    private int tmpQuantite;
    private int compteur;
    private int tmpCompteur;
    private Button ajouter;
    private Button retirer;
    private Label labelBoutique;
    private Label labelPanier;
    private Label quantiteArticle;
    private ArrayList<Produit> listeProduitBoutique;
    private ArrayList<Produit> listeProduitPanier;
    private GridPane boutique;
    private VBox panier;


    public Produit(String nomArticle, int quantite, ArrayList<Produit> listeProduitBoutique, ArrayList<Produit> listeProduitPanier, 
    GridPane boutique, VBox panier) {
        this.nomArticle = nomArticle;
        this.quantite = quantite;
        this.ajouter = new Button("+");
        this.retirer = new Button("-");
        this.labelBoutique = new Label(nomArticle);
        this.labelPanier = new Label(nomArticle+": "+ compteur);
        this.quantiteArticle = new Label(String.valueOf(quantite));
        this.compteur = 0;
        this.tmpCompteur = this.compteur;
        this.tmpQuantite = this.quantite;
        this.listeProduitBoutique = listeProduitBoutique;
        this.listeProduitPanier = listeProduitPanier;
        this.boutique = boutique;
        this.panier = panier;
        this.ajouter.setOnAction(event -> {this.AjouterDansPanier();});
        this.retirer.setOnAction(event -> {this.RetirerDuPanier();});
    }

//Permet d'ajouter un produit dans la boutique
    public void AjouterDansBoutique(){
        this.boutique.addRow(this.boutique.getRowCount(), labelBoutique, ajouter, quantiteArticle, retirer);
        this.listeProduitBoutique.add(this);
    }

//Permet de retirer un article de la boutique
    public void RetirerDeLaBoutique(){
        this.boutique.getChildren().remove(this.boutique.getRowCount());
        this.listeProduitBoutique.remove(this);
    }
 
//Permet d'ajouter un article au panier  
    public void AjouterDansPanier(){
        if (compteur == 0){
            this.panier.getChildren().add(labelPanier);
            this.listeProduitPanier.add(this);
        }

        if (quantite > 0){
            compteur += 1;
            labelPanier.setText(nomArticle+": "+ compteur);
            quantite -= 1;
            quantiteArticle.setText(String.valueOf(quantite));
        }
    }

//Permet de retirer un article du panier    
    public void RetirerDuPanier(){
        if (compteur == 1){
            this.panier.getChildren().remove(labelPanier);
            this.listeProduitPanier.remove(this);
        }

        if (quantite < 5){
            compteur -= 1;
            labelPanier.setText(nomArticle+": "+ compteur);
            quantite += 1;
            quantiteArticle.setText(String.valueOf(quantite));
        }

    }


    public String getNomArticle() {
        return nomArticle;
    }
    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Button getAjouter() {
        return ajouter;
    }
    public void setAjouter(Button ajouter) {
        this.ajouter = ajouter;
    }

    public Button getRetirer() {
        return retirer;
    }
    public void setRetirer(Button retirer) {
        this.retirer = retirer;
    }
  
    public Label getLabelBoutique() {
        return labelBoutique;
    }
    public void setLabelBoutique(Label labelBoutique) {
        this.labelBoutique = labelBoutique;
    }

    public Label getLabelPanier() {
        return labelPanier;
    }
    public void setLabelPanier(Label labelPanier) {
        this.labelPanier = labelPanier;
    }

    public Label getQuantiteArticle() {
        return quantiteArticle;
    }
    public void setQuantiteArticle(Label quantiteArticle) {
        this.quantiteArticle = quantiteArticle;
    }

    public int getCompteur() {
        return compteur;
    }
    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }   
    
    public int getTmpQuantite() {
        return tmpQuantite;
    }
    public void setTmpQuantite(int tmpQuantite) {
        this.tmpQuantite = tmpQuantite;
    }

    public int getTmpCompteur() {
        return tmpCompteur;
    }
    public void setTmpCompteur(int tmpCompteur) {
        this.tmpCompteur = tmpCompteur;
    }
}
