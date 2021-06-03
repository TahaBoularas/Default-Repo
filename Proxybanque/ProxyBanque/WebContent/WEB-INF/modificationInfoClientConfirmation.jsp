
<!doctype html>
<html lang="fr">

	<head>
	    <title>ProxiBankSI - Modification info client</title>
	    <meta charset="utf-8">
	    <link rel="stylesheet" href="../img/mycssComptes.css">
	</head>
		<div class="contenant">
		   <body>
			   	<header>
					<nav id="nav">
						<ul>
							<li><a href="../gestion/listeClient" >Clients</a></li>
							<li><a href="../deconnexion">Déconnexion</a></li>
							
						</ul>
					</nav>
			   	</header>

			   	<main>
			   		<div class="middle">
			   			
			   			
			   				<c:choose>
			   				
			   					<c:when test="${not empty infosModifiees }">
			   					<p> Vous êtes sur le point de modifier les informations suivantes</p>
			   					
					   				<table class="greyGridTable">
						   	
  										<thead>
  											<tr>
  												<th>Paramètre modifié</th>
  												<th>Ancienne valeur</th>
  												<th>Nouvelle valeur</th>
  											</tr>
  										</thead>
  								
  										<tbody>
							   				<c:forEach items="${ infosModifiees }" var="info" varStatus="status">
							   					<tr>
							   						<td><c:out value="${ info.key }"/></td>
							   						<td><c:out value="${ client[fn:toLowerCase(info.key)]}"/></td>
							   						<td><c:out value="${ info.value }"/></td>
							   					</tr>
							   				</c:forEach>

				            			</tbody>
			  						</table>

		  							<div class="centreBtn">
			  							<ul>
				   							<li ><a class="btn" href="modificationInfosClient?modifierInformation=true" >Enregistrer</a></li>
				   						
				   							<li ><a class="btn" href="modificationInfosClient?modifierInformation=false" >Retour à la modification</a></li>
				   		  				</ul>
				   					</div>
				   				
				   				</c:when>
				   				<c:when test="${ empty infoModifiees }">
		  							<p> <c:out value="${ message }">Aucune information n'a été modifiée</c:out></p>
		  							<div class="centreBtn">
			  							<ul> 				
				   							<li ><a class="btn" href="modificationInfosClient?modifierInformation=false" >Retour à la modification</a></li>
				   							<li ><a class="btn" href="../gestion/listeClient" >Retour à la liste client</a></li>
				   		  				</ul>
				   					</div>
		  						</c:when>
		  						</c:choose>
		  				
		  				
		  				

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