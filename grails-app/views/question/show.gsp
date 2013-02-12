<!-- Afficher une question -->
<!-- @param question Question -->
<!-- @param sort Type de tri (optionnel) -->
<!-- @param listErreurs Liste des erreurs (optionnel) -->
<!-- @author Julien -->



<html>
	<head>
		<meta name="layout" content="main">
		<g:javascript src="questionShow.js" />
		<title>Question</title>
	</head>
	<body class="question-page">
		<div id="custom-header"></div>
		<div class="container">
			<g:render template="/header" model="[locality: 'questions']"/>
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
													<g:stackMessageOptions user="${fr.isima.stackoverlow.UserController.getUser()}" messageVotable="${question}"/>
												</td>
												<td class="post-signature owner">
													<div class="user-info user-hover">
														<div class="user-action-time">
															asked
															<g:stackDate date="${question.date}"/>
														</div>
														<div class="user-gravatar32">
															<a href="/StackOverlow/user/${question.author}">
																<div class="">
																	<g:stackAvatar user="${question.author}"/>
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
							<tr>
								<td class="votecell"></td>
								<td>
									<div class="comments-${question.id}" class="comments">
										<table>
											<tbody>
												<g:each var="commentaire" in="${question.commentaires}">
													<g:render template="/question/commentaire" model="[commentaire: commentaire]"/>
												</g:each>
											</tbody>
										</table>
										<form id="comment-form-${question.id}" action="/StackOverlow/commentaire/${question.id}/create/submit" method="post" style="display: none">
											<textarea cols="70" rows="1" name="content"></textarea>
											<input type="submit" value="${message(code: 'question.show.postYourComment')}" onClick="return validCommentaireForm(${question.id})">
										</form>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div id="answers" ${question.responses.size()==0 ? 'class="no-answers"' : ''}>
						<div id="answers-header">
							<div class="subheader answers-subheader">
								<h2>
									<g:if test="${question.responses.size() != 0}">
										<g:if test="${question.responses.size() == 1}">
											<g:message code="question.show.oneAnswers"/>
										</g:if>
										<g:else>
											<g:message code="question.show.manyAnswers" args="${[question.responses.size()]}"/>
										</g:else>
									</g:if>
								</h2>
								<div id="tabs" ${(question.responses.size()==0 ? 'style="display:none;"' : '')}>
									<a ${(sort==null || sort==fr.isima.stackoverlow.Sort.OLDEST ? 'class="youarehere"' : '')} title="Answers in the order they were provided" href="/StackOverlow/question/${question.id}?sort=${fr.isima.stackoverlow.Sort.OLDEST.toString()}"><g:message code="application.tri.oldest"/></a>
									<a ${(sort==fr.isima.stackoverlow.Sort.VOTES ? 'class="youarehere"' : '')} title="Answers with the highest score first" href="/StackOverlow/question/${question.id}?sort=${fr.isima.stackoverlow.Sort.VOTES.toString()}"><g:message code="application.tri.votes"/></a>
								</div>
							</div>
						</div>
						<g:each var="response" in="${question.responses}">
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
																<g:stackMessageOptions user="${fr.isima.stackoverlow.UserController.getUser()}" messageVotable="${response}"/>
															</td>
															<td class="post-signature owner">
																<div class="user-info user-hover">
																	<div class="user-action-time">
																		answered
																		<g:stackDate date="${response.date}"/>
																	</div>
																	<div class="user-gravatar32">
																		<a href="/StackOverlow/user/${response.author}">
																			<div class="">
																				<g:stackAvatar user="${response.author}"/>
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
													<form id="comment-form-${response.id}" action="/StackOverlow/commentaire/${response.id}/create/submit" method="post" style="display: none">
														<textarea cols="70" rows="1" name="content"></textarea>
														<input type="submit" value="${message(code: 'question.show.postYourComment')}" onClick="return validCommentaireForm(${response.id})">
													</form>
												</div>
											</td>
										</tr>
									<tbody>
								</table>
							</div>
						</g:each>
						<g:if test="${fr.isima.stackoverlow.UserController.isConnected()}">
							<a name="new-answer"></a>
							<form id="post-form" action="/StackOverlow/question/${question.id}/answer/submit" method="post" class="post-form">
								<h2 class="space"><g:message code="question.show.yourAnswer"/></h2>
								<div class="post-editor">
									<div class="wmd-container">
										<!-- Mise en forme -->
										<!-- Lien, image, ... -->
										<textarea class="wmd-input processed" tabindex="101" rows="15" cols="92" name="content"></textarea>
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
									<input type="submit" tabindex="110" value="${message(code: 'question.show.postYourAnswer')}"></input>
								</div>
							</form>
						</g:if>
					</div>
				</div>
				<div class="sidebar">
					<div class="module question-stats">
						<p class="label-key"><g:message code="question.show.tagged"/></p>
						<div class="tagged">
							<g:each var="tag" in="${question.tags}">
								<g:stackTagIconAndPopularity tag="${tag}"/>
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