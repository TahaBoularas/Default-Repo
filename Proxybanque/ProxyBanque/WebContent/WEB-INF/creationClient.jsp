
<!doctype html>
<html lang="fr">

	<head>
	    <title>ProxiBankSI - Création client</title>
	    <meta charset="utf-8">
	    <link rel="stylesheet" href="../img/mycssComptes.css">
	</head>
		<div class="contenant">
		   <body>
			   	<header>
					<nav id="nav">
						<ul>
							<li><a href="<../gestion/listeClient"  >Clients</a></li>
							<li><a href="../deconnexion">Déconnexion</a></li>
							
						</ul>
					</nav>
			   	</header>

			   	<main>
			   		<div class="middle">
			   			
					   	<form class="form" method="post" action="creationClient">
					   		
					   		
					   		<label for="nom">Nom</label>
			  				<input type="text" id="ident" name="nom" value="${ client.nom }" >
			  				<label for="prenom">Prénom</label>
			 				<input type="text" id="ident" name="prenom" value="${ client.prenom }">
			 				<label for="adresse">Adresse</label>
			 				<input type="text" id="ident" name="adresse" value="${ client.adresse }">
			 				<label for="cp">Code postal</label>
			 				<input type="text" id="ident" name="cp" value="${ client.cp }">
			 				<label for="ville">Ville</label>
			 				<input type="text" id="ident" name="ville" value="${ client.ville }">
			 				<label for="email">Email</label>
			 				<input type="email" id="ident" name="email" value="${ client.email }">
			 				<label for="telephone">Télephone</label>
			 				<input type="tel" id="ident" name="telephone" value="${ client.telephone }">
			 				<label for="typeCompte">Type de compte</label>
			 				<select name="typeCompte" id="typeCompte">
			 				<option value="courant"> compte courant</option>
			 				<option value="epargne"> compte epargne</option>
			 				</select>
			 				<label for="typeCarte">Type de carte</label>
			 				<select name="typeCarte" vaue="typeCarte">
			 				<option value="aucune">Aucune</option>
			 				<option value="visa Electron">Visa Electron</option>
			 				<option value="visa Premier">Visa Premier</option>
			 				</select>
			 				<label for="categorieClient">Catégorie client</label>
			 				<select name="categorieClient" vaue="categorieClient">
			 				<option value="particulier">Particulier</option>
			 				<option value="entreprise">Pro</option>
			 				</select>
			 				
		  				
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