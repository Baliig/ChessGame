package Piece;

import application.Deplacement;
import application.Piece;

public class Roi extends Piece {

  public Roi(String Couleur) {
    super("Roi", Couleur);
  }

  public boolean estValide(Deplacement deplacement) {
    // Teste la (coordoonée d'arrivé - la coordonnée de départ des x) * la même
    // chose avec les y si le résultat est égal à 1 ou moin 
    return Math.abs(deplacement.getDeplacementX())
        * Math.abs(deplacement.getDeplacementY()) <= 1
        && Math.abs(deplacement.getDeplacementX())
            - Math.abs(deplacement.getDeplacementY()) <= 1
        && Math.abs(deplacement.getDeplacementX())
            - Math.abs(deplacement.getDeplacementY()) >= -1
        && !deplacement.isNul();
  }
}
