/**
 * V�rifier la validit� de la r�ponse
 * @returns true si la r�ponse est correcte, false sinon
 */
function validResponseForm() {
	if (document.getElementById("post-form").content.value == "") {
		document.getElementById("errorList1").style.display = "block"
		document.getElementById("errorList2").style.display = "block"
		document.getElementById("errorEmptyContent").style.display = "block"
		return false
	}
	return true
}


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
 * @returns true si le commentaire est correct, false sinon
 */
function validCommentaireForm(id) {
	if (document.getElementById("comment-form-"+id).content.value == "") {
		alert("Veuillez saisir un commentaire")
		return false
	}
	return true
}