<!-- Afficher l'icone d'un tag et son nombre d'utilisations -->
<!-- @param tag Tag -->



<a class="post-tag" rel="tag" title="show questions tagged '${tag.name}'" href="/tag/${tag.id}">
	${tag.name}
</a>
<span class="item-multiplier">
	<span class="item-multiplier-x"> x </span>
	<span class="item-multiplier-count">
		${fr.isima.stackoverlow.Tag.findAllByName(tag.name).size()}
	</span>
</span>