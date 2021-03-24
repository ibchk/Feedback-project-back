package form.feedback;

import form.feedback.model.FormDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FeedbackApplicationTests extends RestTemplateTests {

    @Test
    void checkEmptyDB() {
        ResponseEntity<List<FormDTO>> feedbacksEX = template().exchange("/form", HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()), LIST_OF_FORM_DTO);
        List<FormDTO> feedbacks = assertOk(feedbacksEX);
        assertTrue(feedbacks.isEmpty());
    }

    @Test
    void addAllWrongFeedbacks() {
        FormDTO feedback = new FormDTO(null, null, null, null, null);
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(null, "", "", "", Collections.emptyList());
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(null, " ", " ", " ", Collections.emptyList());
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " ", "whitewhitewhitewhite@mail.ee", "Cool !", Collections.singletonList("29"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, null, "whitewhitewhitewhite@mail.ee", "Cool !", Collections.singletonList("29"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "", "Cool !", Collections.singletonList("29"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", " ", "Cool !", Collections.singletonList("29"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", null, "Cool !", Collections.singletonList("29"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "whitewhitewhitewhite@mail.ee", "", Collections.singletonList("29"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "whitewhitewhitewhite@mail.ee", " ", Collections.singletonList("29"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "whitewhitewhitewhite@mail.ee", null, Collections.singletonList("29"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "whitewhitewhitewhite@mail.ee", "Cool !", null);
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "whitewhitewhitewhite@mail.ee", "Cool !", Collections.emptyList());
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "whitewhitewhitewhite@mail.ee", "Cool !", Collections.singletonList("22222"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "whitewhitewhitewhite@mail.ee", "Cool !", Collections.singletonList("0"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "whitewhitewhitewhite@mail.ee", "Cool !", Collections.singletonList(""));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);

        ResponseEntity<List<FormDTO>> feedbacksEX = template().exchange("/form", HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()), LIST_OF_FORM_DTO);
        List<FormDTO> feedbacks = feedbacksEX.getBody();
        assertNotNull(feedbacks);
        assertEquals(HttpStatus.OK, feedbacksEX.getStatusCode());
        assertEquals(0, feedbacks.size());
    }

    @Test
    void addRightFeedback() {
        FormDTO feedback = new FormDTO(null, "Mark", "mark@gmail.com", "Awesome product", Arrays.asList("11", "17"));
        ResponseEntity<FormDTO> dbFeedbackEX = template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        FormDTO dbFeedback = assertOk(dbFeedbackEX);
        assertEquals(1, dbFeedback.getId());
        assertEquals("Mark", dbFeedback.getName());
        assertEquals("mark@gmail.com", dbFeedback.getEmail());
        assertEquals("Awesome product", dbFeedback.getText());
        assertEquals(Arrays.asList("Patients portal", "Virtual visit"), dbFeedback.getCategories());
    }

    @Test
    void addSomeRightFeedbacksCheckAllInDB() {
        FormDTO feedback = new FormDTO(1L, "Any Jackson", "aj@live.com", "Liked!!!", Collections.singletonList("11"));
        ResponseEntity<FormDTO> dbFeedbackEX = template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(0L, " mr White", "whitewhitewhitewhite@mail.ee", "Cool !", Collections.singletonList("29"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(null, "   anonymus", "allan@gmail.com", "Awesome product", Arrays.asList("18", "17"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(null, "   anonymus", "allan@gmail.com", "Awesome product", Arrays.asList("18", "17"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(2L, "   anonymus", "allan@gmail.com", "Awesome product", Arrays.asList("18", "17"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        feedback = new FormDTO(2L, "   anonymus", "allan@gmail.com", "Awesome product", Collections.singletonList("Virtual visit"));
        template().exchange("/form", HttpMethod.POST, new HttpEntity<>(feedback, new HttpHeaders()), FORM_DTO);
        ResponseEntity<List<FormDTO>> feedbacksEX = template().exchange("/form", HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()), LIST_OF_FORM_DTO);
        List<FormDTO> feedbacks = feedbacksEX.getBody();
        assertNotNull(feedbacks);
        assertEquals(HttpStatus.OK, feedbacksEX.getStatusCode());
        assertEquals(6, feedbacks.size());
    }
}
