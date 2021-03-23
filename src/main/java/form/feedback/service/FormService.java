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

    Category[] categories = Category.values();

    @Autowired
    private FormRepository formRepository;

    public List<FormDTO> getAllFeedbacks() {
        List<FormDTO> forms = new LinkedList<>();
        for (Form form : formRepository.findAll()) {
            FormDTO formDTO = new FormDTO(form.getId(), form.getName(), form.getEmail(), form.getText());
            List<String> categories = new LinkedList<>();
            for (Category category : form.getCategoryList()) {
                categories.add(category.getName());
            }
            formDTO.setCategories(categories);
            forms.add(formDTO);
        }
        return forms;
    }

    public Form addFeedback(FormDTO feedback) {

        List<Category> feedbackCategories = new LinkedList<>();
        if (feedback.getCategories() != null) {
            for (String i : feedback.getCategories()) {
                for (Category category : categories) {
                    if (i.equals(category.getIndex())) {
                        feedbackCategories.add(category);
                    }
                }
            }
        }
        Form newFeedback = new Form(feedback.getName(), feedback.getEmail(), feedback.getText(), feedbackCategories);
        return formRepository.save(newFeedback);
    }

}
