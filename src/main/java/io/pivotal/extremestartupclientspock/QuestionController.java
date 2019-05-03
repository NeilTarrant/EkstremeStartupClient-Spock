package io.pivotal.extremestartupclientspock;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    @GetMapping
    ResponseEntity<String> answer(@RequestParam String q) {
        String question = extractQuestion(q);
        String answer = determineAnswer(question);

        System.out.printf("Question: %s; Answer: %s%n", question, answer);

        return ResponseEntity.ok(answer);
    }

    private String determineAnswer(String question) {
        return "TeamSpock";
    }

    private String extractQuestion(String q) {
        return q.trim();
    }

}
