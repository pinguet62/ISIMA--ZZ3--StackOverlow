<!-- Page d'erreur -->
<!-- @param locality Section du site : 'questions', 'tags', 'users', 'askquestion' -->
<!-- @param error Message d'erreur -->
<!-- @author Julien -->



<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="page.notFound.onglet"/></title>
	</head>
	<body class="question-page">
		<div id="custom-header"></div>
		<div class="container">
			<g:render template="/header" model="[locality: locality]"/>
			<div id="content">
				<div class="mainbar-full">
					<div class="subheader">
						<h1><g:message code="page.erreur.title"/></h1>
					</div>
					<div class="content-page leftcol">
						<p>
							${error}
						</p>
					</div>
				</div>
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>