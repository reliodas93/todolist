package repository;

import database.Database;
import java.sql.*;
import java.util.ArrayList;
import model.Utilisateur;
public class UtilisateurRepository {
    private Connection connection;

    public UtilisateurRepository() {
        this.connection = Database.getConnexion();
    }

    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateurs (nom, prenom, email, mdp, role) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();

            System.out.println("Utilisateur ajouté avec succès !");
            return true ;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        return false ;
        }
    }

    public Utilisateur getUtilisateurParEmail(String email) throws SQLException {

        Utilisateur utilisateur = null;
        int idSQL;
        String nomSQL="";
        String prenomSQL="";
        String emailSQL="";
        String mdpSQL="";

        try {
                String sql= "SELECT * FROM utilisateur WHERE email = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email); // Remplace le ? par l'email fourni
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                utilisateur = new Utilisateur(
                     idSQL= rs.getInt("id"),
                       nomSQL= rs.getString("nom"),
                       prenomSQL= rs.getString("prenom"),
                       emailSQL= rs.getString("email"),
                       mdpSQL= rs.getString("mot_de_passe"))
                ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utilisateur;

        }


        public ArrayList<Utilisateur> getTousLesUtilisateurs() {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Utilisateur utilisateur = new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe")
                );
                utilisateurs.add(utilisateur); // Ajout à la liste
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }

        return utilisateurs; // Retourne la liste des utilisateurs
    }

    public void supprimerUtilisateurParEmail(String email) {
        String sql = " DELETE FROM utilisateurs WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email); // Remplace le ? par l'email fourni
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                Utilisateur Utilisateur = new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void mettreAjourUtilisateur(Utilisateur utilisateur) {

        String sql = "UPDATE utilisateurs SET nom = ?, prenom = ?, mdp = ?, role = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur modifier avec succes avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modication de l'utilisateur : " + e.getMessage());
        }
    }
        }

