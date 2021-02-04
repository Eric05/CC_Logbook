import java.util.Date;

public class CopyConstructors {
    private String name;
    private Date date;

    public CopyConstructors(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public CopyConstructors(CopyConstructors copy){
        name = copy.name;
        date = new Date(copy.date.getTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
