package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Utilisateur;

public class UtilisateurDaoImpl implements GenericDao<Utilisateur> {
    @Override
    public void inserer(Utilisateur utilisateur){
        String sql = "INSERT INTO utilisateur (nom, mail, telephone) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getMail());
            stmt.setString(3, utilisateur.getTelephone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }
    
    @Override
    public void modifier(Utilisateur utilisateur){
        String sql = "UPDATE utilisateur SET nom = ?, mail = ?, telephone = ? WHERE id = ?";
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getMail());
            stmt.setString(3, utilisateur.getTelephone());
            stmt.setInt(4, utilisateur.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }
    
    @Override
    public void supprimer(int id){
        String sql = "DELETE FROM utilisateur WHERE id = ?";
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }
    
    @Override
    public List<Utilisateur> afficher() {
        String sql = "SELECT * FROM utilisateur";
        List<Utilisateur> utilisateurs = new ArrayList<>();

        try (Connection conn = ConnexionBDD.getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String mail = rs.getString("mail");
                String telephone = rs.getString("telephone");

                utilisateurs.add(new Utilisateur(id, nom, mail, telephone));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        return utilisateurs;
    }
}
