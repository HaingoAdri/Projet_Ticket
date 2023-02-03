<!-- import de toutes les classe -->
<%@page import="connexion.*"%>
<%@page import="fonction.*"%>
<%@page import="asa.*"%>
<%@page import="main.*"%>

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
    <div class="container">
        <h1 style="text-align: center;"> Insertion Evenements:</h1>
          
            <form class="needs-validation" action="Insertion_Zones.jsp">
                <div class="row g-3">
                  
                  <div class="col-12">
                    <label for="username" class="form-label">Nom Createur</label>
                    <div class="input-group has-validation">
                      <input type="text" name="nom_createur" class="form-control"  placeholder="nom_createur" required>
                    </div>
                  </div>
      
                  <div class="col-12">
                    <label for="username" class="form-label">Nom Evenements</label>
                    <div class="input-group has-validation">
                      <input type="text" name="nom_evenements" class="form-control"  placeholder="nom_evenements" required>
                    </div>
                  </div>

                  <div class="col-12">
                    <label for="username" class="form-label">Date Evenements</label>
                    <div class="input-group has-validation">
                      <input type="date" name="date_evenements" class="form-control"  placeholder="date_evenements" required>
                    </div>
                  </div>

                  
                    <button class="w-100 btn btn-primary btn-lg" type="submit">Inserer</button>
                </div>
            </form>
            
    </div>
</body>
</html>