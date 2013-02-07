<head>
    <title>Log In - Stack Overflow</title>
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
				document.getElementById('labUser').style.color='red';
				document.getElementById('username').style.color='red';
				document.getElementById('labUser').innerHTML ='utilisateur invalide - taille minimal: 5 caractères';
				ret= false;
			}
            

			if(checkEmail(mail) == false)
			{
				document.getElementById('labMail').style.color='red';
				document.getElementById('labMail').innerHTML ='mail invalide';
				ret= false;
			}

			
			if(checkPassword()==false)
			{
				document.getElementById('labPassword').style.color='red';
				document.getElementById('labPassword').innerHTML ='Les mots de passe doivent être identique et de taille superieur à 5';
				ret= false;	
			}

			
			if(checkUrlProfile(urlProfile)==false)
			{
				document.getElementById('labProfile').style.color ='red';
				document.getElementById('labProfile').innerHTML ='URL invalide';
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
			return true;
	}
	
    function checkPassword()
    {
		var p1 = document.getElementById('password1').value;
		var p2 = document.getElementById('password2').value;
		

		if(p1 != p2 )
		{
			document.getElementById('password2').style.color='red';
			return false;
		}
		else if(p1.length <5)
		{
			document.getElementById('password2').style.color='red';
			return false;
		}
		else
		{
			document.getElementById('password2').style.color='black';
			return true;
		}
        
    }
        
	</SCRIPT> 
</head>

<body style="cursor: default;" class="login-page">
    <div class="container">
        <g:render template="/header" model="[locality: 'user']"/>
        <div id="content">
        	<div class="subheader">
        	    <h1>Create Account</h1>
			</div>
			<div style="width: 625px;" id="mainbar">
				<div class="page-description">
        		Edit the field you want to change
        		<form id="monForm" class="post-form" method="post" action="/StackOverlow/user/edit">
	        		<input id="iduser" name="iduser" type="hidden" value="${userEdit.id }" />
	        		<g:textField id="username" name="username" value="${userEdit.name }" onKeyDown="document.getElementById('username').style.color='black';document.getElementById('labUser').innerHTML ='';" onclick="if(document.getElementById('username').value =='Enter a username' )JavaScript:document.getElementById('username').value = '';"/>&nbsp;<label for="username" id="labUser"></label><br>
	        		<g:textField id="profile" name="profile" size="50" onChange="checkUrlProfile(this.value)" value="${userEdit.avatarUrl }" onKeyDown="document.getElementById('profile').style.color='black';document.getElementById('LabProfile').innerHTML ='';" onclick="if(document.getElementById('profile').value =='profile picture html link' )JavaScript:document.getElementById('profile').value = '';"/>&nbsp;<label for="profile" id="labProfile"></label><br>
	        		<g:textField id="mail" name="mail" size="30" value="${userEdit.mail }" onKeyDown="document.getElementById('mail').style.color='black';document.getElementById('labMail').innerHTML ='';" onChange="checkEmail(this.value)" onclick="if(document.getElementById('mail').value =='Enter your email' )JavaScript:document.getElementById('mail').value = '';"/>&nbsp;<label for="mail" id="labMail"></label><br>
	        		<g:textField id="password1" name="password1" type="password" value="${userEdit.password }" onKeyDown = "document.getElementById('labPassword').innerHTML ='';" onChange="checkPassword()" onclick="JavaScript:if(document.getElementById('password1').value =='type a password' ){document.getElementById('password1').value = '';javascript:this.type='password';}" /><br>
	        		<g:textField id="password2" name="password2" type="password" value="${userEdit.password }" onKeyDown = "document.getElementById('password2').style.color='black';document.getElementById('labPassword').innerHTML ='';" onChange="checkPassword()" onclick="JavaScript:if(document.getElementById('password2').value =='retype your password' ){document.getElementById('password2').value = '';javascript:this.type='password';}" />&nbsp;<label for="password2" id="labPassword"></label><br>
	        		
					<div class="form-submit cbt">
					<label id="labMessage" for="submit-button" style="color:red">${message }</label><br>
									<input id="submit-button" type="submit" tabindex="120" value="Update account"></input>
						<a class="discard-question dno" href="#">discard</a>
					</div>
				</form>
    		</div>        
		</div>
	</div> 
	</div>   
    <g:render template="/footer"/>
</body>
