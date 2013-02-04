package fr.isima.stackoverlow

import org.junit.Test

@TestFor(Application)
class ApplicationTest {
	
	@Test
	void getListPages_err() {
		// totalPages = 0
		try {
			Application.getListPages(6, 0)
			fail("Exception non levée")
		}
		catch (IllegalArgumentException e) {}
		// currentPage = 0
		try {
			Application.getListPages(0, 5)
			fail("Exception non levée")
		}
		catch (IllegalArgumentException e) {}
		// totalPages < currentPage
		try {
			Application.getListPages(6, 5)
			fail("Exception non levée")
		}
		catch (IllegalArgumentException e) {}
	}
	
	
	@Test
	void getListPages_1a6() {
		for (int i=1 ; i<=6 ; i++) {
			def listPages = Application.getListPages(1, i)
			for (int j=1 ; j<=i ; j++)
				if (listPages[j-1] != j)
					fail("Erreur pour i=" + i)
		}
	}
	
	
	@Test
	void getListPages_sup7() {
		assertEquals(Application.getListPages(1, 99), [1, 2, 3, 4, 5, 99])
		assertEquals(Application.getListPages(2, 99), [1, 2, 3, 4, 5, 99])
		assertEquals(Application.getListPages(3, 99), [1, 2, 3, 4, 5, 99])
		assertEquals(Application.getListPages(4, 99), [1, 2, 3, 4, 5, 99])
		assertEquals(Application.getListPages(5, 99), [1, 3, 4, 5, 6, 7, 99])
		assertEquals(Application.getListPages(55, 99), [1, 53, 54, 55, 56, 57, 99])
		assertEquals(Application.getListPages(95, 99), [1, 93, 94, 95, 96, 97, 99])
		assertEquals(Application.getListPages(96, 99), [1, 95, 96, 97, 98, 99])
		assertEquals(Application.getListPages(97, 99), [1, 95, 96, 97, 98, 99])
		assertEquals(Application.getListPages(98, 99), [1, 95, 96, 97, 98, 99])
		assertEquals(Application.getListPages(99, 99), [1, 95, 96, 97, 98, 99])
	}
	
}
