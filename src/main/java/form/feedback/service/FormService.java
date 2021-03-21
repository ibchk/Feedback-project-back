package form.feedback.service;

import form.feedback.model.Form;
import form.feedback.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public List<Form> getAllFeedbacks(){
        return formRepository.findAll();
    }

    public Form addFeedback(Form feedback){
        return formRepository.save(feedback);
    }

}
