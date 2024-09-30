package com.grupo19.gastroreserva;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GastroReservaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testMain() {
		GastroReservaApplication.main(new String[] {});
	}
}
