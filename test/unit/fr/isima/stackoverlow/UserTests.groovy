package fr.isima.stackoverlow



/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

	@Before
	public void before() {
		User.where{}.deleteAll()
	}
	
	
	@Test
    void testCreateUser() {
		/*def location = new Location(name: 'Turin', country: 'it',
			address: 'Turin')
			.addToWarehouses(name:'Turin Warehouse 1')
			.addToWarehouses(name:'Turin Warehouse 2')
			.save()*/
		
		User u1 = new User(name:'Julien', mail:'ju@leboulet.com', password:'moimoi')
		
		def u2 = User.get(1)
		assertNull(u2)
		
		u1.save()
		
		def u3 = User.get(1)
		assertNotNull(u3)
		assertEquals(u1, u3)
    }
}
