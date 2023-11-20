package ticket_de_caisse;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

public class Controler {

    @FXML
    private VBox panier;

    @FXML
    private GridPane boutique;

    @FXML
    private Label titrePanier;

    @FXML
    private TextField nomArticleTextField;

    @FXML
    private TextField quantiteArticleTextField;

    ArrayList<Produit> listeProduitBoutique = new ArrayList<Produit>();
    ArrayList<Produit> listeProduitPanier = new ArrayList<Produit>();
 
    public void initialize(){
        Produit salade = new Produit("Salade", 5, listeProduitBoutique, listeProduitPanier, boutique, panier);
        Produit tomate = new Produit("Tomate", 5, listeProduitBoutique, listeProduitPanier, boutique, panier);
        Produit oignon = new Produit("Oignon", 5, listeProduitBoutique, listeProduitPanier, boutique, panier);

        salade.AjouterDansBoutique();
        tomate.AjouterDansBoutique();
        oignon.AjouterDansBoutique();
    }

    @FXML
    public void resetButtonAction(){
        panier.getChildren().clear();
        panier.getChildren().add(titrePanier);
        listeProduitPanier.clear();
        for (int i = 0; i < listeProduitBoutique.size(); i++) {
            listeProduitBoutique.get(i).setQuantite(listeProduitBoutique.get(i).getTmpQuantite());
            listeProduitBoutique.get(i).setCompteur(listeProduitBoutique.get(i).getTmpCompteur());
            listeProduitBoutique.get(i).getQuantiteArticle().setText(String.valueOf(listeProduitBoutique.get(i).getTmpQuantite()));
        }
        nomArticleTextField.clear();
        quantiteArticleTextField.clear();
    }

    @FXML
    public void ajouterButtonAction(){
        Produit produit = new Produit(nomArticleTextField.getText(), Integer.parseInt(quantiteArticleTextField.getText()), listeProduitBoutique, listeProduitPanier, boutique, panier);
        produit.AjouterDansBoutique();   
    }
}
