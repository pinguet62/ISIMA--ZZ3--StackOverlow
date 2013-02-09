<!-- Formulaire d'édition d'une question -->
<!-- @param reponse Réponse -->
<!-- @param question Question associée -->
<!-- @param listErreurs Liste des erreurs (optionnel) -->
<!-- @author Julien -->



<html>
	<head>
		<meta name="layout" content="main">
		<title>Edit</title>
	</head>
	<body class="ask-page">
		<div id="custom-header"></div>
		<div class="container">
			<g:render template="/header" model="[locality: 'questions']"/>
			<div id="content">
				<div id="mainbar" class="ask-mainbar">
					<div class="module newuser">
						<p>Your edit will be placed in a queue until it is peer reviewed.</p>
						<p>We welcome all constructive edits, but please make them substantial. Avoid trivial, tiny one-letter edits unless absolutely necessary.</p>
					</div>
					<form id="post-form-${reponse.id}" class="post-form" method="post" action="/StackOverlow/response/${reponse.id}/edit/submit">
						<div id="post-editor-${reponse.id}" class="post-editor">
							<h2 style="margin-top:15px;">
								<a class="question-hyperlink" href="/question/${question.id}">${question.title}</a>
							</h2>
							<div>
								<div class="original-question post-text processed" style="height: 32px; overflow: hidden; margin-bottom: 3px; opacity: 1;">${question.content}</div>
								<div class="grippie" style="margin-right: 8px;"></div>
							</div>
							<h2 style="margin-top:15px;">Answer</h2>
							<div class="wmd-container">
								<textarea id="wmd-input-${reponse.id}" class="wmd-input processed" tabindex="101" rows="15" cols="92" name="post-text">${reponse.content}</textarea>
								<div class="grippie" style="margin-right: 0px;"></div>
							</div>
							<div class="fl" style="margin-top: 8px; height:24px;"></div>
							<div id="wmd-preview-2097396" class="wmd-preview">${reponse.content}</div>
							<div></div>
						</div>
						<!-- Edit Summary -->
						<div class="form-submit cbt">
							<input id="submit-button" type="submit" tabindex="110" value="Save Edits"></input>
							<a class="cancel-edit" href="/StackOverlow/${question.id}" style="margin-left:8px;" tabindex="111">cancel</a>
						</div>
						<g:if test="${listErreurs != null  &&  ! listErreurs.isEmpty()}">
							<div id="ask-error-container" class="form-error">
								<p>Oops! Your question couldn't be edited because:</p>
								<ul>
									<g:each var="erreur" in="${listErreurs}">
										<li>${erreur}</li>
									</g:each>
								</ul>
							</div>
						</g:if>
					</form>
				</div>
				<div id="sidebar" style="width:270px;">
					<!-- TODO -->
				</div>
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>