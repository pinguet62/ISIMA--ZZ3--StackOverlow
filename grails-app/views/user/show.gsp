
<head>
    <title><g:message code="user.all.title" /> - Stack Overflow</title>
   
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
                    		<g:message code="user.show.reputation" />
                		</div>
            		</div>
            		<div class="data">
			            <table>
			                <tbody>
			                    <tr>
			                        <th></th>
			                        <td><h3><g:message code="user.show.isAdmin" /></h3> ${usersel.admin }</td>
			                    
			                    </tr>
			                    <tr>
			                        <th></th>
			                        <td><h3><g:message code="user.show.email" /></h3> ${usersel.mail }</td>
			                      
			                    </tr>
			                </tbody>
			                <tbody>
			                    <tr>
			                        <th></th>
			                        <g:set var="userConnect" value="${fr.isima.stackoverlow.UserController.getUser()}"/>
			                        	<g:if test="${userConnect != null }">
			                       			 <g:if test="${usersel.id == userConnect.id || userConnect.admin==true}">
			                        			<td><a href="/StackOverlow/user/editUser?id=${usersel.id }" title="${g.message(code: "user.show.edit")}">
			                        			<g:img dir="" file="edit.png" width="30" height="30"/>
			                        			</a></td>
			                        		</g:if>
			                        	</g:if>
			                        		
			                        <td></td>
			                    </tr>
			
			               </tbody>
			               			                <tbody>
			                    <tr>
			                        <th></th>
			                        <g:set var="userConnect" value="${fr.isima.stackoverlow.UserController.getUser()}"/>
			                        	<g:if test="${userConnect != null }">
			                       			  <g:if test="${usersel.id == userConnect.id || userConnect.admin==true}">
			                        			<td><a onclick="return(confirm('${g.message(code: "user.delete.confirm")}'));" href="/StackOverlow/user/deleteUser?id=${usersel.id }" title="${g.message(code: "user.show.delete")}">
			                        			<g:img dir="" file="delete.jpg" width="30" height="30"/>
			                        			</a></td>
			                        		</g:if>
			                        	</g:if>
			                        		
			                        <td></td>
			                    </tr>
			
			               </tbody>
			            </table>
			            </div>
						</div>
				<div >
				<h3><g:message code="user.show.award" /></h3>
				
					<g:if test="${lstQ.size() >0 && lstQ.size()<=10 }">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="curious_3.jpg" title="${g.message(code: "user.show.award.curious3")}" width="40" height="50"/></a>
					</g:if>
					<g:if test="${lstQ.size() >10  && lstQ.size()<=50}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="curious_2.jpg" title="${g.message(code: "user.show.award.curious2")}" width="40" height="50"/></a>
					</g:if>
					<g:if test="${lstQ.size() >50 }">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="curious_1.jpg" title="${g.message(code: "user.show.award.curious1")}" width="40" height="50"/></a>
					</g:if>
					
					<g:if test="${lstR.size() >0 && lstR.size()<=10}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="helper_3.jpg" title="${g.message(code: "user.show.award.helper3")}" width="40" height="50"/></a>
					</g:if>
					<g:if test="${lstR.size() >10 && lstR.size()<=50}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="helper_2.jpg" title="${g.message(code: "user.show.award.helper2")}" width="40" height="50"/></a>
					</g:if>
					<g:if test="${lstR.size() >50 }">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="helper_1.jpg" title="${g.message(code: "user.show.award.helper1")}" width="40" height="50"/></a>
					</g:if>
					
					
					<g:if test="${nbtag >0 && nbtag <= 10}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="tagger_3.jpg" title="${g.message(code: "user.show.award.tagger3")}" width="50" height="50"/></a>
					</g:if>
					
					<g:if test="${nbtag >10 && nbtag <= 50}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="tagger_2.jpg" title="${g.message(code: "user.show.award.tagger2")}" width="50" height="50"/></a>
					</g:if>
					
					<g:if test="${nbtag >50 }">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="tagger_1.jpg" title="${g.message(code: "user.show.award.tagger1")}" width="50" height="50"/></a>
					</g:if>
					
					
					<g:if test="${voteUp+voteDown >0 && voteUp+voteDown<=10 }">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="goodcitizen_3.jpg" title="${g.message(code: "user.show.award.goodcitizen3")}" width="50" height="50"/></a>
					</g:if>
					<g:if test="${voteUp+voteDown >10 && voteUp+voteDown<=50}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="goodcitizen_2.jpg" title="${g.message(code: "user.show.award.goodcitizen2")}" width="50" height="50"/></a>
					</g:if>
					<g:if test="${voteUp+voteDown >50 }">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="goodcitizen_1.jpg" title="${g.message(code: "user.show.award.goodcitizen1")}" width="50" height="50"/></a>
					</g:if>
					
					<br><br><br>
					<g:if test="${reput > 0}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="1.jpg" title="${g.message(code: "user.show.award.v1")}" width="40" height="40"/></a>
					</g:if>
					<g:if test="${reput > 20}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="2.jpg" title="${g.message(code: "user.show.award.v2")}" width="40" height="40"/></a>
					</g:if>
					<g:if test="${reput > 50}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="3.jpg" title="${g.message(code: "user.show.award.v3")}" width="40" height="40"/></a>
					</g:if>
					<g:if test="${reput > 100}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="4.jpg" title="${g.message(code: "user.show.award.v4")}" width="40" height="40"/></a>
					</g:if>
					<g:if test="${reput > 500}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="5.jpg" title="${g.message(code: "user.show.award.v5")}" width="40" height="40"/></a>
					</g:if>
					<g:if test="${reput > 1000}">
						<a href="/StackOverlow/user/rules"><g:img dir="images/trophe" file="6.jpg" title="${g.message(code: "user.show.award.v6")}" width="40" height="40"/></a>
					</g:if>
					
       			 </div>

        	<br class="clear">
    	</div>
	</div>

    <div class="subheader user-tabs-nav">
        <div id="tabs">
        <g:if test="${param=='sum' }">
            <a class="youarehere" href="${usersel.id }?tab=sum" title="this user's overall summary"><g:message code="user.show.summary" /></a>
        </g:if>
        <g:else>
        	<a href="${usersel.id }?tab=sum" title="this user's overall summary"><g:message code="user.show.summary" /></a>
        </g:else>
        
        <g:if test="${param=='answ' }">
            <a class="youarehere" href="${usersel.id }?tab=answ" title="answers this user has provided"><g:message code="user.show.answers" /></a>
        </g:if>
        <g:else>
            <a href="${usersel.id }?tab=answ" title="answers this user has provided"><g:message code="user.show.answers" /></a>
        </g:else>
           
           <g:if test="${param=='quest' }">
            <a class="youarehere" href="${usersel.id }?tab=quest" title="questions this user has asked"><g:message code="user.show.questions" /></a>
             </g:if>
        <g:else>
            <a href="${usersel.id }?tab=quest" title="questions this user has asked"><g:message code="user.show.questions" /></a>
            </g:else>
            <g:if test="${param=='tags' }">
            <a class="youarehere" href="${usersel.id }?tab=tags" title="tags this user has posts in"><g:message code="user.show.tags" /></a>
             </g:if>
        <g:else>
         <a href="${usersel.id }?tab=tags" title="tags this user has posts in"><g:message code="user.show.tags" /></a>
        </g:else>
            <g:if test="${param=='reput' }">
            <a class="youarehere" href="${usersel.id }?tab=reput" title="reputation this user has earned"><g:message code="user.show.reputation" /></a>
             </g:if>
        <g:else>
        <a href="${usersel.id }?tab=reput" title="reputation this user has earned"><g:message code="user.show.reputation" /></a>
        </g:else>
            <g:if test="${param=='act' }">
            <a class="youarehere" href="${usersel.id }?tab=act" title="this user's recent activity"><g:message code="user.show.activity" /></a>
             </g:if>
        <g:else>
        <a href="${usersel.id }?tab=act" title="this user's recent activity"><g:message code="user.show.activity" /></a>
        </g:else>
        </div>
    </div>
<div>

 <g:if test="${param=='sum' }">
<div id="user-panel-questions" class="user-panel user-panel-left">
    <div class="subheader">
        <h1>
        	<a href="/user/${usersel.id }?tab=questions">
    			<span class="count">${lstQ.size() }</span> <g:message code="user.show.questions" />
			</a>
		</h1>
    </div>
    <div class="user-panel-content">
     <g:if test="${lstQ.size() != 0}">
        <table class="user-questions lines">
            <tbody>
	           
	            <g:each var="q" in="${lstQ4}" status="cpt">
	                <tr>
	                    
	                    <td class="question-hyperlink" title="${q.title }"><a href="/StackOverlow/question/${q.id }" class="question-hyperlink">${q.title }</a></td>
	                </tr>
	                </g:each>
	           
            </tbody>
        </table>
        </g:if>
	    <g:else>
	      	<div class="empty"><g:message code="user.show.noquestion" /> </div>
		</g:else>
    </div>
    <div class="user-panel-footer">
    </div>
</div>
<div id="user-panel-reputation" class="user-panel">
    <div class="subheader">
        <h1>
        	<a href="/user/${usersel.id }">
    			<span class="count">${reput}</span> <g:message code="user.show.reputation" />
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
	                    		<a class="answer-hyperlink " href="/StackOverlow/question/${v.messageVotable.id }">${v.messageVotable.title }</a>
	                    	</g:if>
	                    	<g:else>
	                    		<a class="answer-hyperlink " href="/StackOverlow/question/${v.messageVotable.question.id }">${v.messageVotable.question.title }</a>
	                    	</g:else>
	                    </td>
	                </tr>
	           </g:each>
            </tbody>
        </table>
        </g:if>
	    <g:else>
	      	<div class="empty"><g:message code="user.show.noreputation" /></div>
		</g:else>

    </div>
    <div class="user-panel-footer">
    </div>
</div>
<div id="user-panel-answers" class="user-panel user-panel-left">
    <div class="subheader">
        <h1>
        	<a href="${usersel.id }?tab=answ">
   				<span class="count">${lstR.size() }</span> <g:message code="user.show.answers" />
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
	                    <td title="${r.question.title }" class="answer-hyperlink"><a class="answer-hyperlink " href="/StackOverlow/question/${r.question.id }">${r.question.title }</a></td>
	                </tr>
	                </g:each>
	            </g:if>
	            <g:else>
	            	<div class="empty"><g:message code="user.show.noanswer" /></div>
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
        	<a href="/user/${usersel.id }?tab=tags">
    			<span class="count">${nbtag }</span> <g:message code="user.show.tags" />
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
		                    	<div class="answer-votes" title="" onclick="window.location.href='/StackOverlow/tag/${val.id}'">${cle }</div>
		                    	<a href="/StackOverlow/tag/${val.id}" class="post-tag" title="">${val.name }</a>
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
		    <span class="count">${voteUp+voteDown }</span> <g:message code="user.show.votecast" />
		</h1>
    </div>
    <div class="user-panel-content">
       <table class="votes-cast-stats">
        <thead>
            <tr>
                <th colspan="2"><g:message code="user.show.alltime" /></th>
                <th class="spacer">&nbsp;</th>
                    <th colspan="2"><g:message code="user.show.bytype" /></th> 
                    </tr>
        </thead>
        <tbody><tr>
            <td>${voteUp}</td> 
            <td class="desc"><g:message code="user.show.up" /></td>
            <td></td>
                <td>${questions}</td>
                <td class="desc"><g:message code="user.show.question" /></td>
                <td></td>
                            
                <td></td>
                            
                <td></td>
               </tr>
        <tr>
            <td>${voteDown}</td>
            <td class="desc"><g:message code="user.show.down" /></td>
            <td></td>
                <td>${responses}</td>
                <td class="desc"><g:message code="user.show.answer" /></td>
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
    			<span class="count">${lstR.size() }</span> <g:message code="user.show.answers" />
			</h1>    
    	</div>
		<div class="user-tab-content">
        	<div class="user-answers">
        	 <g:if test="${lstR.size() == 0}">
        	 	<div class="empty"><g:message code="user.show.noanswer" /></div>
        	 </g:if>
				<g:each var="rep" in="${lstR}" status="cpt">
					<div class="answer-summary">
						<div title="total number of votes for this answer, which was accepted as the correct answer by the question owner" class="answer-votes answered-accepted            large" onclick="window.location.href='/StackOverlow/question/???'">
	        				${new fr.isima.stackoverlow.VoteService().getNbVoteStatic(rep) }
	    				</div>
						<div class="answer-link">
							<a class="answer-hyperlink " href="/StackOverlow/question/${rep.question.id}">
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
	    			<span class="count">${lstQ.size()}</span> <g:message code="user.show.questions" />
	    		</h1>    
	    </div>
	
	    <div class="user-tab-content">        
	        <div class="user-questions">
			 <g:if test="${lstQ.size() == 0}">
        	 	<div class="empty"><g:message code="user.show.noquestion" /></div>
        	 </g:if>
				<g:each var="quest" in="${lstQ}" status="cpt">
					<div id="question-summary-${quest.id }" class="question-summary narrow">
			    	<div class="question-counts cp">
			        <div class="votes">
			            <div class="mini-counts">${new fr.isima.stackoverlow.VoteService().getMark(quest) }</div>
			            <div><g:message code="user.show.votes" /></div>
			        </div>
			        
			        <div title="one of the answers was accepted as the correct answer" class="status answered-accepted">
			            <div class="mini-counts">${new fr.isima.stackoverlow.ResponseService().getNbReponse(quest)}</div>
			            <div><g:message code="user.show.answers" /></div>
			        </div>
			        
			      
			    </div>
			    <div class="summary">
			        <h3>
			        	<a title="" class="question-hyperlink" href="/StackOverlow/question/show/${quest.id }">
			        		${quest.title }
			        	</a>
			        </h3>
			        
			        <g:each var="tag" in="${quest.tags}" status="cptTag">
				        <div class="tags t-java t-multithreading t-immutability">
				            <a rel="tag" title="show questions tagged '${tag.name }'" class="post-tag" href="/StackOverlow/question/tagged/${tag.name }">
				            	${tag.name}
				            </a> 
				        </div>
			        </g:each>
			        <div class="started">
			            <a class="started-link" href="/StackOverlow/question/${quest.id }">
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
                	    <g:if test="${lstT.keySet().size() == 0}">
        	 				<div class="empty"><g:message code="user.show.notag" /></div>
        				 </g:if>            
	                    <g:each var="cle" in="${lstT.keySet()}" status="cptcle">
		                    <g:each var="val" in="${lstT.get(cle)}" status="cpt">
			                    <g:if test="${cpt%4 == 0}">
										</tr><tr>
								</g:if>
			                    <td>
			                    	<div class="answer-votes" title="" onclick="window.location.href='/StackOverlow/tag/${val.id}'">${cle }</div>
			                    	<a href="/StackOverlow/tag/${val.id}" class="post-tag" title="">${val.name }</a>
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
		    		<span class="count">${lstVR.size()}</span> <g:message code="user.show.reputation" />
				</h1>
			</div>
				<g:if test="${lstVR.size() == 0}">
        	 				<div class="empty"><g:message code="user.show.noreputation" /></div>
        				 </g:if>   
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
												                    		<a class="answer-hyperlink " href="/StackOverlow/question/${v.messageVotable.id }">${v.messageVotable.title }</a>
												                    	</g:if>
												                    	<g:else>
												                    		<a class="answer-hyperlink " href="/StackOverlow/question/${v.messageVotable.question.id }">${v.messageVotable.question.title }</a>
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
    	
    	
    	
    	
    	<div class="user-tab" id="user-tab-reputation">
	    	<div class="subheader user-full-tab-header">
		        <h1>
		    		<span class="count">${lstA.keySet().size()}</span>  <g:message code="user.show.dayofactivity" />
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
			    										<g:if test="${lstA.keySet().size() == 0}">
        	 												<div class="empty"><g:message code="user.show.noactivity" /></div>
        				 								</g:if>   
			    											<g:each var="cle" in="${lstA.keySet()}" status="cptcle">
			    											<g:each var="val" in="${lstA.get(cle)}" status="cpt">
			    											
												                <tr>
												                    <td class="rep-time" title="${cle }">${cle }</td>
												                    
																	
																	
																	
																	<g:if test="${val.hasProperty("title")}">
													    				<td class="rep-desc"><g:message code="user.show.postaquestion" /></td>
													    				<td class="rep-link"><a class="answer-hyperlink " href="/StackOverlow/question/${val.id}">${val.title}</a></td>
													    			</g:if>
													    			
													    			<g:if test="${val.hasProperty("question")}">
													    				<td class="rep-desc"><g:message code="user.show.postananswer" /></td>
													    				<td class="rep-link"><a class="answer-hyperlink " href="/StackOverlow/question/${val.question.id}">${val.question.title}</a></td>
													    			</g:if>
													    			
													    			<g:if test="${val.hasProperty("messageVotable")}">
														    			<g:if test="${val.messageVotable.hasProperty("title")}">
														    				<td class="rep-desc"><g:message code="user.show.commentaquestion" /></td>
														    				<td class="rep-link"><a class="answer-hyperlink " href="/StackOverlow/question/${val.messageVotable.id}">${val.messageVotable.title}</a></td>
														    			</g:if>
														    			
														    			<g:if test="${val.messageVotable.hasProperty("question")}">
														    				<td class="rep-desc"><g:message code="user.show.commentananswer" /></td>
														    				<td class="rep-link"><a class="answer-hyperlink " href="/StackOverlow/question/${val.messageVotable.question.id}">${val.messageVotable.question.title}</a></td>
														    			</g:if>
														    		</g:if>
																	
																	
																	
																	
												                    
												                    
												                </tr>
												        	<br>
															</g:each>
		
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
    
    
    <div class="user-panel-footer">
    </div>
</div>
</div>
</div>
</div>

    <g:render template="/footer"/>
</body>
        