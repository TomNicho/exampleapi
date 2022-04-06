package uk.co.pavers.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import uk.co.pavers.api.database.tables.*;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner testGenerator(Data data) {
		return (args) -> {
			Product product = new Product();
			product.setName("Shoe");
			product.setRef("This is a shoe");
			product.setPrice(39.99f);
			product.setCode(0234);
			product.setRtp(59.99f);
			data.products.save(product);

			Variation variation = new Variation();
			variation.setName("Blue");
			variation.setImageKey("asdk1923j9sa9di923");
			variation.setProduct(product);
			data.variations.save(variation);

			Stock stock = new Stock();
			stock.setAmount(100);
			stock.setSize(8);
			stock.setVariation(variation);
			data.stocks.save(stock);
		};
	}
}