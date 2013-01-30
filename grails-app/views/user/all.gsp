<head>
    <title>Users - Stack Overflow</title>
    <link rel="shortcut icon" href="http://cdn.sstatic.net/stackoverflow/img/favicon.ico">
    <link rel="search" type="application/opensearchdescription+xml" title="Stack Overflow" href="/opensearch.xml">
   
	<script src="http://edge.quantserve.com/quant.js" async="" type="text/javascript"></script><script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://cdn.sstatic.net/js/stub.js?v=faf00e16e9bc"></script>
    <link rel="stylesheet" type="text/css" href="http://cdn.sstatic.net/stackoverflow/all.css?v=6d7ec4d8bbbd">
	<script src="http://cdn.sstatic.net/js/full-anon.js?v=b392f675b7fa" type="text/javascript" async=""></script><style type="text/css" charset="utf-8"></style>
</head>

<body class="users-page">
    <noscript><div id="noscript-padding"></div></noscript>
    <div id="notify-container"></div>
    <div id="overlay-header"></div>
    <div id="custom-header"></div>

    <div class="container">
        <div id="header">
            <div id="portalLink">
                <a class="genu" onclick="StackExchange.ready(function(){genuwine.click();});return false;">Stack Exchange</a>
            </div>
            <div id="topbar">
                <div id="hlinks">
				<span id="hlinks-user"></span>
				<span id="hlinks-nav">
                   <a href="/users/login?returnurl=%2fusers">log in</a>
                   <span class="lsep">|</span>
                   <a href="http://careers.stackoverflow.com">careers 2.0</a>
                   <span class="lsep">|</span>
                </span>
			<span id="hlinks-custom">
        		<a href="http://chat.stackoverflow.com">chat</a>
				<span class="lsep">|</span>
            	<a href="http://meta.stackoverflow.com">meta</a>
				<span class="lsep">|</span>
        		<a href="/about">about</a>
				<span class="lsep">|</span>
				<a href="/faq">faq</a>
			</span>
         </div>
         <div id="hsearch">
            <form id="search" action="/search" method="get" autocomplete="off">
	            <div>
	              <input autocomplete="off" name="q" class="textbox" placeholder="search" tabindex="1" maxlength="140" size="28" value="" type="text">
	            </div>
	        </form>
         </div>
      </div>
      <br class="cbt">
      <div id="hlogo">
      	<a href="/">Stack Overflow</a>
      </div>
      <div id="hmenus">
      	<div class="nav mainnavs">
            <ul>
               <li><a id="nav-questions" href="/questions">Questions</a></li>
               <li><a id="nav-tags" href="/tags">Tags</a></li>
               <li class="youarehere"><a id="nav-users" href="/users">Users</a></li>
               <li><a id="nav-badges" href="/badges">Badges</a></li>
               <li><a id="nav-unanswered" href="/unanswered">Unanswered</a></li>
            </ul>
        </div>
        <div class="nav askquestion">
          <ul>
             <li>
                <a id="nav-askquestion" href="/questions/ask">Ask Question</a>
             </li>
          </ul>
        </div>
      </div>
    </div>


 <div id="content">
    <div id="mainbar-full">
    	<div class="subheader">
        	<h1 id="h-users">Users</h1>
        	<div id="tabs">
            	<a class="youarehere" href="/users?tab=reputation" title="Users with the highest reputation scores">reputation</a>
				<a href="/users?tab=newusers" title="Users who joined in the last 30 days">new users</a>
				<a href="/users?tab=voters" title="Users who voted more than 10 times">voters</a>
				<a href="/users?tab=editors" title="Users who edited more than 5 posts">editors</a>
				<a href="/users?tab=moderators" title="Our current community moderators">moderators</a>
			</div>
		</div>
			
		<div class="page-description" style="padding-bottom: 10px;">
	    <table style="width: 100%;">
	        <tbody>
	        	<tr>
	            	<td>
	                	Type to find users:<input id="userfilter" name="userfilter" class="userfilter" value="" style="margin-left: 10px;" type="text">
	            	</td>
	            	<td style="text-align: right;">
						<div id="tabs-interval" class="subtabs">
							<a href="/users?tab=reputation&amp;filter=all" title="2008-07-31 to today">all</a>
							<a href="/users?tab=reputation&amp;filter=year" title="2013-01-01 to today">year</a>
							<a href="/users?tab=reputation&amp;filter=quarter" title="2013-01-01 to today">quarter</a>
							<a href="/users?tab=reputation&amp;filter=month" title="2013-01-01 to today">month</a>
							<a class="youarehere" href="/users?tab=reputation&amp;filter=week" title="2013-01-27 to today">week</a>
						</div>
				    </td>
	        	</tr>
	    	</tbody>
    	</table>
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
										<!-- <img width="48" height="48" alt"" src="http://www.clker.com/cliparts/b/1/f/a/1195445301811339265dagobert83_female_user_icon.svg.med.png"> -->
										<g:img dir="images" file="avatar.jpg" width="48" height="48"/>
										
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
</div>

      
</div>
</div>
</div>
   
    <iframe id="global-auth-frame" style="display: none;" src="https://stackauth.com/auth/global/read?request=Osq2PB33KnIrIRmBZ9REldUbHX2JuCAwXdbuoloPeJDNQatcdUg9zg97eM7MYDmjJ%2F%2FOXoA%2FrvdJXKpyjj3AuQ%3D%3D&amp;nonce=FgYIUQAAAACjoFyl9T2nPg%3D%3D"></iframe></div>
    
    <noscript>
        <div id="noscript-warning">Stack Overflow works best with JavaScript enabled<img src="http://pixel.quantserve.com/pixel/p-c1rF4kxgLUzNc.gif" alt="" class="dno"></div>
    </noscript>
    <script type="text/javascript">var _gaq=_gaq||[];_gaq.push(['_setAccount','UA-5620270-1']);
_gaq.push(['_trackPageview']);
    var _qevents = _qevents || [];
    (function(){
        var s=document.getElementsByTagName('script')[0];
        var ga=document.createElement('script');
        ga.type='text/javascript';
        ga.async=true;
        ga.src='http://www.google-analytics.com/ga.js';
        s.parentNode.insertBefore(ga,s);
        var sc=document.createElement('script');
        sc.type='text/javascript';
        sc.async=true;
        sc.src='http://edge.quantserve.com/quant.js'; 
        s.parentNode.insertBefore(sc,s);
    })();
    </script>
    <script type="text/javascript">
        _qevents.push({ qacct: "p-c1rF4kxgLUzNc" });
    </script>    
    
</body>