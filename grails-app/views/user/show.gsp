
<head>
    <title>Users - Stack Overflow</title>
   
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
    			<h1 id="user-displayname">${usersel.name}</h1>
    		</div>
			<div id="user-info-container">
    			<div id="large-user-info" class="user-header" style="">
        			<div class="user-header-left">
            			<div class="gravatar">
                			
                				<div class="">
                					<g:if test="${!usersel.avatarUrl}">
											<g:img dir="images/avatar" file="default.jpg" width="128" height="128"/>
										</g:if>
										<g:elseif test="${usersel.avatarUrl.substring(0, 4).equals('http')}">
											<img src="${usersel.avatarUrl}" alt="" width="128" height="128">
										</g:elseif>
										<g:else>
											<g:img dir="" file="${usersel.avatarUrl}" width="128" height="128"/>
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
        <g:if test="${param=='sum' }">
            <a class="youarehere" href="${usersel.id }?tab=sum" title="this user's overall summary">summary</a>
        </g:if>
        <g:else>
        	<a href="${usersel.id }?tab=sum" title="this user's overall summary">summary</a>
        </g:else>
        
        <g:if test="${param=='answ' }">
            <a class="youarehere" href="${usersel.id }?tab=answ" title="answers this user has provided">answers</a>
        </g:if>
        <g:else>
            <a href="${usersel.id }?tab=answ" title="answers this user has provided">answers</a>
        </g:else>
           
           <g:if test="${param=='quest' }">
            <a class="youarehere" href="${usersel.id }?tab=quest" title="questions this user has asked">questions</a>
             </g:if>
        <g:else>
            <a href="${usersel.id }?tab=quest" title="questions this user has asked">questions</a>
            </g:else>
            <g:if test="${param=='tags' }">
            <a class="youarehere" href="${usersel.id }?tab=tags" title="tags this user has posts in">tags</a>
             </g:if>
        <g:else>
         <a href="${usersel.id }?tab=tags" title="tags this user has posts in">tags</a>
        </g:else>
            <g:if test="${param=='reput' }">
            <a class="youarehere" href="${usersel.id }?tab=reput" title="reputation this user has earned">reputation</a>
             </g:if>
        <g:else>
        <a href="${usersel.id }?tab=reput" title="reputation this user has earned">reputation</a>
        </g:else>
            <g:if test="${param=='act' }">
            <a class="youarehere" href="${usersel.id }?tab=act" title="this user's recent activity">activity</a>
             </g:if>
        <g:else>
        <a href="${usersel.id }?tab=act" title="this user's recent activity">activity</a>
        </g:else>
        </div>
    </div>
<div>

 <g:if test="${param=='sum' }">
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
        	<a href="${usersel.id }?tab=answ">
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
	                	<td class="count-cell"><div class="mini-counts answered-accepted">${new fr.isima.stackoverlow.VoteService().getNbVoteStatic(r) }</div></td>
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
    </div>
    </g:if>
    
    
    <g:if test="${param=='answ' }">
    <div class="user-tab" id="user-tab-answers">
    	<div class="subheader user-full-tab-header">
        	<h1>
    			<span class="count">${lstR.size() }</span> Answers
			</h1>    
    	</div>
		<div class="user-tab-content">
        	<div class="user-answers">
				<g:each var="rep" in="${lstR}" status="cpt">
					<div class="answer-summary">
						<div title="total number of votes for this answer, which was accepted as the correct answer by the question owner" class="answer-votes answered-accepted            large" onclick="window.location.href='/questions/11185321/when-should-null-values-of-boolean-be-used/11185400#11185400'">
	        				${new fr.isima.stackoverlow.VoteService().getNbVoteStatic(rep) }
	    				</div>
						<div class="answer-link">
							<a class="answer-hyperlink " href="/question/${rep.question.id}">
								${rep.question.title }
							</a>
						</div>
					</div>
				</g:each>
        	</div>
    	</div>

	</div>
    </g:if>
    
    
    <g:if test="${param=='quest' }">
	    <div class="user-tab" id="user-tab-questions">
	    	<div class="subheader user-full-tab-header">
	        	<h1>
	    			<span class="count">${lstQ.size()}</span> Questions
	    		</h1>    
	    </div>
	
	    <div class="user-tab-content">        
	        <div class="user-questions">
				
				<g:each var="quest" in="${lstQ}" status="cpt">
					<div id="question-summary-${quest.id }" class="question-summary narrow">
			    	<div class="question-counts cp">
			        <div class="votes">
			            <div class="mini-counts">${new fr.isima.stackoverlow.VoteService().getMark(quest) }</div>
			            <div>votes</div>
			        </div>
			        
			        <div title="one of the answers was accepted as the correct answer" class="status answered-accepted">
			            <div class="mini-counts">${new fr.isima.stackoverlow.ResponseService().getNbReponse(quest)}</div>
			            <div>answers</div>
			        </div>
			        
			      
			    </div>
			    <div class="summary">
			        <h3>
			        	<a title="" class="question-hyperlink" href="/question/show/${quest.id }">
			        		${quest.title }
			        	</a>
			        </h3>
			        
			        <g:each var="tag" in="${quest.tags}" status="cptTag">
				        <div class="tags t-java t-multithreading t-immutability">
				            <a rel="tag" title="show questions tagged '${tag.name }'" class="post-tag" href="/question/tagged/${tag.name }">
				            	${tag.name}
				            </a> 
				        </div>
			        </g:each>
			        <div class="started">
			            <a class="started-link" href="/question/${quest.id }">
			            	<span class="relativetime" title="${quest.date.getDateString()+ " " +quest.date.getTimeString() }">
			            		${quest.date.getDateString()+ " " +quest.date.getTimeString() } 
			            	</span>
			            </a>
			           
			        </div>
			    </div>
			    </div>
		    </g:each>
		    
		</div>
		</div>
		</div>
		
    </g:if>
    
    <g:if test="${param=='tags' }">
    	<div class="user-tab" id="user-tab-tags">
    		<div class="subheader user-full-tab-header">
        		<h1>
    				<span class="count">
    					${nbtag}
    				</span> Tags
				</h1>    
        		<div class="subtabs user-tab-sorts">
        	</div>
    	</div>

    	<div class="user-tab-content">
	        <table class="user-tags">
            	<tbody>
                	<tr>                
	                    <g:each var="cle" in="${lstT.keySet()}" status="cptcle">
		                    <g:each var="val" in="${lstT.get(cle)}" status="cpt">
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
            	</tbody>
        	</table>
    	</div>
		</div>
    </g:if>
    
    
    <g:if test="${param=='reput' }">
	   <div class="user-tab" id="user-tab-reputation">
	    	<div class="subheader user-full-tab-header">
		        <h1>
		    		<span class="count">${lstVR.size()}</span> Reputation
				</h1>
			</div>

	    	<div class="user-tab-content">
				<div class="user-rep-full">
	    			<div id="stats">
	        			<div class="ajax-paging-container" id="rep-page-container">
	            			<table class="rep-table">
	                			<tbody>
	                   
	                    			<tr class="loaded-body">
	                        			<td style="height: 0px; padding: 0px;" class="body-container body-loaded" colspan="2">
	                        				<div style="display: block;">
												<div class="rep-breakdown">
												
													<table class="tbl-reputation">
			    										<tbody>
			    											<g:each var="v" in="${lstVR}" status="cpt">
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
		           
		        								</div>
	    									</div>
	    									<!-- </td>  volontairement masquer 	</tr></table> -->
										</div>
									</div>
								</div>
    </g:if>
    
    
    <g:if test="${param=='act' }">
    	
    	<g:each var="cle" in="${lstA.keySet()}" status="cptcle">
		    ${cle }
		    <br>
		    <g:each var="val" in="${lstA.get(cle)}" status="cpt">
    			<g:if test="${val.hasProperty("title")}">
    				Post a new question: ${val.title}
    			</g:if>
    			
    			<g:if test="${val.hasProperty("question")}">
    				Post a response in question: ${val.question.title}
    			</g:if>
    			
    			<g:if test="${val.hasProperty("messageVotable")}">
	    			<g:if test="${val.messageVotable.hasProperty("title")}">
	    				comment the question: ${val.messageVotable.title}
	    			</g:if>
	    			
	    			<g:if test="${val.messageVotable.hasProperty("question")}">
	    				comment a response in question: ${val.messageVotable.question.title}
	    			</g:if>
	    		</g:if>
    			
    			
    			<br>
			</g:each>
			<br>
		</g:each>
    	
    	
    </g:if>
    
    
    <div class="user-panel-footer">
    </div>
</div>
</div>
</div>
</div>

    <g:render template="/footer"/>
</body>
        