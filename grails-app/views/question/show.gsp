<html>
	<head>
		<meta name="layout" content="main">
		<title>Question</title>
	</head>
	
	<body class="question-page">
		<div id="custom-header"></div>
		<div class="container">
			<g:render template="/header" model="[locality: 'question']"/>
			<div id="content">
				<div id="question-header">
					<h1>${question.title}</h1>
				</div>
				<div class="sidebar">
					<div class="module question-stats">
						<p class="label-key">tagged</p>
						<div class="tagged">
							<g:each var="tag" in="${question.tags}">
								<g:render template="/tag/iconeAndCount" model="[tag: tag]"/>
								<br></br>
							</g:each>
						</div>
					</div>
				</div>
				<div id="mainbar">
					<div class="question" id="question">
						<table>
							<tr>
								<td class="votecell">
									<g:render template="/question/voteCell" model="[message: message]"/>
								</td>
								<td class="postcell">
									<div class="post-text">
										<p>${question.content}</p>
									</div>
									<div class="post-taglist">
										<g:each var="tag" in="${question.tags}">
											<a class="post-tag" rel="tag" href="/StackOverlow/tag/${tag.id}">${tag.name}</a>
										</g:each>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div id="answers">
						<div id="answers-header">
							<div class="subheader answers-subheader">
								<h2>${question.responses == null ? 0 : question.responses.size()} Answers</h2>
							</div>
						</div>
						<g:each var="response" in="${question.responses}">
							<div id="answer-${response.id}" class="answer">
								<table>
									<tbody>
										<tr>
											<td class="votecell">
												<g:render template="/question/voteCell" model="[message: message]"/>
											</td>
											<td class="answercell">
												<div class="post-text">
													<p>${response.content}</p>
												</div>
											</td>
										</tr>
										<tr>
											<td class="votecell"></td>
											<td>
												<div class="comments-${response}" class="comments">
													<table>
														<tbody>
															<g:each var="commentaire" in="${response.commentaires}">
																<g:render template="/question/commentaire" model="[commentaire: commentaire]"/>
															</g:each>
														</tbody>
													</table>
												</div>
											</td>
										</tr>
									<tbody>
								</table>
							</div>
						</g:each>
						<form id="post-form" action="/response/create/${question.id}" method="post" class="post-form">
							<h2 class="space">Your Answer</h2>
							<div class="post-editor">
								<div class="wmd-container">
									<!-- Mise en forme -->
									<!-- Lien, image, ... -->
									<textarea class="wmd-input processed" tabindex="101" rows="15" cols="92" name="response-content"></textarea>
									<div class="grippie" style="margin-right: 0px;"></div>
								</div>
								<div class="fl" style="margin-top: 8px; height:24px;"></div>
								<div class="wmd-preview"></div>
							</div>
							<div class="form-submit cbt">
								<input type="submit" tabindex="110" value="Post Your Answer"></input>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>