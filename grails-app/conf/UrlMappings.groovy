class UrlMappings {

	static mappings = {
		// D�faut
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		// Questions
		/*"/question/$id?"{
			controller: "question"
			astion: "show"
			constraints {
			}
		}*/
		
		
		"/"(view: "/index")
		"500"(view: "/error")
		"/question"(view: "question/index") // tmp
	}
}
