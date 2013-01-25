StackOverlow
============

StackOverflow par les nuls...


Remarques :
	Certains constructeurs, comme Question, ne fonctionne pas lorsque l'on passe un attribut lié à la BDD en paramètre.
	Par exemple Question question = new Question(title: "title", content: "content", date: new Date(), user: user) ne fonctionne pas.
	Alors faisons Question question = new Question(title: "title", content: "content", date: new Date())
					question.user = user
	De même lorsque l'on essaye de faire un save() sur la même ligne que le constructeur.



Grails
Backend & frontend
Backend : use RESTful API
frontend : appli cliente HTML5 & JavaScript
admin 


pensé a mettre des cobtraiten sur les clase du model genre :
email(blank:false, nullable:false,email:true)
        password(blank:false, password:true)

sur: 
http://stackoverflow.com/questions/1720533/abstract-classes-in-gorm-relationships
http://stackoverflow.com/questions/2096891/grails-find-by-non-native-types

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



Créer un nouveau projet à partir des sources existantes :
    Ouvrir le workspace désiré
    File > Import...
        Grails > Grails Project > Next
            Location: > Browse... > "Chemin vers le répertoire" > OK
            Décocher "Copy resources into workspace"
            Install: > "Choisir l'installation de Grails"
            Finish



Configuration de l'IDE :
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
