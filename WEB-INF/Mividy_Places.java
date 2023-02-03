package asa;

import java.sql.Date;
import java.sql.Time;

public class Mividy_Places {
    int id_Mividy;
    String nom_olona;
    int id_Zone;
    int type_Billets;
    int quantite_Billets;
    int confirmation;
    Date data_Confirmation;
    Time duree_confirmation;
    public int getId_Mividy() {
        return id_Mividy;
    }
    public void setId_Mividy(int id_Mividy) {
        this.id_Mividy = id_Mividy;
    }
    public String getNom_olona() {
        return nom_olona;
    }
    public void setNom_olona(String nom_olona) {
        this.nom_olona = nom_olona;
    }
    public int getId_Zone() {
        return id_Zone;
    }
    public void setId_Zone(int id_Zone) {
        this.id_Zone = id_Zone;
    }
    public int getType_Billets() {
        return type_Billets;
    }
    public void setType_Billets(int type_Billets) {
        this.type_Billets = type_Billets;
    }
    public int getQuantite_Billets() {
        return quantite_Billets;
    }
    public void setQuantite_Billets(int quantite_Billets) {
        this.quantite_Billets = quantite_Billets;
    }
    public int getConfirmation() {
        return confirmation;
    }
    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }
    public Date getData_Confirmation() {
        return data_Confirmation;
    }
    public void setData_Confirmation(Date data_Confirmation) {
        this.data_Confirmation = data_Confirmation;
    }
    public Time getDuree_confirmation() {
        return duree_confirmation;
    }
    public void setDuree_confirmation(Time duree_confirmation) {
        this.duree_confirmation = duree_confirmation;
    }
}
