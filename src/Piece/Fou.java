package Piece;

import application.Deplacement;
import application.Piece;

public class Fou extends Piece {

  public Fou(String Couleur) {
    super("Fou", Couleur);
  }

  public boolean estValide(Deplacement deplacement) {
    // Teste si (la coordonnée d'arrive - la coordonnée de départ des x) - la même
    // chose pour les y si le résultat est égal à 0 est n'est pas null.
    return Math.abs(deplacement.getDeplacementX())
        - Math.abs(deplacement.getDeplacementY()) == 0 && !deplacement.isNul();

  }
}
