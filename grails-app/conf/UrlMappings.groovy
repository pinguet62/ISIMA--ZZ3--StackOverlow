import javax.swing.SpringLayout.Constraints;

class UrlMappings {

	static mappings = {
		// Défaut
		"/$controller/$action?/$id?" {
			constraints {
			}
		}
		
		
		// Questions
		"/question/$id"(controller: "question", action: "show")
		"/question/error"(view: "/question/error")
		/*"/question/$id" {
			controller: "question"
			action: "show"
			constraints {
				// TODO: 0<id
			}
		}*/
		
		
		// User
		"/user/$id"(controller: "user", action: "show")
		
		
		// Tags
		"/tag/$id"(controller: "tag", action: "show")
		
		
		"/"(view: "/index")
		"500"(view: "/error")
	}
}
