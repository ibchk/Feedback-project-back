package form.feedback.model;

import form.feedback.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormDTO {
    private Long id;
    private String name;
    private String email;
    private String text;
    private List<String> categories;


    /**
     * Makes FormDTO from Form
     *
     * @param savedFeedback Form
     */
    public FormDTO(Form savedFeedback) {
        id = savedFeedback.getId();
        name = savedFeedback.getName();
        email = savedFeedback.getEmail();
        text = savedFeedback.getText();
        categories = new LinkedList<>();
        for (Category category : savedFeedback.getCategoryList()) {
            categories.add(category.getName());
        }
    }
}
