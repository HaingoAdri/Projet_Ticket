package asa;

import java.util.Vector;

import connexion.Connexion;
import fonction.Fonction;

public class Type_Place extends Fonction{
    int id_Type;
    String nom_Type_Place;
    public int getId_Type() {
        return id_Type;
    }
    public void setId_Type(int id_Type) {
        this.id_Type = id_Type;
    }
    public String getNom_Type_Place() {
        return nom_Type_Place;
    }
    public void setNom_Type_Place(String nom_Type_Place) {
        this.nom_Type_Place = nom_Type_Place;
    }

    public Vector<Type_Place> getType_Place()throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/tiketing","tickets","haingo");
        String nom_De_Table = "type_Place";
        Type_Place conf = new Type_Place();
        Vector<Type_Place> conf_Vect = new Vector<Type_Place>();
        Vector<Object> objet = conf.getSelect2(con,nom_De_Table);
        for(int i=0; i<objet.size();i++){
            conf_Vect.add((Type_Place)objet.get(i));
            System.out.println(objet.size());
        }
        return conf_Vect;
    }
}
