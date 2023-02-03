package fonction;

import java.util.Vector;

import connexion.*;

import java.lang.reflect.*;
import java.sql.*;



public class Fonction {
	String prefix;
	int longueurPk=7;
	String nomFonction;

	public String getPrefix(){return this.prefix;}
	public String getNomFonction(){return this.nomFonction;}
	public int getLongueurPk(){return this.longueurPk;}
	
	public void setPrefix(String p)throws Exception{
		if (p==null) {
			throw new Exception("Aucun string existant");
		}else{
			this.prefix = p;
		}
	}
	public void setNomFonction(String nom)throws Exception{
		if (nom==null) {
			throw new Exception("Aucun string existant");
		}else{
			this.nomFonction=nom;
		}
		
	}
	public void setLongueurPk(int age)throws Exception{
		if (age!=0) {
			this.longueurPk=age;
		}else{
			throw new Exception("Aucun int existant");
		}
		
	}

	public static String getMajuscule(String str){
		String tmp;
		tmp=str.substring(0,1);//premier lettre du string
		str=str.substring(1);//de atao string iray ny ambiny
		tmp=tmp.toUpperCase();//avadika majuscule le premiere lettre
		tmp=tmp.concat(str);//manambatra
		return tmp;
	}
	
	public  Vector<Object> getSelect(Connexion con, String nom, String qq,String value)throws Exception{
		System.out.println("Selection:");

		Vector<Object> selection = new Vector<Object>();
		Connection conne = con.getConnexion();
		try{
			Field[] field = this.getClass().getDeclaredFields();	
			String query = "select * from "+nom+" where "+qq+" = '"+value+"'";
			Statement stmt = conne.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
					Object temp = this.getClass().getConstructor().newInstance();
					for (int i=0; i<field.length; i++) {
						if(field[i].getType() == String.class){
							Method m = temp.getClass().getMethod("set"+getMajuscule(field[i].getName()),String.class);
							m.invoke(temp,rs.getString(i+1));
						} 
						else if(field[i].getType() == Integer.TYPE){
							Method ms = temp.getClass().getMethod("set"+getMajuscule(field[i].getName()),int.class);
							ms.invoke(temp,rs.getInt(i+1));
						}
					}	
				selection.add(temp);
			}
			System.out.println(query);
			
		}
		catch(Exception e){
			e.printStackTrace();
			conne.close();
		}
		return selection;
	}
	public  Vector<Object> getSelect2(Connexion con, String nom)throws Exception{
		System.out.println("Selection:");
		Vector<Object> selection = new Vector<Object>();
		String query = "select * from "+nom;
		Connection conne = con.getConnexion();
		try{
			Field[] field = this.getClass().getDeclaredFields();
			Statement stmt = conne.createStatement();
			
			ResultSet rs = stmt.executeQuery( query);
			while(rs.next()){
					Object temp = this.getClass().getConstructor().newInstance();
					for (int i=0; i<field.length; i++) {
						if(field[i].getType() == String.class){
							Method m = temp.getClass().getMethod("set"+getMajuscule(field[i].getName()),String.class);
							m.invoke(temp,rs.getString(i+1));
						} 
						else if(field[i].getType() == Integer.TYPE){
							Method ms = temp.getClass().getMethod("set"+getMajuscule(field[i].getName()),int.class);
							ms.invoke(temp,rs.getInt(i+1));
						}
						else if(field[i].getType() == java.sql.Date.class){
							Method ms = temp.getClass().getMethod("set"+getMajuscule(field[i].getName()),Date.class);
							ms.invoke(temp,rs.getDate(i+1));
						}
						else if(field[i].getType() == Double.class){
							Method ms = temp.getClass().getMethod("set"+getMajuscule(field[i].getName()),Double.class);
							ms.invoke(temp,rs.getDouble(i+1));
						}
					}	
				selection.add(temp);
				System.out.println(query);	
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			conne.close();
		}
		return selection;
	}
	public String[] getAttributs(Object obj){
		Field[] field = obj.getClass().getDeclaredFields();
		String[] ff  = new String[field.length];
		for(int i=0; i<field.length; i++){
			ff[i] = field[i].getName();
		}
		return ff;
	}
	public void getInsertion(Connexion con, String nomDeTable)throws Exception{
		System.out.println("Insertion:");
		//Vector<Object> insertion = new Vector<Object>();
		Connection conne = con.getConnexion();
		try{
			
			Statement stmt = conne.createStatement();
				String[] attributs = getAttributs(this);
				String query = "insert into  "+nomDeTable+" values(";
				for(int j = 0; j<attributs.length; j++){
					Object obj = this.getClass().getMethod("get"+getMajuscule(attributs[j])).invoke(this);
					if(obj.getClass()== Date.class){
						query +="To_DATE('"+obj+"','YYYY-MM-DD')";
					}else if(obj.getClass()== String.class){
						query +="'"+obj+"'";
					}
					else{
						query += obj;
					}
					if(j<(attributs.length)-1){
						query+= ",";
					}
					
				}
				query +=")";
				System.out.println(query);
			stmt.executeUpdate(query);
			
		}catch(Exception e){
			throw e;
			// e.printStackTrace();
			// conne.close();
		}finally{
			try {
				
				conne.close();
			} catch (Exception e) {
				//TODO: handle exception
			}
		}
	}
	public void getDelete(Connexion con, String nomDeTable, String value,String nomDeColonne,String nomF)throws Exception{
		System.out.println("Delete");
		//Vector<Object> delete = new Vector<Object>();
		Connection conne = con.getConnexion();
		try{
			this.historiser(con,nomDeTable,nomDeColonne,value,nomF);
			Statement stmt = conne.createStatement();
			String[] attributs = getAttributs(this);
				String query = "delete from "+nomDeTable+" where "+nomDeColonne+" = '"+value+"'";
			
			System.out.println(query);
			stmt.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
			conne.close();
		}
	}
	public void getUpdate(Connexion con, String nomDeTable, String nomDeColonne, String value, String value1,String nomF)throws Exception{
		System.out.println("Update");
		Connection conne = con.getConnexion();
		try{
			this.historiser(con,nomDeTable,nomDeColonne,value,nomF);
			Statement stmt = conne.createStatement();
			String query = "update "+nomDeTable+" set "+nomDeColonne+" = '"+value+"' where "+nomDeColonne+" = '"+value1 +"'";
			System.out.println(query);
			stmt.executeUpdate(query);
			
		}
		catch(Exception e){
			e.printStackTrace();
			conne.close();
		}
	}
	public int getCurrentSequence(Connexion con)throws Exception{
		System.out.println("Primary Key");
		Connection conne = con.getConnexion();
		try{
			Statement stmt = conne.createStatement();
			String query = "select "+getNomFonction()+"()";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			return rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
			conne.close();
		}
		return 0;
	}
	public String addZero(int id, int charc){
		String mm = String.valueOf(id);
		int qq = mm.length();
		String vide = "";
		for(int i=1;i<=(charc-qq); i++){
			vide+="0";
		}
		vide+=mm;
		return vide;
	}
	public String mitambatra(Connexion con)throws Exception{
			int sequence = getCurrentSequence(con);
			String pk = getPrefix();
			int cc = getLongueurPk()-pk.length();
			String zero = addZero(sequence, cc);
			String total = pk+zero;
			return total;
		
	}
	public void historiser(Connexion con, String nomT, String nomC, String value, String nomFonction)throws Exception{
		Connection conne = con.getConnexion();
		Vector<Object> temp = new Vector<Object>();
		try{
			 temp = this.getSelect(con,nomT,nomC,value);
			
		}catch(Exception e){
			e.printStackTrace();
			conne.close();
		}
		
	}
	public String getValue(String table, String nomF, Date aa, String id, String valeur)throws Exception{
		String farany = "L'id est: "+id+"; le nom de la table est: "+table+"; le nom de l'action: "+nomF+"; la date est: "+ aa +"; la valeur est: "+valeur;

		System.out.println(farany);
		return farany;
	}
}