package model;

public class Utilisateur {

    private int idUtilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String role;


    public Utilisateur(int id, String nom, String prenom, String email, String motDePasse) {
        this.idUtilisateur = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }


    public Utilisateur(String nom, String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }


    public Utilisateur(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }


    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setId(int idutilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return motDePasse;
    }

    public void setMdp(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + idUtilisateur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
