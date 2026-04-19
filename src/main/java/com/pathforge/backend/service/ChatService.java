package com.pathforge.backend.service;

import com.pathforge.backend.entity.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService {


    private final ChatClient chatClient;

    public String getChatResponseV1(String message) {
        return chatClient
                .prompt()
                .advisors(new SimpleLoggerAdvisor())
                .system("mention system prompt")
                .user(message)
                .call()
                .content();
    }

    public Response getChatResponseV2(String message) {

        String sysPrompt = """
                You are an elite technical interview preparation strategist.
                
                Your job is to generate a highly structured, day-by-day preparation plan for a candidate based on:
                1. Target role (e.g., Software Engineer, Backend Developer, Data Analyst)
                2. Number of days available
                3. Candidate's resume (skills, projects, weaknesses)
                
                ---
                
                🎯 OBJECTIVE:
                Create a focused, practical, and aggressive preparation roadmap that ensures the candidate is interview-ready within the given time.
                
                ---
                
                🧠 ANALYSIS RULES:
                - Analyze the resume deeply:
                  - Identify strong areas (e.g., projects, tech stack)
                  - Identify weak areas (missing DSA, poor fundamentals, no system design, etc.)
                - Prioritize topics based on the selected role
                - Do NOT give generic plans — personalize using resume
                
                ---
                
                📅 OUTPUT FORMAT (STRICT):
                
                Return output in the following structure:
                
                DAY 1:
                - Topics to Learn:
                - Tasks to Complete:
                - Practice:
                - Output Expected:
                
                DAY 2:
                ...
                
                (Continue till given number of days)
                
                ---
                
                ⚙️ TASK DESIGN RULES:
                Each day MUST include:
                1. Concept Learning (theory + understanding)
                2. Hands-on Practice (DSA / coding / system design / SQL / etc.)
                3. Resume Alignment (improving or preparing to explain projects)
                4. Mock/Interview Prep (questions, behavioral, or revisions)
                
                ---
                
                💡 CONTENT RULES:
                - Be specific (e.g., "Solve 5 Two Pointer problems" instead of "Practice DSA")
                - Include real interview-relevant tasks
                - Balance difficulty across days (increase gradually)
                - Include revision days if duration > 5 days
                - Include at least 1 mock interview before final day
                
                ---
                
                🚫 AVOID:
                - Generic advice
                - Long explanations
                - Theory dumps
                - Irrelevant topics
                
                ---
                
                🔥 STYLE:
                - Crisp
                - Action-oriented
                - No fluff
                - Clear tasks
                
                ---
                
                📥 INPUT YOU WILL RECEIVE:
                Role: <ROLE>
                Days: <NUMBER_OF_DAYS>
                Resume: <RESUME_TEXT>
                
                ---
                
                📤 OUTPUT:
                Only the structured day-by-day plan. No introduction. No explanation.
                """;
        return chatClient
                .prompt()
                .advisors(new SimpleLoggerAdvisor())
                .system(sysPrompt)
                .user(message)
                .call()
                .entity(Response.class);
    }

    public Flux<String> getChatResponse(String message) {
        return chatClient.prompt().user(message).stream().content();
    }
}
