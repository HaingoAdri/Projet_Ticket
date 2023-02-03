package asa;

import java.util.Vector;

import connexion.Connexion;
import fonction.Fonction;

public class Zones extends Fonction{
    int id_Z;
    String nom_Zone;
    public int getId_Z() {
        return id_Z;
    }
    public void setId_Z(int id_Z) {
        this.id_Z = id_Z;
    }
    public String getNom_Zone() {
        return nom_Zone;
    }
    public void setNom_Zone(String nom_Zone) {
        this.nom_Zone = nom_Zone;
    }

    public Vector<Zones> getZones()throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/tiketing","tickets","haingo");
        String nom_De_Table = "zones";
        Zones conf = new Zones();
        Vector<Zones> conf_Vect = new Vector<Zones>();
        Vector<Object> objet = conf.getSelect2(con,nom_De_Table);
        for(int i=0; i<objet.size();i++){
            conf_Vect.add((Zones)objet.get(i));
            System.out.println(objet.size());
        }
        return conf_Vect;
    }

}
