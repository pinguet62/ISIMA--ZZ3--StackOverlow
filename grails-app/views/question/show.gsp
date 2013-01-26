<html>
	<head>
		<meta name="layout" content="main">
		<title>Question</title>
	</head>
	
	<body class="question-page">
		<div class="container">
			<div id="header">
				<div id="topbar">
					<div id="hlinks">
						<span id="hlinks-user">
							<a class="profile-link" href="/user/1"></a> <!-- TODO -->
						</span>
					</div>
				</div>
				<div id="hlogo">
					<a href="/">
						<img src="${resource(dir: 'images', file: 'logo.png')}" height="75">
					</a>
				</div>
				<div id="hmenus">
					<div class="nav mainnavs">
						<ul>
							<li class="youarehere"><a id="nav-questions" href="/question/all">Questions</a></li>
							<li><a id="nav-tags" href="/tag/all">Tags</a></li>
							<li><a id="nav-users" href="/user/all">Users</a></li>
						</ul>
					</div>
					<div class="nav askquestion">
						<ul>
							<li><a id="nav-askquestion" href="/question/create">Ask Question</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div id="content">
				<div id="question-header">
					<h1>${question.title}</h1>
				</div>
				<div class="sidebar">
					Sidebar
				</div>
				<div id="mainbar">
					<div class="question" id="question">
						<table>
							<tr>
								<td class="votecell">vote +/-</td>
								<td class="postcell">
									<div class="post-text">
										<p>${question.content}</p>
									</div>
									<div class="post-taglist">
										<g:each var="tag" in="${question.tags}">
											<a class="post-tag" rel="tag" href="/tag/${tag.id}">${tag.name}</a>
										</g:each>
									</div>
								</td>
							</tr>
						</table>
					</div>
					
					<div id="answers">
						<div id="answers-header">
							<div class="subheader answers-subheader">
								<g:if test="${question.responses == null}"><h2>0 Answers</h2></g:if>
								<g:if test="${question.responses != null}"><h2>${question.responses.size()} Answers</h2></g:if>
							</div>
						</div>
						
						<g:if test="${question.responses != null}">
							<g:each var="response" in="${question.responses}">
								<div id="answer-${response.id}" class="answer accepted-answer">
									<table>
										<tbody>
											<tr>
												<td class="votecell">vote +/-</td>
												<td class="answercell">
													<div class="post-text">
														<p>${response.content}</p>
													</div>
												</td>
											</tr>
											<tr>
												<td class="votecell"></td>
												<td>
													<div class="comments-${response.id}" class="comments">
														<table>
															<tbody>
																<g:if test="${response.commentaires != null}">
																	<g:each var="commentaire" in="${response.commentaires}">
																		<tr id="comment-${response.id}" class="comment">
																			<td></td>
																			<td class="comment-text">
																				<div>
																					<span class="comment-copy">${commentaire.content}</span>
																					<a class="comment-user" href="/user/${commentaire.author.id}">${commentaire.author.name}</a>
																					<span class="comment-date" dir="ltr">${commentaire.date}</span>
																				</div>
																			</td>
																		</tr>
																	</g:each>
																</g:if>
															</tbody>
														</table>
													</div>
												</td>
											</tr>
										<tbody>
									</table>
								</div>
							</g:each>
						</g:if>
						
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
		
		<div id="footer">
			<div class="footerwrap">
				<div id="footer-menu">
					<a href="/about">about</a>
					|
					<a href="/faq">faq</a>
					|
					<b><a href="/help">contact us</a></b>
				</div>
				<div id="copyright">
					© 2013 StackOverlow
				</div>
			</div>
		</div>
	</body>
</html>