
<!doctype html>
<html lang="fr">

	<head>
	    <title>ProxiBankSI - Suppression client</title>
	    <meta charset="utf-8">
	    <link rel="stylesheet" href="../img/mycssComptes.css">
	</head>
		<div class="contenant">
		   <body>
			   	<header>
					<nav id="nav">
						<ul>
							<li><a href="../gestion/listeClient"  >Clients</a></li>
							<li><a href="../deconnexion">Déconnexion</a></li>
							
						</ul>
					</nav>
			   	</header>

			   	<main>
			   		<div class="middle">
			   		
			   			<div class="message">
			   			
			   			<h1><c:out value="${ message }"></c:out></h1>
			   			
			   			</div>
			   			
			   			<form class="form" method="post" action="suppressionClient">
			   			
			   			
			   			<table>
					   		<thead>
					   			<tr>
  									
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
					  			 <tr>						
  									<td><c:out value="${ client.nom }"/></td>
  									<td><c:out value="${ client.prenom }"/></td>
  									<td><c:out value="${ client.adresse }"/></td>
  									<td><c:out value="${ client.ville }"/></td>
  									<td><c:out value="${ client.cp }"/></td>
  									<td><c:out value="${ client.email }"/></td>
  									<td><c:out value="${ client.telephone }"/></td>
					   			</tr>
					   		</tbody>
					   	</table>
					   
					   <table>
					  		 <thead>
					   			<tr>
					   				<th>N° de compte</th>
  									<th>N° client</th>
  									<th>Type de compte</th>
  									<th>Date d'ouverture</th>
  									<th>Catégorie</th>
  									<th>Type de carte</th>
  									<th>taux de rémunération</th>
  									<th>autorisation de decouvert</th>
  									
					   			</tr>
					   			</thead>
					  			<tbody>
					   				<c:forEach items="${ comptes }" var="compte" varStatus="status">
					   				<input type=hidden id="idCompte" name="idCompte" value="${ compte.idCompte }">
			   						<input type=hidden id="idClient" name="idClient" value="${ compte.idClient }">
					   				<tr>
					   				
  									<td><c:out value="${ compte.idCompte }"/></td>
  									<td><c:out value="${  compte.idClient }"/></td>
  									<td><c:out value="${ compte.typeCompte }"/></td>
  									<td><c:out value="${ compte.dateOuverture }"/></td>
  									<td><c:out value="${  compte.categorieClient }"/></td>
  				 					<td><c:out value="${  compte.typeCarte }"/></td>
  				 					
  				 					<c:if test="${ compte.typeCompte eq 'epargne' }">
  									<td><c:out value="${  compte.tauxRemuneration }" /></td>
  									<td><c:out value="NULL" /></td>
  									</c:if>
  									<c:if test="${ compte.typeCompte eq 'courant' }">
  									<td><c:out value="NULL" /></td>
  									<td><c:out value="${  compte.autorisationDecouvert }" /></td>
  									</c:if>
  									</tr>
  									</c:forEach>
  								  									  									
					 			 </tbody>
					 	</table>
					   	
		  				<div >
		  				<ul>
			   				<li><input type="submit" class="bout" value="Valider">
			   				<li><input type="reset" class="bout" value="Annulation modifications"></li>
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

			   	<footer class="bout">
			   		
			   	</footer>
			   </div>
		   </body>

</html>