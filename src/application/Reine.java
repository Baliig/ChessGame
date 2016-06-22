package application;

/**
 * classe reine servant ˆ reprŽsenter la reine dans un jeu d'echec
 * 
 * @author Francois Allard
 */
public class Reine extends Piece{
        
        /** 
         * Constructeur de la classe reine
         * @param Prend en parametre la couleur de la reine
         * 
         */
        public Reine(String Couleur) {
                super("Reine", Couleur);
        }
                
        /**
         * Methode estValide, sert a verifier la validite du deplacement de la reine
         * @return true ou false si le deplacement du fou est valide
         * @param Deplacement de la piece
         */
        public boolean estValide(Deplacement deplacement) {
                /*Le dŽplacement d'une reine est un mouvement qui peut tre diagonale OU rectiligne.
                 * Je j'utilise donc les mŽthodes du fou et de la tour pour vŽrifier celle de la reine.
                 */
                
                return (Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) == 0 
                                | deplacement.getDeplacementX() * deplacement.getDeplacementY() == 0) && !deplacement.isNul();
        }
}
