# ECFReverso

Cahier des charges
Gestion de clients-prospects pour l’entreprise REVERSO

L’entreprise REVERSO veut pouvoir créer, modifier, supprimer ou afficher ses clients ou ses prospects.
	Sur la page d’accueil :
-	L’utilisateur devra choisir entre la gestion des clients et la gestion des prospects
-	Il choisira ensuite entre la création, la modification, la suppression ou l’affichage. Un label devra lui indiquer s’il gère des clients ou des prospects
-	L’utilisateur pourra quitter l’application ou revenir au choix de clients/prospects à tout moment
-	Si l’utilisateur choisit la modification ou la suppression, une liste déroulante apparaîtra sur cette page pour lui permettre de choisir la société suivant sa raison sociale.

	Pour la création, suppression, modification, une nouvelle page s’affichera :
-	Pour la création, tous les champs seront vides 
-	Pour la modification, tous les champs seront affichés et pourront être modifiés hormis l’identifiant
-	Pour la suppression, tous les champs seront affichés mais aucun champ ne pourra être modifié. Une boite de dialogue demandera confirmation de la suppression après validation
-	L’utilisateur devra pouvoir quitter l’application ou revenir à la page d’accueil à tout moment

	Pour l’affichage, une nouvelle page s’affichera :

-	Celle-ci affichera les clients de l’entreprise ou ses prospects suivant le choix fait en page d’accueil. La liste sera triée par raison sociale du client ou du prospect
-	Toutes les données des clients ou des prospects devront apparaître, sauf les commentaires
-	L’utilisateur devra pouvoir quitter l’application ou revenir à la page d’accueil à tout moment

Le client aura comme données : un identifiant, sa raison sociale, son adresse, son numéro de téléphone, son adresse mail de contact, son chiffre d’affaires et son nombre d’employés. L’utilisateur pourra rentrer des commentaires concernant le client. 
Le prospect aura comme données : un identifiant, sa raison sociale, son adresse, son numéro de téléphone, son adresse mail de contact, la date où il a été prospecté et s’il a semblé intéressé. L’utilisateur pourra rentrer des commentaires concernant le prospect.



Spécifications techniques

-	Le développement se fera en Java avec la bibliothèque graphique Swing
-	L’affichage de la liste des clients ou des prospects se fera avec une JTable 
-	Une Javadoc sera fournie dans un package dédié
-	La persistance des données se fera à l’aide de mySql ou SQLServer



Contenu du dossier : 

	La liste des fonctionnalités
	Le maquettage
	Le diagramme de Use Case
	Le diagramme de classes (Métier, Contrôleur, DAO)  
	Le MCD et le MPD
	Le script de la base de données
	Le dossier du projet (y compris le fichier de paramétrage de la base de données, le fichier log, le .gitignore)
