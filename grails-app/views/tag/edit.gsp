<!-- Formulaire d'édition d'un tag -->
<!-- @param tag Tag -->
<!-- @author Julien -->



<html>
	<head>
		<meta name="layout" content="main">
		<title>Edit</title>
	</head>
	<body class="tags-page">
		<div id="custom-header"></div>
		<div class="container">
			<g:render template="/header" model="[locality: 'tags']"/>
			<div id="content">
				<div id="mainbar" class="ask-mainbar">
					<h1>
						Editing tag wiki for 
						<g:stackTagIcon tag="${tag}"/>
					</h1>
					<form id="post-form" class="post-form" method="post" action="/StackOverlow/tag/${tag.id}/edit/submit">
						<div class="wmd-container">
							<textarea id="wmd-input" class="wmd-input processed" tabindex="101" rows="15" cols="92" name="description">${tag.description}</textarea>
							<div class="grippie" style="margin-right: 0px;"></div>
						</div>
						<div id="wmd-preview" class="wmd-preview">${tag.description}</div>
						<div class="form-submit cbt">
							<input id="submit-button" type="submit" tabindex="110" value="Save Edits" style="cursor: pointer;"></input>
							<a class="cancel-edit" href="/StackOverlow/tag/${tag.id}" style="margin-left:8px;" tabindex="111">cancel</a>
						</div>
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