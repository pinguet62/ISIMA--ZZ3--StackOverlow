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
		/*"/question/$id" {
			controller: "question"
			action: "show"
			constraints {
				// TODO: 0<id
			}
		}*/
		
		
		// User
		"/question/error"(view: "/question/error")
		"/user/$id"(controller: "user", action: "show")
		/*"/user/$id" {
			controller: "user"
			action: "show"
			constraints {
				// TODO: 0<id
			}
		}*/
		
		
		"/"(view: "/index")
		"500"(view: "/error")
	}
}
