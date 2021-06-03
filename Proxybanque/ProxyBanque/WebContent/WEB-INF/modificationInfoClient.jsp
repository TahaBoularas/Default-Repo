<html lang="fr"><head>
	    <title>ProxiBankSI - Modification info client</title>
	    <meta charset="utf-8">
	    <link rel="stylesheet" href="../img/mycssComptes.css">
	</head>
		<body><div class="contenant">
		   
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
			   			
					   	<form class="form" method="post" action="modificationInfosClient">
						   	<input type="hidden" id="id" name="id" value="${ client.id }" >
						   	<table class="greyGridTable">
						   	
  								<thead>
  								<tr>
  									<th>Paramètre</th>
  									<th>Information enregistrée</th>
  									<th>Modifier information</th>
  								</tr>
  								</thead>
  								
  								<tbody>
							   	<tr>
  									<td>Nom</td>
  									<td ><input type="hidden" id="ancienNom" name="ancienNom" value="${ client.nom }" ><c:out value="${ client.nom }"/></td>
							   		<td><input type="text" id="nom" name="nom" placeholder="${ client.nom }" disabled="disabled"></td>
					 			</tr>

				 				<tr>  
  									<td>Prénom</td>
  									<td><input type="hidden" id="ancienPrenom" name="ancienPrenom" value="${ client.prenom }" ><c:out value="${ client.prenom }"/></td>
  									<td><input type="text" id="prenom" name="prenom" placeholder="${ client.prenom }"></td>
					 			</tr>
				                
				                <tr>
				                	<td>Adresse</td>
				                	<td><input type="hidden" id="ancienneAdresse" name="ancienneAdresse" value="${ client.adresse }" ><c:out value="${ client.adresse }"/></td>
				                	<td><input type="text" id="adresse" name="adresse" placeholder="${ client.adresse }"></td>
				                </tr>

				                <tr>
				                	<td>Code postal</td>
				                	<td><input type="hidden" id="ancienCp" name="ancienCp" value="${ client.cp }" ><c:out value="${ client.cp }"/></td>
				                	<td><input type="text" id="cp" name="cp" placeholder="${ client.cp }"></td>
				                </tr>

				                <tr>
				                	<td>Ville</td>
				                	<td><input type="hidden" id="ancienneVille" name="ancienneVille" value="${ client.ville }" ><c:out value="${ client.ville }"/></td>
				                	<td><input type="text" id="ville" name="ville" placeholder="${ client.ville }"></td>
				                </tr>

				                <tr>
				                	<td>e-mail</td>
				                	<td><input type="hidden" id="ancienEmail" name="ancienEmail" value="${ client.email }" ><c:out value="${ client.email }"/></td>
				                	<td><input type="email" id="email" name="email" placeholder="${ client.email }"></td>
				                </tr>
				                	
				                <tr>
				                	<td>Télephone</td>
				                	<td><input type="hidden" id="ancienTelephone" name="ancienTelephone" value="${ client.telephone }" ><c:out value="${ client.telephone }"/></td>
				                	<td><input type="tel" id="telephone" name="telephone" placeholder="${ client.telephone }"></td>
				                </tr>

				            	</tbody>
			  				</table>

			  			<div class="centreBtn">
			  				<ul>
				   				<li ><input class="btn" type="submit" value="Valider">
				   				</li>
				   				<li ><input class="btn" type="reset" value="Annuler modifications"></li>
				   		  	</ul>
				   		</div>
			  			</form>	

			   		</div>
			   	</main>

			   	<aside>
			   		<div class="topRight">
			   		<p>Utilisateur connecté</p><hr>
		   		<c:out value="${sessionScope.Utilisateur.nom }"></c:out> <c:out value="${sessionScope.Utilisateur.prenom }"></c:out>
		   		</div>
			   	</aside>
			   </div>

	</body>
</html>