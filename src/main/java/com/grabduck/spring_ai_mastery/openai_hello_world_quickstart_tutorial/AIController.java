package com.grabduck.spring_ai_mastery.openai_hello_world_quickstart_tutorial;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AIController {
	private final ChatClient chatClient;

	@Value("classpath:/prompts/post-prompt.st")
	private Resource postPrompt;

	@Value("classpath:/prompts/content-creator-actor.st")
	private Resource contentCreatorActor;

	@Value("classpath:/prompts/poet-actor.st")
	private Resource poetActor;

	@Value("classpath:/prompts/social-media-task.st")
	private Resource socialMediaTask;

	public AIController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@PostMapping("/ai-reality-check")
	Map<String, String> completion(@RequestBody Message message) {
		return Map.of("completion",
				chatClient.prompt()
						.user(message.prompt())
						.call()
						.content()
		);
	}

	@PostMapping("/posts")
	Map<String, String> createNewPost(@RequestBody PostParams request) {
		// Create system message from actor template
		SystemMessage actorMessage = new SystemMessage(
				new PromptTemplate(getActorTemplate(request.actor()))
						.create(Map.of())
						.getContents());
		
		// Create user message with task details
		UserMessage taskMessage = new UserMessage(
				new PromptTemplate(socialMediaTask)
						.create(Map.of(
								"link", request.link(),
								"platform", request.platform(),
								"audience", request.audience()))
						.getContents());
		
		// Create prompt with both messages
		Prompt prompt = new Prompt(List.of(actorMessage, taskMessage));
		
		return Map.of("post",
				chatClient.prompt(prompt)
						.call()
						.content());
	}

	private Resource getActorTemplate(Actor actor) {
		return switch (actor) {
			case CONTENT_CREATOR -> contentCreatorActor;
			case POET -> poetActor;
		};
	}
}
