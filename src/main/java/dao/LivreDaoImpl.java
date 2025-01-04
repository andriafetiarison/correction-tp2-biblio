package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Livre;


public class LivreDaoImpl implements GenericDao<Livre> {
    
    @Override
    public void inserer(Livre livre){
        String sql = "INSERT INTO livre (titre, auteur, annee, genre) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setString(3, livre.getAnnee());
            stmt.setString(4, livre.getGenre());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }
    
    @Override
    public void modifier(Livre livre){
        String sql = "UPDATE livre SET titre = ?, auteur = ?, annee = ?, genre = ? WHERE id = ?";
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setString(3, livre.getAnnee());
            stmt.setString(4, livre.getGenre());
            stmt.setInt(5, livre.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }
    
    @Override
    public void supprimer(int id){
        String sql = "DELETE FROM livre WHERE id = ?";
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }
    
    @Override
    public List<Livre> afficher() {
        String sql = "SELECT * FROM livre";
        List<Livre> livres = new ArrayList<>();

        try (Connection conn = ConnexionBDD.getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                String annee = rs.getString("annee");
                String genre = rs.getString("genre");

                livres.add(new Livre(id, titre, auteur, annee, genre));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        return livres;
    }
    
    public List<Livre> rechercherAuteur(String auteurs) {
        String sql = "SELECT * FROM livre WHERE auteur like ? group by id asc";
        List<Livre> livres = new ArrayList<>();
        try (Connection conn = ConnexionBDD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + auteurs + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                String annee = rs.getString("annee");
                String genre = rs.getString("genre");

                livres.add(new Livre(id, titre, auteur, annee, genre));
            }
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
        
        return livres;
    }
    
    public List<Livre> rechercherGenre(String genres) {
        String sql = "SELECT * FROM livre WHERE genre like ? group by id asc";
        List<Livre> livres = new ArrayList<>();
        try (Connection conn = ConnexionBDD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + genres + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                String annee = rs.getString("annee");
                String genre = rs.getString("genre");

                livres.add(new Livre(id, titre, auteur, annee, genre));
            }
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
        
        return livres;
    }
    
    public List<Livre> rechercherAnnee(String annees) {
        String sql = "SELECT * FROM livre WHERE annee like ? group by id asc";
        List<Livre> livres = new ArrayList<>();
        try (Connection conn = ConnexionBDD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + annees + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                String annee = rs.getString("annee");
                String genre = rs.getString("genre");

                livres.add(new Livre(id, titre, auteur, annee, genre));
            }
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
        
        return livres;
    }
}
