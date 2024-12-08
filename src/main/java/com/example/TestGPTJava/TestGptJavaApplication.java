package com.example.TestGPTJava;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestGptJavaApplication implements CommandLineRunner {

	@Autowired
	OpenAiChatModel chatModel;

	public static void main(String[] args) {
		SpringApplication.run(TestGptJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Prompt prompt = new Prompt("Tell me a programmer joke that is funny!");
		ChatResponse response = chatModel.call(prompt);
		System.out.println(response.getResult().getOutput().getContent());
	}
}
