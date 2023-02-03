package asa;

import java.util.Vector;

import connexion.Connexion;
import fonction.Fonction;

public class Confirmation extends Fonction{
    int id_Conf;
    String type_Conf;
    public int getId_Conf() {
        return id_Conf;
    }
    public void setId_Conf(int id_Conf) {
        this.id_Conf = id_Conf;
    }
    public String getType_Conf() {
        return type_Conf;
    }
    public void setType_Conf(String type_Conf) {
        this.type_Conf = type_Conf;
    }

    public Vector<Confirmation> getConfirmation()throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/tiketing","tickets","haingo");
        String nom_De_Table = "confirmation";
        Confirmation conf = new Confirmation();
        Vector<Confirmation> conf_Vect = new Vector<Confirmation>();
        Vector<Object> objet = conf.getSelect2(con,nom_De_Table);
        for(int i=0; i<objet.size();i++){
            conf_Vect.add((Confirmation)objet.get(i));
            System.out.println(objet.size());
        }
        return conf_Vect;
    }

    
}
