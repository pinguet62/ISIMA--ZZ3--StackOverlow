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
		
		//login
		"/user/login"(controller: "user", action: "login")
		"/user/logout"(controller: "user", action: "logout")
		"/logUser"(view: "/user/loginForm")
		
		
		//create user
		"/user/create"(controller: "user", action: "create")
		"/user/new"(view: "/user/newUser")
		
		
		//edit user
		"/user/editUser"(controller: "user", action: "edit")
		"/user/edit"(controller: "user", action: "updateUser")
		
		//delete user
		"/user/deleteUser"(controller: "user", action: "delete")
		
		"/user"(controller: "user", action: "all")
		"/user/error"(view: "/user/error")
		
		
		"/user/delete"(controller: "user", action: "delete")
		"/user/$id"(controller: "user", action: "show")
		"/user/all"(controller: "user", action: "all") // page 1
	
		
		
		// Tag
		"/tag/$id"(controller: "tag", action: "show")
		"/tag/all"(controller: "tag", action: "all") // page 1
		"/tag/all/$page"(controller: "tag", action: "all")		
		
		"/index"(view: "/")
		
		
		"/"(controller: "question", action: "all")
		"500"(view: "/error")
	}
}
