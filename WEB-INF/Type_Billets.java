package asa;

import java.util.Vector;

import connexion.Connexion;
import fonction.Fonction;

public class Type_Billets extends Fonction{
    int id_Type_Billets;
    String nom_Billets;
    public int getId_Type_Billets() {
        return id_Type_Billets;
    }
    public void setId_Type_Billets(int id_Type_Billets) {
        this.id_Type_Billets = id_Type_Billets;
    }
    public String getNom_Billets() {
        return nom_Billets;
    }
    public void setNom_Billets(String nom_Billets) {
        this.nom_Billets = nom_Billets;
    }
    public Vector<Type_Billets> getType_Billets()throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/tiketing","tickets","haingo");
        String nom_De_Table = "type_Billets";
        Type_Billets conf = new Type_Billets();
        Vector<Type_Billets> conf_Vect = new Vector<Type_Billets>();
        Vector<Object> objet = conf.getSelect2(con,nom_De_Table);
        for(int i=0; i<objet.size();i++){
            conf_Vect.add((Type_Billets)objet.get(i));
            System.out.println(objet.size());
        }
        return conf_Vect;
    }

}
