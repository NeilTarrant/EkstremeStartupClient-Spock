package io.pivotal.extremestartupclientspock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@WebMvcTest
class QuestionControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Unroll
    def "when asked a question, replies with the correct answer"() {
        expect:
        mvc.perform(get("/").param("q", question))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == answer

        where:
        question            | answer
        "what is your name" | "TeamSpock"

    }

}
