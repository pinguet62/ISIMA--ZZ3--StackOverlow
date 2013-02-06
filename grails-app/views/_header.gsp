<!-- En-tête des pages web -->
<!-- @param locality Section du site : 'questions', 'tag', 'user', 'askquestion' -->

<link rel="stylesheet" type="text/css" href="${resource(dir:'css', file:'style.css')}">

<div id="header">
	<div id="portalLink">
		<a class="genu" onclick="StackExchange.ready(function(){genuwine.click();});return false;">
			Stack Exchange
		</a>
	</div>
	<div id="topbar">
		<div id="hlinks">
			<span id="hlinks-user">
				<g:if test="${fr.isima.stackoverlow.UserController.isConnected()}">
					<g:set var="user" value="${fr.isima.stackoverlow.UserController.getUser()}"/>
					<span class="profile-triangle">▾</span>
					<a class="profile-link" href="/StackOverlow/user/${user.id}">${user.name}</a>
					<a href="/StackOverlow/user/${user.id}">
						<span class="reputation-score" dir="ltr" title="your reputation; view reputation changes">
							${new fr.isima.stackoverlow.VoteService().getReputation(user)}
						</span>
					</a>
					<span class="lsep">|</span>
					<a href="/StackOverlow/user/logout">log out</a> <!-- perso -->
					<span class="lsep">|</span>
				</g:if>
			</span>
			<span id="hlinks-nav">
				<g:if test="${! fr.isima.stackoverlow.UserController.isConnected()}">
					<a href="/StackOverlow/logUser">log in</a>
					<span class="lsep">|</span>
					careers 2.0
					<span class="lsep">|</span>
				</g:if>
			</span>
			<span id="hlinks-custom">chat</span>
			<span class="lsep">|</span>
			meta
			<span class="lsep">|</span>
			about
			<span class="lsep">|</span>
			faq
		</div>
		<div id="hsearch">
			<form id="search" autocomplete="off" method="get" action="/search">
				<div>
					<input class="textbox" type="text" value="" size="28" maxlength="140" tabindex="1" placeholder="search" name="q" autocomplete="off"></input>
				</div>
			</form>
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
				<li ${locality.equals("questions") ? 'class="youarehere"' : ''}><a id="nav-questions" href="/StackOverlow/question">Questions</a></li>
				<li ${locality.equals("tags") ? 'class="youarehere"' : ''}><a id="nav-tags" href="/StackOverlow/tag">Tags</a></li>
				<li ${locality.equals("users") ? 'class="youarehere"' : ''}><a id="nav-users" href="/StackOverlow/user">Users</a></li>
			</ul>
		</div>
		<div class="nav askquestion">
			<ul>
				<li ${locality.equals("askquestion") ? 'class="youarehere"' : ''}><a id="nav-askquestion" href="/StackOverlow/question/ask">Ask Question</a></li>
			</ul>
		</div>
	</div>
</div>