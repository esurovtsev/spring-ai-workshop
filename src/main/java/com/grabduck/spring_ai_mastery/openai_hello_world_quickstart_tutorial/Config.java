package com.grabduck.spring_ai_mastery.openai_hello_world_quickstart_tutorial;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {
  @Bean
  ChatClient chatClient(ChatClient.Builder builder) {
    return builder.build();
  }
}
