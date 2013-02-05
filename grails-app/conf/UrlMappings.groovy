import javax.swing.SpringLayout.Constraints;

class UrlMappings {

	static mappings = {
		// Défaut
		"/$controller/$action?/$id?" {
			constraints {
			}
		}
		
		
		// Question
		// - afficher
		"/question?"(controller: "question", action: "all")
		"/question/$id"(controller: "question", action: "show") {
			constraints {
				id matches: /[0-9]+/
			}
		}
		// - répondre
		"/question/$id/answer/submit"(controller: "question", action: "answer_submit") {
			constraints {
				id matches: /[0-9]+/
			}
		}
		// - créer
		"/question/ask"(controller: "question", action: "ask")
		"/question/ask/submit"(controller: "question", action: "ask_submit")
		// - éditer
		"/question/$id/edit"(controller: "question", action: "edit") {
			constraints {
				id matches: /[0-9]+/
			}
		}
		"/question/$id/edit/submit"(controller: "question", action: "edit_submit") {
			constraints {
				id matches: /[0-9]+/
			}
		}
		// - supprimer
		"/question/$id/delete"(controller: "question", action: "delete") {
			constraints {
				id matches: /[0-9]+/
			}
		}
		
		// Réponse
		// - éditer
		"/response/$id/edit"(controller: "response", action: "edit") {
			constraints {
				id matches: /[0-9]+/
			}
		}
		"/response/$id/edit/submit"(controller: "response", action: "edit_submit") {
			constraints {
				id matches: /[0-9]+/
			}
		}
		
		
		
		// User
		"/user"(controller: "user", action: "all")
		"/user/error"(view: "/user/error")
		"/user/new"(view: "/user/newUser")
		"/user/create"(controller: "user", action: "create")
		"/user/delete"(controller: "user", action: "delete")
		"/user/login"(controller: "user", action: "login")
		"/user/logout"(controller: "user", action: "logout")
		"/user/$id"(controller: "user", action: "show")
		"/user/all"(controller: "user", action: "all") // page 1
		//"/user/all/$page"(controller: "user", action: "all")
		
		
		// Tag
		"/tag/$id"(controller: "tag", action: "show")
		"/tag/all"(controller: "tag", action: "all") // page 1
		"/tag/all/$page"(controller: "tag", action: "all")
		
		
		// StackOverflow : essayer de rediriger les liens de StackOverflow vers notre application
		"/users/logout"(controller: "user", action: "logout")
		
		
		"/"(controller: "question", action: "all")
		"500"(view: "/error")
	}
}
