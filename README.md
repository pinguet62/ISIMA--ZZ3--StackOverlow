StackOverlow
============

StackOverflow par les nuls...



Notes diverses :
	return render(...) dans les controlleurs pour afficher la vue, car la fonction ne quitte pas m�thode
	${message} permet de r�cup�rer un param�tre dans la vue



Remarques :
	Certains constructeurs, comme Question, ne fonctionne pas lorsque l'on passe un attribut li� � la BDD en param�tre.
	Par exemple Question question = new Question(title: "title", content: "content", date: new Date(), user: user) ne fonctionne pas.
	Alors faisons Question question = new Question(title: "title", content: "content", date: new Date())
					question.user = user
	De m�me lorsque l'on essaye de faire un save() sur la m�me ligne que le constructeur.



Sites webs :
	Appel d'un controller dans une vue :
		http://stackoverflow.com/questions/6346975/grails-call-controller-method-from-view
		http://grails.1312388.n4.nabble.com/How-to-call-a-controller-Methord-from-a-GSP-td1322019.html



Objectifs du projet :
	Grails
	Backend & frontend
	Backend : use RESTful API
	frontend : appli cliente HTML5 & JavaScript
	admin 



Structure de la page & CSS :
    site.header : custom-header
    site.page : container
        page.header : header
        page.content : content
            question.header : question-header
            question.sidebar : sidebar
            question.content : mainbar
                question : question
                responses : answers
                	response.header : answers-header
                	response.reponse : answer-2097396
                	...
                	response.reponse : answer-2101136
                	reponse.posterReponse : post-form
    site.footer : footer



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



<meta name="layout" content="main">
<!-- CSS -->
<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-responsive.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'layout.css')}" type="text/css">
<!-- JavaScript -->
<g:javascript src="bootstrap.js"/>
<g:javascript src="bootstrap.min.js"/>
<g:javascript src="jquery.js"/>
<g:javascript src="jquery-layout.js"/>
<g:javascript src="jquery-ui.js"/>

