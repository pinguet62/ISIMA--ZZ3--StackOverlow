<html>
	<head>
		<meta name="layout" content="main">
		<title>Question</title>
	</head>
	
	<body class="question-page">
		<div id="custom-header"/>
		<div class="container">
			<g:render template="/header" model="[locality: 'question']"/>
			<div id="content">
				<div id="mainbar">
					<div class="subheader">
						<h1 id="h-all-questions">All Questions</h1>
						<div id="tabs">
							<!-- Tris -->
						</div>
					</div>
					<div id="questions">
						<g:each var="question" in="${listQuestions}">
							<div id="question-summary-${question.id}" class="question-summary">
								<div class="statscontainer">
									<div class="statsarrow"></div>
									<div class="stats">
										<div class="vote">
											<div class="votes">
												<span class="vote-count-post ">
													<strong>${new fr.isima.stackoverlow.VoteService().getMark(question)}</strong>
												</span>
												<div class="viewcount">votes</div>
											</div>
										</div>
										<g:if test="${question.responses == null}">
											<div class="status unanswered">
												<strong>0</strong>
												answers
											</div>
										</g:if>
										<g:else>
											<div class="status answered">
												<strong>${question.responses.size()}</strong>
												answers
											</div>
										</g:else>
									</div>
								</div>
								<div class="summary">
									<h3>
										<a class="question-hyperlink" href="/question/${question.id}">
											${question.title}
										</a>
									</h3>
									<div class="excerpt">
										${question.content}
									</div>
									<div class="tags t-cñ t-javascript t-aspûnet t-web-applications">
										<g:each var="tag" in="${question.tags}">
											<g:tagIcone tag="${tag}"/>
										</g:each>
									</div>
									<!-- Utilisateur -->
								</div>
							</div>
						</g:each>
					</div>
					<br class="cbt"></br>
					<div class="page-sizer fr">nombre par page</div>
					<div class="pager fl">pages</div>
				</div>
				<div class="sidebar">
					<div id="questions-count" class="module">
						<div class="summarycount al">
							${fr.isima.stackoverlow.Question.all.size()}
						</div>
						<p>questions</p>
					</div>
					<div id="related-tags" class="module">
						<h4 id="h-related-tags">Related Tags</h4>
						<g:each var="tag" in="${new fr.isima.stackoverlow.TagService().getAsc(0, 25)}">
							<g:render template="/tag/iconeAndCount" model="[tag: tag]"/>
							<br></br>
						</g:each>
					</div>
				</div>
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>