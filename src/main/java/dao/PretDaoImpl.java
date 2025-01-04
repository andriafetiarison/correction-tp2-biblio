package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Pret;

public class PretDaoImpl implements GenericDao<Pret> {

    @Override
    public void inserer(Pret pret) {
        String sql = "INSERT INTO pret (id_livre, id_user, date_pret, date_retour) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionBDD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pret.getIdLivre());
            stmt.setInt(2, pret.getIdUser());
            stmt.setString(3, pret.getDatePret());
            stmt.setString(4, pret.getDateRetour());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }

    @Override
    public void modifier(Pret pret) {
        String sql = "UPDATE pret SET id_livre = ?, id_user = ?, date_pret = ? WHERE id = ?";
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pret.getIdLivre());
            stmt.setInt(2, pret.getIdUser());
            stmt.setString(3, pret.getDatePret());
            stmt.setInt(4, pret.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String sql = "DELETE FROM pret WHERE id = ?";
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }

    @Override
    public List<Pret> afficher() {
        String sql = "SELECT pret.id as id_pret, id_livre, id_user, date_pret, date_retour, nom, titre FROM livre, utilisateur, pret "
                + "WHERE utilisateur.id = pret.id_user AND livre.id = pret.id_livre ORDER BY pret.id ASC";
        List<Pret> prets = new ArrayList<>();

        try (Connection conn = ConnexionBDD.getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id_pret");
                int id_livre = rs.getInt("id_livre");
                int id_user = rs.getInt("id_user");
                String date_pret = rs.getString("date_pret");
                String date_retour = rs.getString("date_retour");
                String nom = rs.getString("nom");
                String titre = rs.getString("titre");

                prets.add(new Pret(id, id_livre, id_user, date_pret, date_retour, nom, titre));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        return prets;
    } 
    
    public void restituer(Pret pret) {
        String sql = "UPDATE pret SET date_retour = ? WHERE id = ?";
        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pret.getDateRetour());
            stmt.setInt(2, pret.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur :" + e.getMessage());
        }
    }
}
