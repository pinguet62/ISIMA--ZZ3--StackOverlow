package fr.isima.stackoverlow

class QuestionController {

    def show() {
		println params.id
		render(view: "/question/index")
	}
	
}
