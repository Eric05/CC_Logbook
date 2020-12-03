package human;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class AbstractHuman {

    private String firstName;
    private String lastName;
    private int year;
    private String location;

}
