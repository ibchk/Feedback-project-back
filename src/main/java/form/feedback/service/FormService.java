package form.feedback.service;

import form.feedback.model.Form;
import form.feedback.model.FormDTO;
import form.feedback.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Service for adding and getting Forms.
 */
@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;


    /**
     * Takes all feedbacks from db and makes from them list of FormDTO.
     *
     * @return List<FormDTO>
     */
    public List<FormDTO> getAllFeedbacks() {
        List<FormDTO> forms = new LinkedList<>();
        for (Form form : formRepository.findAll()) {
            forms.add(new FormDTO(form));
        }
        return forms;
    }


    /**
     * Makes form FormDTO new Form, checks that the all fields except id in not null or blank and
     * there is ore than one category. If all ok, then adds it in db and returns new FormDTO made from db Form.
     *
     * NOTE!!! In given FormDTO category list should be category enum values (indexes).
     *
     * @param feedback FormDTO
     * @return FormDTO
     */
    public FormDTO addFeedback(FormDTO feedback) {
        Form newFeedback = new Form(feedback);
        if (newFeedback.isCorrect()) {
            Form savedFeedback = formRepository.save(newFeedback);
            return new FormDTO(savedFeedback);
        }
        return null;
    }

}
