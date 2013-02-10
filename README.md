StackOverlow
============

StackOverflow par les nuls...



TODO :
	Méthodes toString() des domains
	Pages d'erreur des questions/tags/users



Objectifs du projet :
	Grails
	Backend & frontend
	Backend : use RESTful API
	frontend : appli cliente HTML5 & JavaScript
	admin 



Configuration de l'IDE :
	Importer projet :
		Ouvrir le workspace désiré
	    File > Import...
	        Grails > Grails Project > Next
	            Location: > Browse... > "Chemin vers le répertoire" > OK
	            Décocher "Copy resources into workspace"
	            Install: > "Choisir l'installation de Grails"
	            Finish
	
    Java :
        Window > Preferences
            Java > Installed JREs
            Add
                Aller jusqu'au chemin d'installation de "Java jdk"
            Cocher la nouvelle entrée
    
    Grails :
        Window > Preferences
            Groovy > Grails
                "Add" ou "Edit"
                    Browse...
                    Chemin vers le répertoire d'installation de "Grails"



Git :
	Téléchercher dépot :
		git clone http://github.com/pinguet62/StackOverlow.git
	
    Commandes :
        git commit -a -m "message personnel"
        	A faire régulièrement, avec chaque petite fonctionnalité que tu implémentes
        git pull
        	Il peut y avoir des conflits, une fois que tu les as corrigées tu peux refaire "git pull" et tester si ça marche encore
        git push



Fichier .gitgnore :
	*.iws
	*Db.properties
	*Db.script
	.settings
	stacktrace.log
	/*.zip
	/plugin.xml
	/*.log
	/*DB.*
	/cobertura.ser
	.DS_Store
	/target/
	/out/
	/web-app/plugins
	/web-app/WEB-INF/classes
	/.link_to_grails_plugins/
	/target-eclipse/
	
	.classpath
	.project
