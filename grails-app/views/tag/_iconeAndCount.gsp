<!-- Afficher l'icone d'un tag et son nombre d'utilisations -->
<!-- @param tag Tag -->



<g:tagIcone tag="${tag}"/>
<span class="item-multiplier">
	<span class="item-multiplier-x"> x </span>
	<span class="item-multiplier-count">
		${fr.isima.stackoverlow.Tag.findAllByName(tag.name).size()}
	</span>
</span>