package bakery.employee;

public class Baker extends Employee {
    private int cookiePerHour;
    private int favPerHour;
    private String favCookie;

    public Baker(String name, int cookiePerHour, int favPerHour, String favCookie) {
        super(name);
        this.cookiePerHour = cookiePerHour;
        this.favPerHour = favPerHour;
        this.favCookie = favCookie;
    }

    public int getCookiePerHour() {
        return cookiePerHour;
    }

    public int getFavPerHour() {
        return favPerHour;
    }

    public String getFavCookie() {
        return favCookie;
    }
}
