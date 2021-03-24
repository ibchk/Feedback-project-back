package form.feedback.service;

import form.feedback.enums.Category;
import form.feedback.model.Form;
import form.feedback.model.FormDTO;
import form.feedback.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public List<FormDTO> getAllFeedbacks() {
        List<FormDTO> forms = new LinkedList<>();
        for (Form form : formRepository.findAll()) {
            forms.add(new FormDTO(form));
        }
        return forms;
    }

    public FormDTO addFeedback(FormDTO feedback) {
        Form newFeedback = new Form(feedback);
        if (newFeedback.isCorrect()) {
            Form savedFeedback = formRepository.save(newFeedback);
            return new FormDTO(savedFeedback);
        }
        return null;
    }

}
