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
				document.getElementById('labPassword').innerHTML ='Les mots de passe doivent être identique';
				ret= false;	
			}
			if(checkUrlProfile()==false)
			{
				document.getElementById('labProfile').style.color='red';
				document.getElementById('profile').style.color='red';
				document.getElementById('labProfile').innerHTML ='URL invalide';
				ret= false;	
			}


			if(ret)
			{
				document.forms['monForm'].submit();
			}
			
			return ret; // j'empêche le navigateur de soumettre lui-même le formulaire
        });
    });

    var reg = new RegExp('^[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*@[a-z0-9]+([_|\.|-]{1}[a-z0-9]+)*[\.]{1}[a-z]{2,6}$', 'i');
    var regUrl = new RegExp('.*', 'i');
    function checkEmail(email)
    {
    	
        if(email.length > 0)
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
		
		if(p1 != p2)
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
        		<g:form id="monForm" url="[controller: 'user', action: 'create']">
	        		<g:textField id="username" name="username" value="Enter a username" onKeyDown="document.getElementById('username').style.color='black';document.getElementById('labUser').innerHTML ='';" onclick="if(document.getElementById('username').value =='Enter a username' )JavaScript:document.getElementById('username').value = '';"/>&nbsp;<label for="username" id="labUser"></label><br>
	        		<g:textField id="profile" name="profile" onChange="checkUrlProfile(this.value)" value="profile picture html link" onKeyDown="document.getElementById('profile').style.color='black';document.getElementById('LabProfile').innerHTML ='';" onclick="if(document.getElementById('profile').value =='profile picture html link' )JavaScript:document.getElementById('profile').value = '';"/>&nbsp;<label for="profile" id="labProfile"></label><br>
	        		<g:textField id="mail" name="mail" value="Enter your email" onKeyDown="document.getElementById('mail').style.color='black';document.getElementById('labMail').innerHTML ='';" onChange="checkEmail(this.value)" onclick="if(document.getElementById('mail').value =='Enter your email' )JavaScript:document.getElementById('mail').value = '';"/>&nbsp;<label for="mail" id="labMail"></label><br>
	        		<g:textField id="password1" name="password1" value="type a password" onKeyDown = "document.getElementById('labPassword').innerHTML ='';" onChange="checkPassword()" onclick="JavaScript:if(document.getElementById('password1').value =='type a password' )document.getElementById('password1').value = '';" /><br>
	        		<g:textField id="password2" name="password2" value="retype your password" onKeyDown = "document.getElementById('password2').style.color='black';document.getElementById('labPassword').innerHTML ='';" onChange="checkPassword()" onclick="JavaScript:if(document.getElementById('password2').value =='retype your password' )document.getElementById('password2').value = '';" />&nbsp;<label for="password2" id="labPassword"></label><br>
	        		<g:actionSubmit value="Creer compte" action="submit" />
				</g:form>
    		</div>        
		</div>
	</div> 
	</div>   
    <g:render template="/footer"/>
</body>