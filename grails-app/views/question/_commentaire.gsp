<!-- Affiche un commentaire d'un message votable (question ou réponse) -->
<!-- @param commentaire Commentaire -->
<!-- @author Julien -->



<tr id="comment-${commentaire.messageVotable.id}" class="comment">
	<td></td>
	<td class="comment-text">
		<div>
			<span class="comment-copy">
				${commentaire.content}
			</span>
			 - 
			<a class="comment-user" href="/user/${commentaire.author.id}">
				${commentaire.author.name}
			</a>
			<span class="comment-date" dir="ltr">
				<g:stackDate date="${commentaire.date}"/>
			</span>
		</div>
	</td>
</tr>