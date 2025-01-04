package modele;

public class Pret {
    private int id;
    private int id_user;
    private int id_livre;
    private String date_pret;
    private String date_retour;
    private String nom;
    private String titre;
    
    public Pret(){
        super();
    }
    
    public Pret(int id, int id_user, int id_livre, String date_pret, String date_retour, String nom, String titre){
        this.id = id;
        this.id_user = id_user;
        this.id_livre = id_livre;
        this.date_pret= date_pret;
        this.date_retour = date_retour;
        this.nom = nom;
        this.titre = titre;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getIdUser(){
        return this.id_user;
    }
    
    public void setIdUser(int id_user){
        this.id_user = id_user;
    }
    
    public int getIdLivre(){
        return this.id_livre;
    }
    
    public void setIdLivre(int id_livre){
        this.id_livre = id_livre;
    }
    
    public String getDatePret(){
        return this.date_pret;
    }
    
    public void setDatePret(String date_pret){
        this.date_pret = date_pret;
    }
    
    public String getDateRetour(){
        return this.date_retour;
    }
    
    public void setDateRetour(String date_retour){
        this.date_retour = date_retour;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getTitre(){
        return this.titre;
    }
}
