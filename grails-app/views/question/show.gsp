<!-- Afficher une question -->
<!-- @param question Question -->
<!-- @param listErreurs Liste des erreurs (optionnel) -->



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
				<div id="mainbar">
					<div id="question" class="question" data-questionid="${question.id}">
						<table>
							<tr>
								<td class="votecell">
									<g:render template="/question/voteCell" model="[message: question]"/>
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
									<table class="fw">
										<tbody>
											<tr>
												<td class="vt">
													<div class="post-menu">
														<a class="suggest-edit-post" title="revise and improve this post" href="/StackOverlow/question/edit/${question.id}">edit</a>
													</div>
												</td>
												<td class="post-signature owner">
													<div class="user-info user-hover">
														<div class="user-action-time">
															asked
															<span class="relativetime" title="2010-01-19 20:40:56Z">${question.date}</span>
														</div>
														<div class="user-gravatar32">
															<a href="/StackOverlow/user/${question.author}">
																<div class="">
																	<img width="32" height="32" alt="" src="http://www.gravatar.com/avatar/b02cab91fb3c5604163c116c494de2a5?s=32&d=identicon&r=PG"></img>
																</div>
															</a>
														</div>
														<div class="user-details">
															<a href="/StackOverlow/user/${question.author.id}">${question.author.name}</a>
															<br/>
															<span class="reputation-score" dir="ltr" title="reputation score">
																${new fr.isima.stackoverlow.VoteService().getReputation(question.author)}
															</span>
														</div>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</table>
					</div>
					<div id="answers" ${question.responses.size()==0 ? 'class="no-answers"' : ''}>
						<div id="answers-header">
							<div class="subheader answers-subheader">
								<h2>
									<g:if test="${question.responses.size() != 0}">
										${question.responses.size()} Answers
									</g:if>
								</h2>
								<!-- Tri -->
							</div>
						</div>
						<g:each var="response" in="${question.responses}">
							<g:if test="${response.display}">
								<div id="answer-${response.id}" class="answer">
									<table>
										<tbody>
											<tr>
												<td class="votecell">
													<g:render template="/question/voteCell" model="[message: response]"/>
												</td>
												<td class="answercell">
													<div class="post-text">
														<p>${response.content}</p>
													</div>
													<table class="fw">
														<tbody>
															<tr>
																<td class="vt">
																	<div class="post-menu">
																		<a class="suggest-edit-post" title="revise and improve this post" href="/StackOverlow/response/edit/${response.id}">edit</a>
																	</div>
																</td>
																<td class="post-signature owner">
																	<div class="user-info user-hover">
																		<div class="user-action-time">
																			answered
																			<span class="relativetime" title="2010-01-19 20:40:56Z">${response.date}</span>
																		</div>
																		<div class="user-gravatar32">
																			<a href="/StackOverlow/user/${response.author}">
																				<div class="">
																					<img width="32" height="32" alt="" src="http://www.gravatar.com/avatar/b02cab91fb3c5604163c116c494de2a5?s=32&d=identicon&r=PG"></img>
																				</div>
																			</a>
																		</div>
																		<div class="user-details">
																			<a href="/StackOverlow/user/${response.author.id}">${response.author.name}</a>
																			<br/>
																			<span class="reputation-score" dir="ltr" title="reputation score">
																				${new fr.isima.stackoverlow.VoteService().getReputation(response.author)}
																			</span>
																		</div>
																	</div>
																</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
											<tr>
												<td class="votecell"></td>
												<td>
													<div class="comments-${response.id}" class="comments">
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
							</g:if>
						</g:each>
						<a name="new-answer"></a>
						<form id="post-form" action="/StackOverlow/question/${question.id}/answer/submit" method="post" class="post-form">
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
							<g:if test="${listErreurs != null  &&  ! listErreurs.isEmpty()}">
								<div class="form-error" style="margin-top:10px">
									<p>Oops! Your answer couldn't be submitted because:</p>
									<ul>
										<g:each var="erreur" in="${listErreurs}">
											<li>${erreur}</li>
										</g:each>
									</ul>
								</div>
							</g:if>
							<div class="form-submit cbt">
								<input type="submit" tabindex="110" value="Post Your Answer"></input>
							</div>
						</form>
						<h2 class="bottom-notice">
							Not the answer you're looking for? Browse other questions tagged
							<g:each var="tag" in="${question.tags}">
								<g:tagIcone tag="${tag}"/>
							</g:each>
							or
							<a href="/StackOverlow/question/ask">ask your own question</a>
							.
						</h2>
					</div>
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
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>