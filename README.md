StackOverlow
============

StackOverflow par les nuls...

Grails
Backend & frontend
Backend : use RESTful API
frontend : appli cliente HTML5 & JavaScript
admin 


pens� a mettre des cobtraiten sur les clase du model genre :
email(blank:false, nullable:false,email:true)
        password(blank:false, password:true)

sur: 
http://stackoverflow.com/questions/1720533/abstract-classes-in-gorm-relationships
http://stackoverflow.com/questions/2096891/grails-find-by-non-native-types



Cr�er un nouveau projet � partir des sources existantes :
    Ouvrir le workspace d�sir�
    File > Import...
        Grails > Grails Project > Next
            Location: > Browse... > "Chemin vers le r�pertoire" > OK
            D�cocher "Copy resources into workspace"
            Install: > "Choisir l'installation de Grails"
            Finish



Configuration de l'IDE :
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
    Commandes :
        git commit -a -m "message personnel"
        git pull
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
