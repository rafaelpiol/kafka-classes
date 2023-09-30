package br.com.alura.ecommerce;

import java.util.UUID;
import java.util.concurrent.ExecutionException;


public class NewOrderMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		try (var dispatcher = new KafkaDispatcher()) {
			for (var i=0; i < 10; i++) {
				var key = UUID.randomUUID().toString();
				var value = "1234,31451,0574845";
				dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);

				var email = "Thanks! We are processing your order!";
				dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
			}
		}
	}
}
