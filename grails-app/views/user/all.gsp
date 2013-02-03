<head>
    <title>Users - Stack Overflow</title>
    <link rel="shortcut icon" href="http://cdn.sstatic.net/stackoverflow/img/favicon.ico">
    <link rel="stylesheet" type="text/css" href="http://cdn.sstatic.net/stackoverflow/all.css">
</head>

<body class="users-page">
   
    <div id="notify-container"></div>
    <div id="overlay-header"></div>
    <div id="custom-header"></div>

    <div class="container">
        <g:render template="/header" model="[locality: 'user']"/>
           


 <div id="content">
    <div id="mainbar-full">
    	<div class="subheader">
        	<h1 id="h-users">Users</h1>
        	<div id="tabs">
        	<g:if test="${view == 'nofilter'}">
        		<a class="youarehere" href="/StackOverlow/user/all" title="Display all users">All</a>
        	</g:if>
        	<g:else>
        		<a href="/StackOverlow/user/all" title="Display all users">All</a>
        	</g:else>
            <g:if test="${view == 'admin'}">
				<a class="youarehere" href="/StackOverlow/user/all?sort=admin" title="Display Administrator">Admin</a>
			</g:if>
        	<g:else>
				<a href="/StackOverlow/user/all?sort=admin" title="Display Administrator">Admin</a>
			</g:else>
			<g:if test="${view == 'mark'}">
				<a class="youarehere" href="/StackOverlow/user/all?sort=mark" title="Display User marked">Mark</a>
			</g:if>
        	<g:else>
				<a href="/StackOverlow/user/all?sort=mark" title="Display User marked">Mark</a>
			</g:else>
			</div>
		</div>
		
			
<div id="user-browser">
    <table>
        <tbody>
							<tr>
							<g:each var="user" in="${listUsers}" status="cpt">
							
							<g:if test="${cpt%4 == 0}">
							</tr><tr>
							</g:if>
							
							
							<td>
							
							<div class="user-info user-hover">
								<div class="user-gravatar48">
									<a href="/StackOverlow/user/${user.id}">
									<div class="">
										<g:if test="${user.avatarUrl.equals('')}">
											<g:img dir="images/avatar" file="default.jpg" width="48" height="48"/>
										</g:if>
										<g:elseif test="${user.avatarUrl.substring(0, 4).equals('http')}">
											<img src="${user.avatarUrl}" alt="" width="48" height="48">
										</g:elseif>
										<g:else>
											<g:img dir="" file="${user.avatarUrl}" width="48" height="48"/>
										</g:else>
									</div>
									</a>
								</div>
								
								<div class="user-details">
									<a href="/StackOverlow/user/${user.id}">${user.name}</a>
									<br>
									<span class="user-location"></span>
									<br>
									<span class="reputation-score" dir="ltr" title="reputation of the member">${new fr.isima.stackoverlow.VoteService().getMark(user)}</span>
								</div>
								<div class="user-tags">
								</div>
							</div>
							</td>
							</g:each>
							</tr>
						</tbody>
    </table>
<!-- 
		<div class="pager fr">
			<span class="page-numbers current">1</span>
			<a href="/users?page=2&amp;tab=reputation&amp;filter=week" title="go to page 2"><span class="page-numbers">2</span></a>
			<a href="/users?page=3&amp;tab=reputation&amp;filter=week" title="go to page 3"><span class="page-numbers">3</span></a>
			<a href="/users?page=4&amp;tab=reputation&amp;filter=week" title="go to page 4"><span class="page-numbers">4</span></a>
			<a href="/users?page=5&amp;tab=reputation&amp;filter=week" title="go to page 5"><span class="page-numbers">5</span></a>
			<span class="page-numbers dots">â€¦</span>
			<a href="/users?page=38853&amp;tab=reputation&amp;filter=week" title="go to page 38853"><span class="page-numbers">38853</span></a>
			<a href="/users?page=2&amp;tab=reputation&amp;filter=week" title="go to page 2" rel="next"><span class="page-numbers next"> next</span></a>
		</div>
		 -->
</div>

      
</div>
</div>
</div>
   

    <g:render template="/footer"/>
</body>