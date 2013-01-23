package fr.isima.stackoverlow

class UserController {

	// The compiler uses this specification to generate code that the application can use to create,
	// read, update and delete database entries, effectively treating the template as a "scaffold"
	// on which to build a more powerful application.
	static scaffold = true
	
    def index() { render 'la classe user' }
}
