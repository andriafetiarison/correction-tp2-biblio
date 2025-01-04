package controller;

import dao.GenericDao;
import java.util.List;
import modele.Utilisateur;

public class UtilisateurController {
    private final GenericDao<Utilisateur> utilisateurDAO;
    
    public UtilisateurController(GenericDao<Utilisateur> utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurDAO.inserer(utilisateur);
    }
    
    public void modifierUtilisateur(Utilisateur utilisateur){
        utilisateurDAO.modifier(utilisateur);
    }
    
    public void supprimerUtilisateur(int id){
        utilisateurDAO.supprimer(id);
    }
    
    public List<Utilisateur> afficherUtilisateur(){
        return utilisateurDAO.afficher();
    } 
}
