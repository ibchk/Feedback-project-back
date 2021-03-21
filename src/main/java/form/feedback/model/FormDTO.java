package form.feedback.model;

import form.feedback.enums.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FormDTO {
    private String name;
    private String email;
    private String text;
    private List<String> categories;
}
