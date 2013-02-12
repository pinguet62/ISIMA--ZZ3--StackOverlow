/**
 * Afficher le formulaire du commentaire
 * @param id Id du message
 */
function showCommentaireForm(id) {
	document.getElementById("comment-form-"+id).style.display = "block"
}



/**
 * Valider le commentaire
 * @param id Id du message
 * @returns {Boolean}
 */
function validCommentaireForm(id) {
	if (document.getElementById("comment-form-"+id).getElementsByTagName("textarea")[0].value == "") {
		alert("Veuillez saisir un commentaire")
		return false
	}
	return true
}