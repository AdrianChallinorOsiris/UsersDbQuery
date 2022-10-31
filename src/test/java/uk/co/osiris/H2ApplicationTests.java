package uk.co.osiris;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class H2ApplicationTests {
	@Autowired
    private UsersDbQuery uq;
	
	@Test
	void contextLoads() {
	}

	@Test 
	void testDBQuery() { 
		List<UsersPojo> list = uq.getUserDetails("fredfox@foxy.com");
		assertNotNull(list);
		assertEquals(1, list.size());
	}
}
