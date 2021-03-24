package form.feedback.controllers;

import form.feedback.model.FormDTO;
import form.feedback.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to send and get feedbacks.
 */
@RequestMapping("form")
@RestController
public class FormController {

    @Autowired
    private FormService formService;

    /**
     * Get method for getting list with all feedbacks.
     *
     * @return List<FormDTO>
     */
    @GetMapping
    public List<FormDTO> getAllFeedbacks() {
        return formService.getAllFeedbacks();
    }

    /**
     * Post method for adding feedback.
     *
     * @param feedback FormDTO
     * @return FormDTO
     */
    @PostMapping
    public FormDTO addFeedback(@RequestBody FormDTO feedback) {
        return formService.addFeedback(feedback);
    }

}
