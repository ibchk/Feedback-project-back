package form.feedback;

import form.feedback.model.FormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class RestTemplateTests {

    @Autowired
    private TestRestTemplate testRestTemplate = new TestRestTemplate();


    public static final ParameterizedTypeReference<List<FormDTO>> LIST_OF_FORM_DTO = new ParameterizedTypeReference<>() {
    };
    public static final ParameterizedTypeReference<FormDTO> FORM_DTO = new ParameterizedTypeReference<>() {
    };

    public TestRestTemplate template() {
        return testRestTemplate;
    }

    public <T> T assertOk(ResponseEntity<T> exchange) {
        assertNotNull(exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        return exchange.getBody();
    }
}
