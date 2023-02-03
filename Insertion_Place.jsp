<!-- import de toutes les classe -->
<%@page import="connexion.*"%>
<%@page import="fonction.*"%>
<%@page import="asa.*"%>
<%@page import="java.util.*"%>
<%@page import="main.*"%>
<%@page import="java.text.*,java.io.PrintWriter"%>


<%
    Confirmation asa = new Confirmation();
    Vector<Confirmation> ff = asa.getConfirmation();

    Type_Billets asa1 = new Type_Billets();
    Vector<Type_Billets> ff1 = asa1.getType_Billets();

    Zones asa2 = new Zones();
    Vector<Zones> ff2 = asa2.getZones();
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
    <div class="container px-4 py-5" >
        <h1 style="text-align: center;"> Achats billets:</h1>
          
            <form class="needs-validation" action="Insertion_Place.jsp">
                    <label for="username" class="form-label">Zone A:</label>
                    <div class="row g-4  row-cols-1 row-cols-lg-3">
                        <div class="feature col">
                            <label for="username" class="form-label">Nom Olona</label>
                            <div class="input-group has-validation">
                            <input type="text" name="nom_createur" class="form-control"  placeholder="nom_olona" required>
                            </div>
                        </div>
                        <div class="feature col">
                            <label for="username" class="form-label">Quantite</label>
                            <div class="input-group has-validation">
                            <input type="number" name="quantite_t" class="form-control"  placeholder="Quantite" required>
                            </div>
                        </div>
                        <div class="feature col">
                            <label for="username" class="form-label">Zone</label>
                            <select name="zone" class="form-control">
                                <%for(int i=0; i<ff2.size(); i++){%>
                                <option value="<%=ff2.get(i).getId_Z()%>"><%=ff2.get(i).getNom_Zone()%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="feature col">
                            <label for="username" class="form-label">Type Billets</label>
                            <select name="billets" class="form-control">
                                <%for(int i=0; i<ff1.size(); i++){%> 
                                <option value="<%=ff1.get(i).getId_Type_Billets()%>"><%=ff1.get(i).getNom_Billets()%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="feature col">
                            <label for="username" class="form-label">Confirmation</label>
                            <select name="Confirmation" class="form-control">
                               <%for(int i=0; i<ff.size(); i++){%> 
                                <option value="<% out.println(ff.get(i).getId_Conf());%>"><%out.println(ff.get(i).getType_Conf());%></option>
                               <%}%>
                            </select>
                        </div>
                        <div class="feature col">
                            <label for="username" class="form-label">Date d'achats</label>
                            <div class="input-group has-validation">
                            <input type="date" name="date_achats" class="form-control"  placeholder="Date" required>
                            </div>
                        </div>
                        <div class="feature col">
                            <label for="username" class="form-label">Temps reservation</label>
                            <div class="input-group has-validation">
                            <input type="time" name="temp_reserver" class="form-control"  placeholder="Heure" required>
                            </div>
                        </div>
                    </div>
                    <br>
                    <button class="w-100 btn btn-primary btn-lg" type="submit">OK</button>
                </div>
            </form>
            
    </div>
</body>
</html>