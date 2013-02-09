<!-- Formulaire d'édition d'une question -->
<!-- @param question Question -->
<!-- @param strListTags Liste des noms des tags (temporaire) -->
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
					<form id="post-form-${question.id}" class="post-form" method="post" action="/StackOverlow/question/${question.id}/edit/submit">
						<div id="post-editor-${question.id}" class="post-editor">
							<div class="form-item" style="margin:0px; padding:0px">
								<table style="width:668px">
									<tbody>
										<tr>
											<td style="width:50px">
												<label for="title">Title</label>
											</td>
											<td style="padding-left:5px">
												<input id="title" class="ask-title-field" type="text" value="${question.title}" tabindex="100" maxlength="300" name="title" style="opacity: 1;"></input>
												<span class="edit-field-overlay">
													what's your programming question? be specific.
												</span>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="wmd-container">
								<textarea id="wmd-input-${question.id}" class="wmd-input processed" tabindex="101" rows="15" cols="92" name="content">${question.content}</textarea>
								<div class="grippie" style="margin-right: 0px;"></div>
							</div>
							<div class="fl" style="margin-top: 8px; height:24px;"></div>
							<div id="wmd-preview-${question.id}" class="wmd-preview">${question.content}</div>
							<div></div>
						</div>
						<div class="form-item">
							<label>Tags</label>
							<div class="tag-editor" style="width: 666px; height: 28px; opacity: 1;">
								<!-- Liste des tags avec bouton suppression -->
								<input type="text" tabindex="103" style="width: 530px;" value="${strListTags}" name="strListTags"></input>
							</div>
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