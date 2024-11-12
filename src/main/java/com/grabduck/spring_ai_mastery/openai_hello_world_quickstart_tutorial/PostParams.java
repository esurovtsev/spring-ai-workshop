package com.grabduck.spring_ai_mastery.openai_hello_world_quickstart_tutorial;

public record PostParams(
    String link,
    String platform,
    String audience,
    Actor actor
) {}
