package com.example.TestGPTJava;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestGptJavaApplication implements CommandLineRunner {

	@Autowired
	OpenAiChatModel chatModel;

	@GetMapping("/welcome")
	public String funnyJokes(@RequestParam String type) {
		String input = String.format("Tell me a %s joke", type);
		Prompt prompt = new Prompt(input);
		ChatResponse response = chatModel.call(prompt);
		return response.getResult().getOutput().getContent();

	}

	public static void main(String[] args) {
		SpringApplication.run(TestGptJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
