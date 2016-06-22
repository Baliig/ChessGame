package application;

public class Echiquier implements MethodesEchiquier {

  private Case[][] location;

  public Echiquier() {
    location = new Case[8][8];
    for (int ctr = 0; ctr <= 7; ctr++)
      for (int ctr1 = 0; ctr1 <= 7; ctr1++)
        location[ctr][ctr1] = new Case();

  }

  public boolean captureParUnPionPossible(Deplacement deplacement) {
    // Je vérifie si la pice est un pion
    if (location[deplacement.getDepart().getColonne()][deplacement.getDepart()
        .getLigne()].getPiece() instanceof Pion) {
      // initialisation des variables dont j'aurai besoin dans mes conditions, ˆ
      // savoir la couleur de la pice de dŽpart et la case d'arrivé.
      Case Arrive = location[(int) deplacement.getArrivee()
          .getColonne()][(int) deplacement.getArrivee().getLigne()];
      String couleurDepart = location[(int) deplacement.getDepart()
          .getColonne()][(int) deplacement.getDepart().getLigne()].getPiece()
              .getCouleur();

      // je vérifie d'abord si la pice d'arrivé existe et si elle est de la
      // couleur contraire de celle de dŽpart.
      if (Arrive.estOccupe(couleurDepart.equals("blanc") ? "noir" : "blanc"))
        /*
         * Je vérifie si le déplacement est valide, Le déplacement est valide si
         * le produits du déplacement x et y donne 1 si la couleur de départ est
         * noir ou -1 si la pice de dŽpart est blanche.
         */
        return (deplacement.getDeplacementY() * Math
            .abs(deplacement.getDeplacementX()) == (couleurDepart.equals("noir")
                ? 1 : -1));
    }
    return false;

  }

  /**
   * Methode chemin possible, verifie si la piece peut faire le deplacement.
   * Pour ce faire il verifie si le chemin est libre entre le depart et
   * l'arrive.
   * 
   * @param Deplacement
   *          d'une piece
   * @return vrai ou faux si la piece peut faire le deplacement ou non
   */
  public boolean cheminPossible(Deplacement deplacement) {
    Piece pieceDepart = location[(int) deplacement.getDepart()
        .getColonne()][(int) deplacement.getDepart().getLigne()].getPiece();

    /*
     * deux premire condition fondamentale, que la case d'arrivé sois libre ou
     * qu'elle possde une pice de couleur contraire ˆ celle de la pice de
     * départ
     */
    if (!location[(int) deplacement.getArrivee().getColonne()][(int) deplacement
        .getArrivee().getLigne()].estOccupe(
            pieceDepart.getCouleur().equals("blanc") ? "blanc" : "noir")
        | deplacement.isNul()) {
      if (!(pieceDepart instanceof Cavalier)) {
        if (!(pieceDepart instanceof Pion)) {
          // Je vérifie que le déplacement est supérieur d'un.
          if (!(Math.abs(deplacement.getDeplacementX())
              - Math.abs(deplacement.getDeplacementY()) <= 1
              && Math.abs(deplacement.getDeplacementX())
                  + Math.abs(deplacement.getDeplacementY()) <= 1)) {

            /*
             * JumpX et jumpY seront sois 0, 1 ou -1, ils indiquent
             * l'incrémentation que je devrai utiliser pour les valeurs X et Y
             * pour vŽrifier toute les cases entre le départ et l'arrivé
             */
            int jumpX = deplacement.getDeplacementX() == 0 ? 0
                : (int) (deplacement.getArrivee().getColonne()
                    - deplacement.getDepart().getColonne())
                    / Math.abs((int) (deplacement.getArrivee().getColonne()
                        - deplacement.getDepart().getColonne()));

            int jumpY = deplacement.getDeplacementY() == 0 ? 0
                : (int) (deplacement.getArrivee().getLigne()
                    - deplacement.getDepart().getLigne())
                    / Math.abs((int) (deplacement.getArrivee().getLigne()
                        - deplacement.getDepart().getLigne()));

            // Je vérifie succcessivement toutes les cases entre l'arrivée et
            // le départ
            for (int ctrX = (int) deplacement.getDepart().getColonne()
                + jumpX, ctrY = (int) deplacement.getDepart().getLigne()
                    + jumpY; ctrX != (int) deplacement.getArrivee().getColonne()
                        | ctrY != (int) deplacement.getArrivee()
                            .getLigne(); ctrX += jumpX, ctrY += jumpY) {
              if (location[ctrX][ctrY].estOccupe()) {
                return false;
              }
            }
            return true;
          } else
            /*
             * Si le déplacement est égal il est automatiquement valide car il a
             * passé les précedents test. Puisque le déplacement est de 1, je
             * n'ai pas besoin de vérifier les cases entre le départ et l'arrivé
             */
            return true;
        } else
          // Si c'est un pion, je vérifie si la case est libre de toute pice.
          return !location[(int) deplacement.getArrivee()
              .getColonne()][(int) deplacement.getArrivee().getLigne()]
                  .estOccupe();

      } else
        // je renvoie true car un cavalier peut sauter par dessus les autres
        // pices.
        return true;
    } else
      // Le déplacement est automatiquement invalide si la case d'arrivé
      // contient une pice de mme couleur que la pice de départ.
      return false;

  }

  public Case getCase(int colonne, int ligne) {
    return location[colonne][ligne];
  }

  /**
   * Methode servant a placer toute les piece sur l'echiquier. Met donc toute
   * lesp iece sur les objets cases du tableau location
   */
  public void debuter() {
    int ligne = 7;
    /*
     * Je fais les instructions deux fois, au premier passage, ligne est égal 7
     * et la couleur noir, et au deuxime passage, la couleur est blanche et la
     * ligne est égal ˆ 0.
     */
    for (String couleur = "noir"; !couleur
        .equals("blanc"); couleur = "blanc", ligne = 0) {
      // J'initialise tout mes pices de la premires rangée (tour, cavalier
      // etc...)
      location[0][ligne].setPiece(new Tour(couleur));
      location[1][ligne].setPiece(new Cavalier(couleur));
      location[2][ligne].setPiece(new Fou(couleur));
      location[3][ligne].setPiece(new Reine(couleur));
      location[4][ligne].setPiece(new Roi(couleur));
      location[5][ligne].setPiece(new Fou(couleur));
      location[6][ligne].setPiece(new Cavalier(couleur));
      location[7][ligne].setPiece(new Tour(couleur));
      // Je change de ligne, dépendament de la couleur que je suis en train de
      // traîter.
      ligne += couleur.equals("noir") ? -1 : 1;
      // J'initialise tout mes pions.
      for (int ctr = 0; ctr <= 7; ctr++)
        location[ctr][ligne].setPiece(new Pion(couleur));
    }
  }

}
