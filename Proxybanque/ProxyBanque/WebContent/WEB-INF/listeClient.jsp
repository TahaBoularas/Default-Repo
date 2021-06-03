

<!doctype html>
<html lang="fr">

	<head>
    <title>ProxiBankSI - Liste client</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../img/mycssComptes.css">
   	<!--<script src=Script.js></script>  -->
  	</head>
  
	<body>
 	<div class="contenant">
		<header>
  			<nav id="nav">
				<ul>
					<li><a href="../home.html" >Home</a></li>
					<li><a href="../deconnexion">Déconnexion</a></li>
					
				</ul>
			</nav>
  		</header>
  		<main>
		   		<div class="middle">
		   			<form action="afficherCompte" method="get" class="form-listeClient">
  						<table class="greyGridTableList">
  						<thead>
  								<tr>
  									<th>selectionner</th>
  									<th>nom</th>
  									<th>prénom</th>
  									<th>adresse</th>
  									<th>cp</th>
  									<th>ville</th>
  									<th>email</th>
  									<th>telephone</th>
  								</tr>
  						</thead>
  						<tbody>
  							<c:forEach items="${ Liste }" var="client" varStatus="status">
  								<tr>	
  									<td><input type="radio" id="radioClient" name="radioClient" value="${ client.id }" checked="checked" ></td>
  									<td><c:out value="${ client.nom }"/></td>
  									<td><c:out value="${ client.prenom }"/></td>
  									<td><c:out value="${ client.adresse }"/></td>
  									<td><c:out value="${ client.ville }"/></td>
  									<td><c:out value="${ client.cp }"/></td>
  									<td><c:out value="${ client.email }"/></td>
  									<td><c:out value="${ client.telephone }"/></td>
  								</tr>
  							</c:forEach>
  						</tbody>
  						</table>
  						<div class="centreBtnList">
  						<ul>
		   					<li><input class="btn" type="submit" value="Afficher compte"></li>
		   					<li><input class="btn" type="submit" formaction="modificationInfosClient"value="modifier info client"></li>
		   					<li><input class="btn" type="submit" formaction="suppressionClient" value="supprimer client"></li>
		   					<li><input class="btn" type="submit" formaction="creationClient"value="nouveau client"></li>
		   				</ul>
		   				</div>
  					</form>
  				</div>
		</main>
		<aside>
		   		<div class="topRight">
		   		<p>Utilisateur connecté<p>
		   		<hr>
		   		<c:out value="${sessionScope.Utilisateur.nom }"></c:out> <c:out value="${sessionScope.Utilisateur.prenom }"></c:out>
		   		</div>
		</aside>
		<footer id="action">
		</footer>
	 </div>
	</body>
</html>			
