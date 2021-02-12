package co.com.meli.quasarfire;

import co.com.meli.quasarfire.controller.QuasarFireController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuasarFireApplicationTests {

	@Autowired
	private QuasarFireController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
