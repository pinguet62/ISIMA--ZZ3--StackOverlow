<!-- Afficher la cellule de vote + ou - -->
<!-- @param message Message votable -->
<!-- @author Julien -->



<g:set var="user" value="${fr.isima.stackoverlow.UserController.getUser()}"/>
<g:set var="vService" value="${new fr.isima.stackoverlow.VoteService()}"/>



<div class="vote">
	<g:if test="${user != null  &&  vService.votedUp(message, user)}">
		<a class="vote-up-off vote-up-on" title="This answer is useful">up vote</a>
	</g:if>
	<g:else>
		<a class="vote-up-off" title="This answer is useful (click again to undo)" href="/StackOverlow/vote/${message.id}/up">up vote</a>
	</g:else>
	
	<span class="vote-count-post ">
		${vService.getMark(message)}
	</span>
	
	<g:if test="${user != null  &&  vService.votedDown(message, user)}">
		<a class="vote-down-off vote-down-on" title="This answer is not useful">down vote</a>
	</g:if>
	<g:else>
		<a class="vote-down-off" title="This answer is not useful (click again to undo)" href="/StackOverlow/vote/${message.id}/down">down vote</a>
	</g:else>
</div>