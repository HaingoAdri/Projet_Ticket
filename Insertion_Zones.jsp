<!-- import de toutes les classe -->
<%@page import="connexion.*"%>
<%@page import="fonction.*"%>
<%@page import="asa.*"%>
<%@page import="main.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*,java.io.PrintWriter"%>


<%
    Connexion con = new Connexion("jdbc:postgresql://localhost:5432/tiketing","tickets","haingo");
    String a = request.getParameter("nom_createur");
    String b = request.getParameter("nom_evenements");
    String c = request.getParameter("date_evenements");
    Date date1=Date.valueOf(c);


    Type_Billets asa1 = new Type_Billets();
    Vector<Type_Billets> ff1 = asa1.getType_Billets();

    Zones asa2 = new Zones();
    Vector<Zones> ff2 = asa2.getZones();

    Type_Place asa3 = new Type_Place();
    Vector<Type_Place> ff3 = asa3.getType_Place();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="apple-touch-icon" href="assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
    <link rel="icon" href="assets/img/favicons/favicon.ico">
    <title>Insertion de Stock Simple</title>
</head>
<style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>

<body>
    <div class="container px-4 py-5" id="featured-3">
        <h1 style="text-align: center;"> Insertion De Zone:</h1>
          
            <form class="needs-validation" action="Insertion_Place.jsp">
                <%for(int j=0; j<ff2.size(); j++){%>
                    <label for="<%=ff2.get(j).getId_Z()%>" class="form-label"><%=ff2.get(j).getNom_Zone()%>:</label>
                    <div class="row g-4  row-cols-1 row-cols-lg-3">
                        <div class="feature col">
                            <label for="username" class="form-label">Quantite de Place</label>
                            <div class="input-group has-validation">
                            <input type="number" name="qA" class="form-control"  placeholder="nom_createur" required>
                            </div>
                        </div>
                        <div class="feature col">
                            <label for="username" class="form-label">Billets Type</label>
                            <select name="bA" class="form-control">
                                <%for(int i=0; i<ff1.size(); i++){%>>
                                    <option value="<%=ff1.get(i).getId_Type_Billets()%>"><%=ff1.get(i).getNom_Billets()%></option>
                                 <%}%>   
                            </select>
                        </div>
                        <div class="feature col">
                            <label for="username" class="form-label">Type Place</label>
                            <select name="tA" class="form-control">
                                <%for(int i=0; i<ff3.size(); i++){%>>
                                    <option value="<%=ff3.get(i).getId_Type()%>"><%=ff3.get(i).getNom_Type_Place()%></option>
                                <%}%> 
                            </select>
                        </div>
                        <div class="feature col">
                            <button class="w-100 btn btn-primary btn-lg" type="submit">Inserer</button>
                        </div>
                    </div>
                <%}%>
                    <br>
                    
                </div>
            </form>
            
    </div>
</body>
</html>