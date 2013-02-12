<!-- Page d'erreur relative aux questions -->
<!-- @param locality Section du site : 'questions', 'tags', 'users', 'askquestion' (optionnel) ('questions' par défaut) -->
<!-- @param error Message d'erreur -->
<!-- @author Julien -->



<g:if test="${locality == null}">
	<g:set var="locality" value="questions"/>
</g:if>



<g:render template="/erreur" model="[locality: locality, error: error]"/>