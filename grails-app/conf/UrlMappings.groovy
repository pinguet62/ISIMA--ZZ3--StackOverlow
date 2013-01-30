import javax.swing.SpringLayout.Constraints;

class UrlMappings {

	static mappings = {
		// Défaut
		"/$controller/$action?/$id?" {
			constraints {
			}
		}
		
		
		// Question
		"/question/error"(view: "/question/error")
		"/question/new"(view: "/question/new")
		"/question/create/$id"(controller: "question", action: "create")
		"/question/delete/$id"(controller: "question", action: "delete")
		"/question/$id"(controller: "question", action: "show")
		"/question/all/"(controller: "question", action: "all") // page 1
		"/question/all/$page"(controller: "question", action: "all")
		
		
		// Response
		"/response/create/$id"(controller: "response", action: "create")
		"/response/delete/$id"(controller: "response", action: "delete")
		
		
		// User
		"/user/error"(view: "/user/error")
		"/user/new"(view: "/user/new")
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
		
		
		"/"(view: "/index")
		"500"(view: "/error")
	}
}
