package Piece;

import application.Deplacement;
import application.Piece;

public class Pion extends Piece {

  public Pion(String Couleur) {
    super("Pion", Couleur);
  }

  public boolean estValide(Deplacement deplacement) {
    int testLigneNoir = 1;
    int testLigneBlanc = -1;
    // on test si le coordooné d'arriver - celle de départ est égal à 0
    if (deplacement.getDeplacementX() == 0)
      // si le pion est noir
      if (this.getCouleur().equals("noir")) {
        if (deplacement.getDepart().getLigne() == 1) {
          testLigneNoir = 2;
        } else {
          testLigneNoir = 1;
        }
        return deplacement.getDeplacementY() <= testLigneNoir && deplacement.getDeplacementY() > 0;
      } else {
        if (deplacement.getDepart().getLigne() == 6) {
          testLigneBlanc = -2;
        } else {
          testLigneBlanc = -1;
        }
        return deplacement.getDeplacementY() >= testLigneBlanc && deplacement.getDeplacementY() < 0;
      }
    return false;
  }
}
