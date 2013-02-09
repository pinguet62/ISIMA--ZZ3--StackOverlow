<!-- Afficher la cellule de vote + ou - -->
<!-- @param message Message votable -->
<!-- @author Julien -->



<div class="vote">
	<a class="vote-up-off" title="This answer is useful (click again to undo)">up vote</a>
	<span class="vote-count-post ">
		${new fr.isima.stackoverlow.VoteService().getMark(message)}
	</span>
	<a class="vote-down-off" title="This answer is not useful (click again to undo)">down vote</a>
</div>