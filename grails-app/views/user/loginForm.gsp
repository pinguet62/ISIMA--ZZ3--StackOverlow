<head>
    <title><g:message code="user.login.login" /> - Stack Overflow</title>
    <link rel="shortcut icon" href="http://cdn.sstatic.net/stackoverflow/img/favicon.ico">
    <link rel="apple-touch-icon" href="http://cdn.sstatic.net/stackoverflow/img/apple-touch-icon.png">
    <link rel="search" type="application/opensearchdescription+xml" title="Stack Overflow" href="/opensearch.xml">
    <script src="http://www.google-analytics.com/ga.js" async="" type="text/javascript"></script><script src="http://edge.quantserve.com/quant.js" async="" type="text/javascript"></script><script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://cdn.sstatic.net/js/stub.js?v=faf00e16e9bc"></script>
    <link rel="stylesheet" type="text/css" href="http://cdn.sstatic.net/stackoverflow/all.css?v=6d7ec4d8bbbd">
    <meta http-equiv="X-XRDS-Location" content="http://stackoverflow.com/yadis">
    <script src="http://cdn.sstatic.net/Js/third-party/openid-jquery.js?v=c24b24e13307" type="text/javascript"></script>

</head>

<body style="cursor: default;" class="login-page">
    <div class="container">
        <g:render template="/header" model="[locality: 'users']"/>
        <div id="content">
        	<div class="subheader">
        	    <h1><g:message code="user.login.login" /></h1>
			</div>
			<div style="width: 625px;" id="mainbar">
				<div class="page-description">
				<form id="monForm" class="post-form" method="post" action="/StackOverlow/user/login">
					
	        		<input  type="text" id="mail" onclick="if(document.getElementById('mail').value =='Enter your email' || document.getElementById('mail').value =='Entrez votre e-mail')JavaScript:document.getElementById('mail').value = '';" name="mail" value="${g.message(code: "user.login.enteryouremail")}"/>&nbsp;<label id="labMessage" for="mail"><g:message code="user.login.email" /></label> <br>
	        		<input  type="text" id="password"  onclick="if(document.getElementById('password').value =='Enter your password' || document.getElementById('password').value =='Entrez votre mot de passe' )JavaScript:document.getElementById('password').value = ''; javascript:this.type='password';" name="password" value="${g.message(code: "user.login.enteryourpassword")}" />&nbsp;<label id="labMessage" for="password"><g:message code="user.login.password" /></label> <br>
	        		
	        		<div class="form-submit cbt">
	        		<label id="labMessage" for="submit-button" style="color:red">${message }</label><br>
									<input id="submit-button" type="submit" tabindex="120" value="${g.message(code: "user.login.login")}"></input>
					<a class="discard-question dno" href="#">discard</a>
					</div>
				</form>
				<a href="/StackOverlow/user/new"><g:message code="user.login.createaccount" /></a> 
				<br><br>
				userQ1Adresse@mail.com    userQ1Password <br>
				adminustrator1Adresse@mail.com   adminustrator1Password
				
    		</div>        
		</div>
	</div> 
	</div>   
    <g:render template="/footer"/>
</body>