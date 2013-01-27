import javax.swing.SpringLayout.Constraints;

class UrlMappings {

	static mappings = {
		// Défaut
		"/$controller/$action?/$id?" {
			constraints {
			}
		}
		
		
		// Questions
		"/question/form"(controller: "response", action: "form")
		"/question/create/$id"(controller: "response", action: "create")
		"/question/delete/$id"(controller: "response", action: "delete")
		"/question/$id"(controller: "question", action: "show")
		"/question/error"(view: "/question/error")
		
		
		// Response
		"/response/create/$id"(controller: "response", action: "create")
		"/response/delete/$id"(controller: "response", action: "delete")
		
		
		// User
		"/user/create"(controller: "user", action: "create")
		"/user/delete"(controller: "user", action: "delete")
		"/user/login"(controller: "user", action: "login")
		"/user/logout"(controller: "user", action: "logout")
		"/user/$id"(controller: "user", action: "show")
		"/user/all"(controller: "user", action: "all")
		
		
		// Tags
		"/tag/$id"(controller: "tag", action: "show")
		
		
		"/"(view: "/index")
		"500"(view: "/error")
	}
}
