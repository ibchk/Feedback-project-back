package form.feedback.model;

import form.feedback.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Form {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String text;
    private Category category;

}
