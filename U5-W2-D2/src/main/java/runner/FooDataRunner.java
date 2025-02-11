package runner;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Transactional
@Order (1)
public class FooDataRunner implements CommandLineRunner {

	@Override
	public void run (String... args) {
		System.out.println("FooDataRunner running...");
	}
}
