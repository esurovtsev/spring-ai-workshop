package com.grabduck.spring_ai_mastery.openai_hello_world_quickstart_tutorial;

import java.util.Set;

public record Article(
    String title,
    String content,
    Set<String> tags
) {
    
}
