<!-- Formulaire de création d'une question -->
<!-- @author Julien -->



<html>
	<head>
		<meta name="layout" content="main">
		<g:javascript src="questionCreate.js" />
		<title>Question</title>
	</head>
	<body class="question-page">
		<div id="custom-header"></div>
		<div class="container">
			<g:render template="/header" model="[locality: 'askquestion']"/>
			<div id="content">
				<div id="mainbar" class="ask-mainbar">
					<form id="post-form" class="post-form" method="post" action="/StackOverlow/question/create/submit" onSubmit="return validQuestionForm()">
						<div class="form-item ask-title">
							<table class="ask-title-table">
								<tbody>
									<tr>
										<td class="ask-title-cell-key">
											<label for="title">Title</label>
										</td>
										<td class="ask-title-cell-value">
											<input id="title" class="ask-title-field edit-field-overlayed" type="text" tabindex="100" maxlength="300" name="title" autocomplete="off"></input>
										</td>
									</tr>
								</tbody>
							</table>
							<div id="question-suggestions"></div>
						</div>
						<div id="post-editor" class="post-editor">
							<div class="wmd-container">
								<!-- Mise en forme -->
								<!-- Lien, image, ... -->
								<textarea id="wmd-input" class="wmd-input processed" tabindex="101" rows="15" cols="92" name="content"></textarea>
							</div>
							<div class="fl" style="margin-top: 8px; height:24px;"></div>
						</div>
						<div class="form-item">
							<label>Tags</label>
							<div class="tag-editor edit-field-overlayed" style="width: 666px; height: 28px; z-index: 1; position: relative;">
								<span style="">
									<!-- Liste des tags -->
								</span>
								<input type="text" tabindex="103" style="width: 658px;" name="strListTags"></input>
								<span></span>
							</div>
						</div>
						<div class="form-error" style="display:none" id="errorList1">
							<p>Ta réponse ne peut pas être publiée car :</p><!-- Your question couldn't be submitted because: -->
							<ul style="display:none" id="errorList2">
								<li style="display:none" id="errorEmptyTitle">il n'y a pas de titre</li>
								<li style="display:none" id="errorEmptyContent">le message est vide</li>
								<li style="display:none" id="errorEmptyTags">il y a aucun tag</li>
							</ul>
						</div>
						<div id="question-only-section">
							<div>
								<div class="form-submit cbt">
									<input id="submit-button" type="submit" tabindex="120" value="Post Your Question"></input>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div id="sidebar" class="ask-sidebar"></div>
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>