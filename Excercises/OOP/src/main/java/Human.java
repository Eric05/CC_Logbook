import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Human {

    private String firstName;
    private String lastName;
    private int year;
    private String location;
    private boolean isMale;

}
