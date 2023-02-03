package connexion;

import java.sql.*;

public class Connexion {
	//postgresql
	String url1;
	String user1;
	String mdp1;
	
	
	public String getUrl1(){return this.url1;}

	public String getUser1(){return this.user1;}

	public String getMdp1(){return this.mdp1;}

	
	public void setUrl1(String u){this.url1 = u;}

	public void setUser1(String g){this.user1=g;}

	public void setMdp1(String m){this.mdp1 = m;}


	public Connection getConnexion()throws SQLException, Exception{
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(this.getUrl1(),this.getUser1(),this.getMdp1());  
  			//System.out.println(con);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		return con;
	}

	public Connexion(String url1, String user1, String mdp1) throws Exception{
		this.setUrl1(url1);
		this.setUser1(user1);
		this.setMdp1(mdp1);
		this.getConnexion();
	}
}