
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
		<div id="mainbar-full" class="user-show-new">
			<div class="subheader">
    			<h1 id="user-displayname">${user.name}</h1>
    		</div>
			<div id="user-info-container">
    			<div id="large-user-info" class="user-header" style="">
        			<div class="user-header-left">
            			<div class="gravatar">
                			
                				<div class="">
                					<g:if test="${user.avatarUrl.equals('')}">
										<g:img dir="images/avatar" file="default.jpg" width="128" height="128"/>
									</g:if>
									<g:elseif test="${user.avatarUrl.substring(0, 4).equals('http')}">
										<img src="${user.avatarUrl}" alt="" width="128" height="128">
									</g:elseif>
									<g:else>
										<g:img dir="" file="${user.avatarUrl}" width="128" height="128"/>
									</g:else>
                				</div>
                		
                			<div class="reputation">
                    		<span>
                            	${reput}
                    		</span>
                    		reputation
                		</div>
            		</div>
			</div>
        	<br class="clear">
    	</div>
	</div>

    <div class="subheader user-tabs-nav">
        <div id="tabs">
            <a class="youarehere" href="/users/2017180/kendo-ja?tab=summary" title="this user's overall summary">
                summary
            </a>
            <a href="/users/2017180/kendo-ja?tab=answers" title="answers this user has provided">
                answers
            </a>
            <a href="/users/2017180/kendo-ja?tab=questions" title="questions this user has asked">
     			questions
            </a>
            <a href="/users/2017180/kendo-ja?tab=tags" title="tags this user has posts in">
                tags
            </a>
            <a href="/users/2017180/kendo-ja?tab=reputation" title="reputation this user has earned">
                reputation
            </a>
            <a href="/users/2017180/kendo-ja?tab=activity" title="this user's recent activity">
                activity
            </a>
        </div>
    </div>
<div>
<div id="user-panel-questions" class="user-panel user-panel-left">
    <div class="subheader">
        <h1>
        	<a href="/users/2017180/kendo-ja?tab=questions">
    			<span class="count">${lstQ.size() }</span> Questions
			</a>
		</h1>
    </div>
    <div class="user-panel-content">
     <g:if test="${lstQ.size() != 0}">
        <table class="user-questions lines">
            <tbody>
	           
	            <g:each var="q" in="${lstQ4}" status="cpt">
	                <tr>
	                    
	                    <td class="question-hyperlink" title="${q.title }"><a href="/question/${q.id }" class="question-hyperlink">${q.title }</a></td>
	                </tr>
	                </g:each>
	           
            </tbody>
        </table>
        </g:if>
	    <g:else>
	      	<div class="empty">This user has not post any questions</div>
		</g:else>
    </div>
    <div class="user-panel-footer">
    </div>
</div>
<div id="user-panel-reputation" class="user-panel">
    <div class="subheader">
        <h1>
        	<a href="/users/2017180/kendo-ja?tab=reputation">
    			<span class="count">${reput}</span> Reputation
			</a>
		</h1>
    </div>
    <div class="user-panel-content">
       
      <g:if test="${lstVR.size() != 0}">
        <table class="user-rep lines">
            <tbody>
	            <g:each var="v" in="${lstVR4}" status="cpt">
	                <tr>
	                	<g:if test="${v.mark == +1 }">
	                    	<td class="rep-amount count-cell"><span class="rep-up">+${v.mark }</span></td>
	                    </g:if>
	                    <g:else>
	                    	<td class="rep-amount count-cell"><span class="rep-down ">${v.mark }</span></td>
	                    </g:else>
	                    <td>
	                    	<g:if test="${v.messageVotable.hasProperty("title") }">
	                    		<a class="answer-hyperlink " href="/question/${v.messageVotable.id }">${v.messageVotable.title }</a>
	                    	</g:if>
	                    	<g:else>
	                    		<a class="answer-hyperlink " href="/question/${v.messageVotable.question.id }">${v.messageVotable.question.title }</a>
	                    	</g:else>
	                    </td>
	                </tr>
	           </g:each>
            </tbody>
        </table>
        </g:if>
	    <g:else>
	      	<div class="empty">This user has no reputation evolution</div>
		</g:else>

    </div>
    <div class="user-panel-footer">
    </div>
</div>
<div id="user-panel-answers" class="user-panel user-panel-left">
    <div class="subheader">
        <h1>
        	<a href="/users/2017180/kendo-ja?tab=answers">
   				<span class="count">${lstR.size() }</span> Answers
			</a>
		</h1>
    </div>
   <div class="user-panel-content">
        
        <table class="user-answers lines">
            <tbody>
           		<g:if test="${lstR.size() != 0}">
	            <g:each var="r" in="${lstR4}" status="cpt">
	                <tr>
	                    <td title="${r.question.title }" class="answer-hyperlink"><a class="answer-hyperlink " href="/question/${r.question.id }">${r.question.title }</a></td>
	                </tr>
	                </g:each>
	            </g:if>
	            <g:else>
	            	<div class="empty">This user has not answered any questions</div>
	            </g:else>
            </tbody>
        </table>

    </div>
    <div class="user-panel-footer">
    </div>
</div>

<div id="user-panel-tags" class="user-panel">
    <div class="subheader">
        <h1>
        	<a href="/users/2017180/kendo-ja?tab=tags">
    			<span class="count">${nbtag }</span> Tags
			</a>
		</h1>
    </div>

    <div class="user-panel-content">
        <table class="user-tags">
            <tbody>
                <tr>                
                    <g:each var="cle" in="${lstT4.keySet()}" status="cptcle">
	                    <g:each var="val" in="${lstT4.get(cle)}" status="cpt">
		                    <g:if test="${cpt%4 == 0}">
									</tr><tr>
							</g:if>
		                    <td>
		                    	<div class="answer-votes" title="" onclick="window.location.href='/tag/${val.id}'">${cle }</div>
		                    	<a href="/tag/${val.id}" class="post-tag" title="">${val.name }</a>
		                    </td>                                                                                              
	                    </g:each>
                    </g:each>
                    </tr>
                </tr>               
            </tbody>
        </table>

    </div>

    <div class="user-panel-footer">

    </div>
</div>


<div id="user-panel-votes" class="user-panel user-panel-left">
    <div class="subheader">
        <h1>
		    <span class="count">${voteUp+voteDown }</span> Votes Cast
		</h1>
    </div>
    <div class="user-panel-content">
       <table class="votes-cast-stats">
        <thead>
            <tr>
                <th colspan="2">all time</th>
                <th class="spacer">&nbsp;</th>
                    <th colspan="2">by type</th> 
                    </tr>
        </thead>
        <tbody><tr>
            <td>${voteUp}</td> 
            <td class="desc">up</td>
            <td></td>
                <td>${questions}</td>
                <td class="desc">question</td>
                <td></td>
                            
                <td></td>
                            
                <td></td>
               </tr>
        <tr>
            <td>${voteDown}</td>
            <td class="desc">down</td>
            <td></td>
                <td>${responses}</td>
                <td class="desc">answer</td>
                <td></td>
        </tr>
    </tbody></table>
    </div>
    <div class="user-panel-footer">
    </div>
</div>
</div>
</div>
</div>
</div>

    <g:render template="/footer"/>
</body>
        