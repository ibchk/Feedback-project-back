package form.feedback.controllers;

import form.feedback.model.Form;
import form.feedback.model.FormDTO;
import form.feedback.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("form")
@RestController
public class FormController {

    @Autowired
    private FormService formService;
    private Object String;

    @GetMapping
    public List<Form> getAllFeedbacks() {
        return formService.getAllFeedbacks();
    }

    @PostMapping
    public Form addFeedback(@RequestBody FormDTO feedback){
        return formService.addFeedback(feedback);

    }

}
