<!-- Afficher la liste des pages disponibles -->
<!-- @param currentPage Numéro de page courrante -->
<!-- @param listPages Liste des numéros de page -->
<!-- @param baseURL URL de page des liens, le numéro de page y est inséré à la fin -->
<!-- @Author Julien -->



<div class="pager fl">
	<g:if test="${currentPage != 1}">
		<a rel="prev" title="go to page ${currentPage-1}" href="${baseURL}?page=${currentPage-1}">
			<span class="page-numbers prev"><g:message code="application.listPages.previous"/> </span>
		</a>
	</g:if>
	<g:each var="page" in="${listPages}">
		<g:if test="${page != 1  &&  ! listPages.contains(page-1)}">
			<span class="page-numbers dots">...</span>
		</g:if>
		<g:if test="${page == currentPage}">
			<span class="page-numbers current">${page}</span>
		</g:if>
		<g:else>
			<a title="go to page ${page}" href="${baseURL}?page=${page}">
				<span class="page-numbers">${page}</span>
			</a>
		</g:else>
	</g:each>
	<g:if test="${currentPage != listPages.last()}">
		<a rel="next" title="go to page ${currentPage+1}" href="${baseURL}?page=${currentPage+1}">
			<span class="page-numbers next"> <g:message code="application.listPages.next"/></span>
		</a>
	</g:if>
</div>