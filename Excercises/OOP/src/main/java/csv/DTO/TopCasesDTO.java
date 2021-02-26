package csv.DTO;

import csv.Config;

public class TopCasesDTO implements Comparable {
    private final String country;
    private final int cases;

    public TopCasesDTO(String country, int cases) {
        this.country = country;
        this.cases = cases;
    }

    public int getCases() {
        return cases;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return this.getCountry() + Config.OUT_DELIM + this.getCases();
    }

    @Override
    public int compareTo(Object o) {
        return ((TopCasesDTO) o).getCases() - this.getCases();
    }
}
