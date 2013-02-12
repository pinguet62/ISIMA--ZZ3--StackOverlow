/**
 * Vérifier la validité de la réponse
 * @returns true si la réponse est correcte, false sinon
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