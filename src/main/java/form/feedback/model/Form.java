package form.feedback.model;

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
    private String name;
    private String email;
    private String text;
    @ElementCollection
    private List<Category> categoryList = new LinkedList<>();

    public Form(String name, String email, String text, List<Category> categoryList) {
        setName(name);
        setEmail(email);
        setText(text);
        setCategoryList(categoryList);
    }
}
