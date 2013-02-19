<!-- Afficher la liste des tags -->
<!-- @param listTags Liste des tages -->
<!-- @param sort Type de tri -->
<!-- @param currentPage Numéro de page courrante -->
<!-- @param listPages Liste des numéros de page -->
<!-- @author Julien -->



<html>
	<head>
		<meta name="layout" content="main">
		<title>Tags</title>
	</head>
	<body class="question-page">
		<div id="custom-header"></div>
		<div class="container">
			<g:render template="/header" model="[locality: 'tags']"/>
			<div id="content">
				<div id="mainbar-full">
					<div class="subheader">
						<h1 id="h-tags">Tags</h1>
						<div id="tabs">
							<a ${sort == fr.isima.stackoverlow.Sort.POPULAR ? 'class="youarehere"' : ''} title="most popular tags" href="/StackOverlow/tag?sort=${fr.isima.stackoverlow.Sort.POPULAR.toString()}"><g:message code="application.tri.popular"/></a>
							<a ${sort == fr.isima.stackoverlow.Sort.NAME ? 'class="youarehere"' : ''} title="tags in alphabetical order" href="/StackOverlow/tag?sort=${fr.isima.stackoverlow.Sort.NAME.toString()}"><g:message code="application.tri.name"/></a>
						</div>
					</div>
					<div class="page-description">
						<!-- Recherche -->
					</div>
					<div id="tags_list">
						<table id="tags-browser">
							<tbody>
								<tr>
									<g:each var="tag" in="${listTags}" status="cpt">
										<td class="tag-cell">
											<g:stackTagIconAndPopularity tag="${tag}"/>
											<div class="excerpt">
												${(tag.description != null ? tag.description.substring(0,(tag.description.size()<100 ? tag.description.size() : 100)) : "")}
											</div>
											<div>
												<div class="stats-row fl"></div>
												<div class="cbt"></div>
											</div>
										</td>
										<g:if test="${cpt != 36  &&  cpt%4 == 3}"></tr><tr></g:if>
									</g:each>
								</tr>
							</tbody>
						</table>
						<div class="pager fr">
							<g:render template="/listPages" model="[currentPage: currentPage, listPages: listPages, baseURL: '/StackOverlow/tag']"/>
						</div>
					</div>
				</div>
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>