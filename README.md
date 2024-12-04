# Spring AI Workshop

This project demonstrates the integration of OpenAI's capabilities with Spring AI, showcasing how to build intelligent REST APIs that leverage AI for content generation and text processing.

## Overview

The application provides REST endpoints that utilize OpenAI's language models through Spring AI to:
- Generate responses to prompts
- Create social media posts with different personas
- Process and transform content based on specific requirements

## Branches

### feature/spring-ai-structured-output
Demonstrates working with structured output in Spring AI, showing how to properly handle and process structured responses from AI models.

📺 Watch the implementation video: [Spring AI Structured Output Tutorial](https://youtu.be/IjHgnrFGtIM?si=1sVIi9QXJgKd428j)

## Prerequisites

- Java 17 or higher
- Maven
- OpenAI API key (set in application properties)

## Getting Started

1. Clone the repository
2. Set your OpenAI API key in `application.properties`:
   ```properties
   spring.ai.openai.api-key=your-api-key
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Endpoints

### 1. AI Reality Check
Endpoint for general AI interactions.

**Endpoint:** `POST /ai-reality-check`

**Request Body:**
```json
{
    "prompt": "Your question or prompt here"
}
```

**Response:**
```json
{
    "completion": "AI-generated response"
}
```

### 2. Social Media Post Generation
Generate social media posts with different personas.

**Endpoint:** `POST /posts`

**Request Body:**
```json
{
    "actor": "CONTENT_CREATOR",  // or "POET"
    "link": "https://example.com/article",
    "platform": "Twitter",  // or other social media platform
    "audience": "tech professionals"
}
```

**Response:**
```json
{
    "post": "Generated social media post content"
}
```

## Examples

### Generate a Tech-focused Tweet

```bash
curl -X POST http://localhost:8080/posts \
  -H "Content-Type: application/json" \
  -d '{
    "actor": "CONTENT_CREATOR",
    "link": "https://spring.io/projects/spring-ai",
    "platform": "Twitter",
    "audience": "Java developers"
  }'
```

### Get AI Response

```bash
curl -X POST http://localhost:8080/ai-reality-check \
  -H "Content-Type: application/json" \
  -d '{
    "prompt": "What are the key benefits of Spring AI?"
  }'
```

## Available Actors

The system supports different personas for content generation:

1. **CONTENT_CREATOR**: Professional and informative tone, suitable for technical content
2. **POET**: Creative and artistic tone, adds a poetic twist to the content

## Configuration

The application uses various prompt templates located in the `resources/prompts` directory:
- `post-prompt.st`: General post generation template
- `content-creator-actor.st`: Content creator persona template
- `poet-actor.st`: Poet persona template
- `social-media-task.st`: Social media task specification template

## Contributing

Feel free to submit issues and enhancement requests!

## License

This project is licensed under the MIT License - see the LICENSE file for details.
