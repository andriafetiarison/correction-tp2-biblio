package modele;

public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private String annee;
    private String genre;
    
    public Livre() {
        super();
    }
    
    public Livre(String titre){
        this.titre = titre;
    }
    
    public Livre(int id, String titre, String auteur, String annee, String genre){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.genre = genre;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getTitre(){
        return this.titre;
    }
    
    public void setTitre(String titre){
        this.titre = titre;
    }
    
    public String getAuteur(){
        return this.auteur;
    }
    
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    
    public String getAnnee(){
        return this.annee;
    }
    
    public void setAnnee(String annee){
        this.annee = annee;
    }
    
    public String getGenre(){
        return this.genre;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
}
