package form.feedback.service;

import form.feedback.enums.Category;
import form.feedback.model.Form;
import form.feedback.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public List<Form> getAllFeedbacks(){
        return formRepository.findAll();
    }

    public Form addFeedback(Form feedback){

        List<Category> go = new LinkedList<>();

        for (Category i: feedback.getCategoryList()){
            go.add(i);
        }

        Form newFeedback = new Form(feedback.getName(), feedback.getEmail(), feedback.getText(), go);
        return formRepository.save(newFeedback);
    }

}
