package application;
/**
 * classe roi servant ˆ reprŽsenter le roi dans un jeu d'echec
 * 
 * @author Francois Allard
 */
public class Roi extends Piece{
        
        /** 
         * Constructeur de la classe roi
         * @param Prend en parametre la couleur du roi
         * 
         */
        public Roi(String Couleur) {
                super("Roi", Couleur);
        }


        /**
         * Methode estValide, sert a verifier la validite du deplacement du roi
         * @return true ou false si le deplacement du roi est valide
         * @param Deplacement de la piece
         */
        public boolean estValide(Deplacement deplacement) {
                /*La somme des dŽplacement x et y ne devrait jamais tre supŽrieur ˆ deux, pour gŽrer le cas ou le roi
                 * ferais deux pas dans la mme direction j'ai ajouter la condition disant que la diffŽrence ne devrais jamais 
                 * excŽder 1. (un pas en diagonale = 0, un pas dans un autre axe = 1). Je vŽrifie Žgalement si le roi est demeurer sur place.
                 */
                return Math.abs(deplacement.getDeplacementX()) * Math.abs(deplacement.getDeplacementY()) <= 1
                && Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) <= 1
                && Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) >= -1
                        && !deplacement.isNul();
        }
}
