<head>
    <title><g:message code="user.login.createaccount" /> - Stack Overflow</title>
    <link rel="shortcut icon" href="http://cdn.sstatic.net/stackoverflow/img/favicon.ico">
    <link rel="apple-touch-icon" href="http://cdn.sstatic.net/stackoverflow/img/apple-touch-icon.png">
    <link rel="search" type="application/opensearchdescription+xml" title="Stack Overflow" href="/opensearch.xml">
    <script src="http://www.google-analytics.com/ga.js" async="" type="text/javascript"></script><script src="http://edge.quantserve.com/quant.js" async="" type="text/javascript"></script><script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://cdn.sstatic.net/js/stub.js?v=faf00e16e9bc"></script>
    <link rel="stylesheet" type="text/css" href="http://cdn.sstatic.net/stackoverflow/all.css?v=6d7ec4d8bbbd">
    <meta http-equiv="X-XRDS-Location" content="http://stackoverflow.com/yadis">
    <script src="http://cdn.sstatic.net/Js/third-party/openid-jquery.js?v=c24b24e13307" type="text/javascript"></script>

    <SCRIPT language="Javascript">
    $(document).ready(function() {
        // lorsque je soumets le formulaire
        $('#monForm').on('submit', function() {

            var ret=true;
            // je récupère les valeurs
            var pseudo = $('#username').val();
            var mail = $('#mail').val();
            var urlProfile = $('#profile').val();
            

            
			if(pseudo.length < 5 || pseudo=='Enter a username')
			{
				
				document.getElementById('username').style.color='red';
				document.getElementById('labUser').style.display = 'block';
				ret= false;
			}
            

			if(checkEmail(mail) == false)
			{
				document.getElementById('labMail').style.display = 'block';
				ret= false;
			}

			
			if(checkPassword()==false)
			{
				document.getElementById('labPassword').style.display = 'block';
				ret= false;	
			}

			
			if(checkUrlProfile(urlProfile)==false)
			{
				document.getElementById('labProfile').style.display = 'block';
				ret= false;	
			}

			return ret; // j'empêche le navigateur de soumettre lui-même le formulaire
        });
    });

    var reg = new RegExp('^[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*@[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*[\.]{1}[a-z]{2,6}$', 'i');
    var regUrl = new RegExp('^https?:\/\/(?:[a-z\-]+\.)+[a-z]{2,6}(?:\/[^\/#?]+)+\.(?:jpe?g|gif|png)$', 'i');
    function checkEmail(email)
    {
	   		if(reg.test(email))
			{
	   			document.getElementById('mail').style.color='black';
	   			return true;
			}
			else
			{
				document.getElementById('mail').style.color='red';
				return false;
			}
    }

	function checkUrlProfile(url)
	{
		if(regUrl.test(url))
			return true;
		else
			return false;
	}
	
    function checkPassword()
    {
		var p1 = document.getElementById('password1').value;
		var p2 = document.getElementById('password2').value;
		

		if(p1 != p2 )
		{
			return false;
		}
		else if(p1.length <5)
		{
			return false;
		}
		else
		{
			document.getElementById('password2').style.color='black';
			return true;
		}
        
    }


    onload = function() {
    	document.getElementById('labUser').style.color='red';
    	document.getElementById('labUser').style.display = 'none';

    	document.getElementById('labProfile').style.color ='red';
		document.getElementById('labProfile').style.display = 'none';

		document.getElementById('labMail').style.color='red';
		document.getElementById('labMail').style.display = 'none';


		document.getElementById('labPassword').style.color='red';
		document.getElementById('labPassword').style.display = 'none';
    	
    }
    
	</SCRIPT> 
</head>

<body style="cursor: default;" class="login-page">
    <div class="container">
        <g:render template="/header" model="[locality: 'users']"/>
        <div id="content">
        	<div class="subheader">
        	    <h1><g:message code="user.login.createaccount" /></h1>
			</div>
			<div style="width: 625px;" id="mainbar">
				<div class="page-description">
        		
        		<form id="monForm" class="post-form" method="post" action="/StackOverlow/user/create">
	        		<g:textField id="username" name="username" value="${g.message(code: "user.create.enterusername")}" onKeyDown="document.getElementById('username').style.color='black';document.getElementById('labUser').style.display = 'none'" onclick="if(document.getElementById('username').value =='Enter a username' || document.getElementById('username').value =='Entrez un nom' )JavaScript:document.getElementById('username').value = '';"/>&nbsp;<label for="username" id="labUser">${g.message(code: "user.create.wrongusername")}</label><br>
	        		<g:textField id="profile" name="profile" size="50" onChange="checkUrlProfile(this.value)" value="${g.message(code: "user.create.enterprofilepicture")}" onKeyDown = "document.getElementById('labProfile').style.display = 'none';" onclick="if(document.getElementById('profile').value =='Profile picture html link' || document.getElementById('profile').value =='Lien html vers une image' )JavaScript:document.getElementById('profile').value = '';"/>&nbsp;<label for="profile" id="labProfile">${g.message(code: "user.create.wrongurlprofile")}</label><br>
	        		<g:textField id="mail" name="mail" size="30" value="${g.message(code: "user.create.enteremail")}" onKeyDown="document.getElementById('mail').style.color='black';document.getElementById('labMail').style.display = 'none';" onChange="checkEmail(this.value)" onclick="if(document.getElementById('mail').value =='Enter your e-mail' || document.getElementById('mail').value =='Entrez votre e-mail' )JavaScript:document.getElementById('mail').value = '';"/>&nbsp;<label for="mail" id="labMail">${g.message(code: "user.create.wrongemail")}</label><br>
	        		<g:textField id="password1" name="password1" type="password" value="${g.message(code: "user.create.enterpassword1")}" onKeyDown = "document.getElementById('labPassword').style.display = 'none';" onChange="checkPassword()" onclick="JavaScript:if(document.getElementById('password1').value =='Type a password' || document.getElementById('password1').value =='Entrez votre mot de passe' ){document.getElementById('password1').value = '';javascript:this.type='password';}" /><br>
	        		<g:textField id="password2" name="password2" type="password" value="${g.message(code: "user.create.enterpassword2")}" onKeyDown = "document.getElementById('password2').style.color='black';document.getElementById('labPassword').style.display = 'none';" onChange="checkPassword()" onclick="JavaScript:if(document.getElementById('password2').value =='Retype the password' || document.getElementById('password2').value =='Ré-entrez votre mot de passe' ){document.getElementById('password2').value = '';javascript:this.type='password';}" />&nbsp;<label for="password2" id="labPassword">${g.message(code: "user.create.wrongpassword")}</label><br>
	        		
					<div class="form-submit cbt">
					<label id="labMessage" for="submit-button" style="color:red">${message }</label><br>
									<input id="submit-button" type="submit" tabindex="120" value="${g.message(code: "user.login.createaccount")}"></input>
						<a class="discard-question dno" href="#">discard</a>
					</div>
				</form>
    		</div>        
		</div>
	</div> 
	</div>   
    <g:render template="/footer"/>
</body>
