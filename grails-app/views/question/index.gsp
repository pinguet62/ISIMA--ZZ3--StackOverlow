<html>
	<head>
		<meta name="layout" content="main">
		<title>Question</title>
	</head>
	
	<body>
		<g:include view="site/header.gsp"/>
			<div class="container">
				<g:include view="page/header.gsp"/>
				<div class="content">
					<div class="question-header">
						Titre de la question
					</div>
					<div class="sidebar">
						Sidebar
					</div>
					<div class="mainbar">
						<div class="question">
							Question
						</div>
						<div class="answers">
							Liste des réponses<br/>
							1<br/>
							2<br/>
							...<br/>
							Formulaire de réponse
						</div>
					</div>
				</div>
			</div>
		<g:include view="site/footer.gsp"/>
	</body>
</html>