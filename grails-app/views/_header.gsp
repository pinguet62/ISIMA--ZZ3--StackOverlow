<!-- En-tête des pages web -->
<!-- @param locality Section du site : 'questions', 'tags', 'users', 'askquestion' -->
<!-- @author Julien -->



<div id="header">
	<div id="topbar">
		<div id="hlinks">
			<span id="hlinks-user">
				<g:if test="${! fr.isima.stackoverlow.UserController.isConnected()}">
					<a href="/StackOverlow/logUser"><g:message code="menu.login"/></a>
				</g:if>
				<g:else>
					<g:set var="user" value="${fr.isima.stackoverlow.UserController.getUser()}"/>
					<a class="profile" href="/StackOverlow/user/${user.id}">${user.name}</a>
					<a href="/StackOverlow/user/${user.id}">
						<span class="reputation-score" dir="ltr" title="your reputation; view reputation changes">
							${new fr.isima.stackoverlow.VoteService().getReputation(user)}
						</span>
					</a>
					<span class="lsep"> | </span>
					<a href="/StackOverlow/user/logout"><g:message code="menu.logout"/></a>
					<span class="lsep"> | </span>
				</g:else>
			</span>
			<span class="lsep"> | </span>
			<a href="/StackOverlow/?lang=en"><g:img dir="" file="en.jpg" width="20" height="15"/></a>
			<span class="lsep"> | </span>
			<a href="/StackOverlow/?lang=fr"><g:img dir="" file="fr.jpg" width="20" height="15"/></a>
		</div>
	</div>
	<br class="cbt"></br>
	<div id="hlogo">
		<a href="/StackOverlow/">
			Stack Overflow
		</a>
	</div>
	<div id="hmenus">
		<div class="nav mainnavs">
			<ul>
				<li ${locality.equals("questions") ? 'class="youarehere"' : ''}><a id="nav-questions" href="/StackOverlow/question"><g:message code="menu.questions" /></a></li>
				<li ${locality.equals("tags") ? 'class="youarehere"' : ''}><a id="nav-tags" href="/StackOverlow/tag"><g:message code="menu.tags"/></a></li>
				<li ${locality.equals("users") ? 'class="youarehere"' : ''}><a id="nav-users" href="/StackOverlow/user"><g:message code="menu.users"/></a></li>
			</ul>
		</div>
		<div class="nav askquestion">
			<ul>
				<li ${locality.equals("askquestion") ? 'class="youarehere"' : ''}><a id="nav-askquestion" href="/StackOverlow/question/create"><g:message code="menu.ask"/></a></li>
			</ul>
		</div>
	</div>
</div>