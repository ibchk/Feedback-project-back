package form.feedback;

import form.feedback.enums.Category;
import form.feedback.model.Form;
import form.feedback.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class FormApplicationUnit implements CommandLineRunner {

    @Autowired
    private FormRepository formRepository;


    @Override
    public void run(String... args) {
        List<Form> feedbacks = new LinkedList<>();
        feedbacks.add(new Form((long) 4, "Mark", "mark@live.com", "Great!!!", Arrays.asList(Category.VIRTUAL_VISIT, Category.MICROSOFT_SHAREPOINT)));
        feedbacks.add(new Form((long) 6, "Jegor", "jegor@gmail.com", "Awesome product!!!", Collections.singletonList(Category.OPEN_KM)));
        feedbacks.add(new Form((long) 8, "Lana", "lena@hot.com", "Cheap and bad!", Arrays.asList(Category.REGISTRATION, Category.VIRTUAL_VISIT)));
        formRepository.saveAll(feedbacks);
    }

}
