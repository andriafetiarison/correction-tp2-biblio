package controller;

import dao.GenericDao;
import dao.PretDaoImpl;
import java.util.List;
import modele.Pret;

public class PretController {
    private final GenericDao<Pret> pretDAO;

    public PretController(GenericDao<Pret> pretDAO) {
        this.pretDAO = pretDAO;
    }

    public void ajouterPret(Pret pret) {
        pretDAO.inserer(pret);
    }
    
    public void modifierPret(Pret pret){
        pretDAO.modifier(pret);
    }
    
    public void supprimerPret(int id){
        pretDAO.supprimer(id);
    }
    
    public List<Pret> afficherPret(){
        return pretDAO.afficher();
    }
    
    public void restituer(Pret pret){
        PretDaoImpl r = new PretDaoImpl();
        r.restituer(pret);
    }
}
