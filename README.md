StackOverlow
============

StackOverflow par les nuls...



TODO :
	M�thodes toString() des domains
	Pages d'erreur des questions/tags/users



Objectifs du projet :
	Grails
	Backend & frontend
	Backend : use RESTful API
	frontend : appli cliente HTML5 & JavaScript
	admin 



Configuration de l'IDE :
	Importer projet :
		Ouvrir le workspace d�sir�
	    File > Import...
	        Grails > Grails Project > Next
	            Location: > Browse... > "Chemin vers le r�pertoire" > OK
	            D�cocher "Copy resources into workspace"
	            Install: > "Choisir l'installation de Grails"
	            Finish
	
    Java :
        Window > Preferences
            Java > Installed JREs
            Add
                Aller jusqu'au chemin d'installation de "Java jdk"
            Cocher la nouvelle entr�e
    
    Grails :
        Window > Preferences
            Groovy > Grails
                "Add" ou "Edit"
                    Browse...
                    Chemin vers le r�pertoire d'installation de "Grails"



Git :
	T�l�chercher d�pot :
		git clone http://github.com/pinguet62/StackOverlow.git
	
    Commandes :
        git commit -a -m "message personnel"
        	A faire r�guli�rement, avec chaque petite fonctionnalit� que tu impl�mentes
        git pull
        	Il peut y avoir des conflits, une fois que tu les as corrig�es tu peux refaire "git pull" et tester si �a marche encore
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
