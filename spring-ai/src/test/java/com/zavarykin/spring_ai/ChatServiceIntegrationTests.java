package com.zavarykin.spring_ai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// ./mvnw -Pintegration test
@Tag("integration")
@SpringBootTest 
public class ChatServiceIntegrationTests {

    @Autowired 
    ChatService chatService;

    @Test
    void testChat() {
        String answer = chatService.chat("chat-01", "hello");
        assertThat(answer).isNotBlank();
    }

    @Test 
    void testStream() {
        assertThat(chatService.stream("chat-01", "hello").blockFirst()).isNotBlank();
    }

}
