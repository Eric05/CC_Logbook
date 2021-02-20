package enumExample;

// enum with String code
public enum PersonType {
    GUARD("1"),
    VISITOR("2"),
    THIEF("3"),
    CHIEF("4");

    private final String shortCode;

    PersonType(String code) {
        this.shortCode = code;
    }

    public String getPersonCode() {
        return this.shortCode;
    }

    public int getIntCode() {
        boolean isInt = tryParseInt(this.shortCode);
        if (isInt) {
            return Integer.parseInt(this.shortCode);
        }
        return 0;
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
