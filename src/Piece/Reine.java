package Piece;

import application.Deplacement;
import application.Piece;

public class Reine extends Piece {

  public Reine(String Couleur) {
    super("Reine", Couleur);
  }

  public boolean estValide(Deplacement deplacement) {
    // Teste la (coordoonée de d'arrivé - la coordonnée départ des x) - la même chose
    // avec les y si le résultat est égal à 0 ou la maltiplication est égal à 0 on
    // permet le déplacement
    return (Math.abs(deplacement.getDeplacementX())
        - Math.abs(deplacement.getDeplacementY()) == 0
        | deplacement.getDeplacementX() * deplacement.getDeplacementY() == 0)
        && !deplacement.isNul();
  }
}
