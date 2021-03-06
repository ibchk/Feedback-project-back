package form.feedback.model;

import com.sun.istack.NotNull;
import form.feedback.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String text;
    @ElementCollection
    private List<Category> categoryList;

    /**
     * Makes Form from FormDTO.
     * NOTE!!! In FormDTO category list should be category enum values (indexes or names).
     *
     * @param feedback FormDTO
     */
    public Form(FormDTO feedback) {
        name = feedback.getName();
        email = feedback.getEmail();
        text = feedback.getText();
        categoryList = new LinkedList<>();
        Category[] categories = Category.values();
        if (feedback.getCategories() != null){
            for (String value : feedback.getCategories()) {
                for (Category category : categories) {
                    if (value.equals(category.getIndex()) || value.equals(category.getName())) {
                        categoryList.add(category);
                    }
                }
            }
        }
    }

    /**
     * isCorrect() is used before sending Form in db, as it checks if
     * name, email, text and categoryList are not null or empty
     *
     * @return boolean
     */
    public Boolean isCorrect() {
        return name != null && email != null && text != null && categoryList != null
                && !name.isBlank() && !email.isBlank() && !text.isBlank() && categoryList.size() > 0;
    }
}
