package asa;

import java.sql.Date;

import fonction.Fonction;

public class Evenements extends Fonction{
    int id_E;
    String nom_E;
    String nom_Createur;
    Date date_Evenements;
    public int getId_E() {
        return id_E;
    }
    public void setId_E(int id_E) {
        this.id_E = id_E;
    }
    public String getNom_E() {
        return nom_E;
    }
    public void setNom_E(String nom_E) {
        this.nom_E = nom_E;
    }
    public String getNom_Createur() {
        return nom_Createur;
    }
    public void setNom_Createur(String nom_Createur) {
        this.nom_Createur = nom_Createur;
    }
    public Date getDate_Evenements() {
        return date_Evenements;
    }
    public void setDate_Evenements(Date date_Evenements) {
        this.date_Evenements = date_Evenements;
    }
    
}