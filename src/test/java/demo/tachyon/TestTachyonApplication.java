package demo.tachyon;

import org.springframework.boot.SpringApplication;

public class TestTachyonApplication {

	public static void main(String[] args) {
		SpringApplication.from(TachyonApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
