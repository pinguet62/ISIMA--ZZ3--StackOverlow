/**
 * Vérifier la validité de la question
 * @returns true si la question est correcte, false sinon
 */
function validQuestionForm() {
	var err = true
	// Title
	if (document.getElementById("post-form").title.value == "") {
		document.getElementById("errorEmptyTitle").style.display = "block"
		err = false
	} else {
		document.getElementById("errorEmptyTitle").style.display = "none"
	}
	
	// Content
	if (document.getElementById("post-form").content.value == "") {
		document.getElementById("errorEmptyContent").style.display = "block"
		err = false
	} else {
		document.getElementById("errorEmptyContent").style.display = "none"
	}
	
	// Tags
	if (document.getElementById("post-form").strListTags.value == "") {
		document.getElementById("errorEmptyTags").style.display = "block"
		err = false
	} else {
		document.getElementById("errorEmptyTags").style.display = "none"
	}
	
	if (err == false) {
		document.getElementById("errorList1").style.display = "block"
		document.getElementById("errorList2").style.display = "block"
	} else {
		document.getElementById("errorList1").style.display = "none"
		document.getElementById("errorList2").style.display = "none"
	}
	
	return err
}