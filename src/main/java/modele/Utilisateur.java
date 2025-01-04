package modele;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilisateur {
    private int id;
    private String nom;
    private String mail;
    private String telephone;
    
    public Utilisateur() {
        super();
    }
    
    public Utilisateur(String nom) {
        this.nom = nom;
    }
    
    public Utilisateur(int id, String nom, String mail, String telephone){
        this.id = id;
        this.nom = nom;
        this.mail= mail;
        this.telephone = telephone;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getMail(){
        return this.mail;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getTelephone(){
        return this.telephone;
    }
    
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    
    public boolean verifierMail(String mail) {
        // Définir une regex pour valider une adresse email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        if (mail == null || mail.isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(mail);

        return matcher.matches();
    }
    
    public boolean verifierTelephone(String telephone) {
        String phoneRegex = "^[0-9]{10}$";

        if (telephone == null || telephone.isEmpty()) {
            return false;
        }

        return telephone.matches(phoneRegex);
    }
}
