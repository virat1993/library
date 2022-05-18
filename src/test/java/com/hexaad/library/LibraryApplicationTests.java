package com.hexaad.library;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class LibraryApplicationTests {

	@Test
	void contextLoads() {
		Assert.isTrue(true, String.valueOf("passed"));
	}

}
