package Piece;

import application.Deplacement;
import application.Piece;

public class Cavalier extends Piece {
        
        public Cavalier(String Couleur) {
                super("Cavalier", Couleur);
        }

  public boolean estValide(Deplacement deplacement) {
    //Teste si la coordonnée d'arrivé - la coordonné d'arrivé en divisant les deux soit égal à 2 ou 1/2.
    // Si c'est le cas on peut ce déplacer sinon on peut pas.
    return (Math.abs(deplacement.getDeplacementX() / deplacement.getDeplacementY())) == 2
        | (Math.abs(deplacement.getDeplacementX()  / deplacement.getDeplacementY())) == .5;
  }
}
