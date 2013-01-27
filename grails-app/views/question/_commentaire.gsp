<!-- Affiche un commentaire d'un message votable (question ou réponse) -->
<!-- @param commentaire Commentaire -->
<!-- @TODO Option si le commentaire vient de l'autheur de la question -->



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
				${commentaire.date}
			</span>
		</div>
	</td>
</tr>