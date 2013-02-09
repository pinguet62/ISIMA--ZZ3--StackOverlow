<!-- Afficher un tag -->
<!-- @param tag Tag -->
<!-- @BUG Affichage de la description -->
<!-- @author Julien -->


<html>
	<head>
		<meta name="layout" content="main">
		<title>Tag</title>
	</head>
	<body class="tags-page">
		<div id="custom-header"></div>
		<div class="container">
			<g:render template="/header" model="[locality: 'tags']"/>
			<div id="content">
				<div id="mainbar">
					<div class="subheader">
						<h1>Tag info</h1>
						<div id="tabs">
							<a class="youarehere" title="information about this tag" href="/tag/${tag.id}">info</a>
						</div>
					</div>
					<div id="questions" class="content-padding">
						<h2>
							About
							<g:stackTagIcon tag="${tag}"/>
						</h2>
						<div class="post-text">
							${tag.description}
						</div>
						<div class="post-menu">
							<form class="form-submit" action="/StackOverlow/tag/${tag.id}/edit" method="get">
								<input type="submit" value="Edit Tag Wiki"></input>
							</form>
						</div>
						<br class="cbt"></br>
					</div>
					<br class="cbt"></br>
				</div>
				<div class="sidebar">
					<div class="module">
						<div class="summarycount al">
							${new fr.isima.stackoverlow.TagService().nbQuestionsTagged(tag)}
						</div>
						<p>questions tagged</p>
						<div class="tagged">
							<g:stackTagIcon tag="${tag}"/>
						</div>
					</div>
				</div>
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>