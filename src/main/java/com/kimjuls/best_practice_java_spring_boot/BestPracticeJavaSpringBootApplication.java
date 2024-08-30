package com.kimjuls.best_practice_java_spring_boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class BestPracticeJavaSpringBootApplication {
	private static final Logger loggerKafka = LoggerFactory.getLogger("KAFKA_LOG");

	public static void main(String[] args) {
		SpringApplication.run(BestPracticeJavaSpringBootApplication.class, args);
	}

	@KafkaListener(id = "id_1", topics = "logger", groupId = "group_1")
	public void listen(String in) {
		System.out.println(in);
		loggerKafka.info("message from logger");
		loggerKafka.info(in);
	}
}
