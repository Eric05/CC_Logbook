package csv;

import csv.DTO.TopCasesDTO;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mapper {
    private final Path path;

    public Mapper(Path path) {
        this.path = path;
    }

    public List<TopCasesDTO> getTopCaseDTOs() {
        var csvList = CsvUtil.readCsvToList(path);
        if (csvList != null) {
            csvList.remove(0);
        }

        var DTOList = new ArrayList<TopCasesDTO>();

        for (var line : csvList) {
            var items = getItemsFromLine(line, Config.INPUT_DELIM);
            var country = items[6];
            var cases = Integer.parseInt(items[4]);
            DTOList.add(new TopCasesDTO(country, cases));
        }
        return DTOList;
    }

    private String[] getItemsFromLine(String line, String delim) {
        var clearLine = line.replaceAll(delim + "\\s{1,}", delim)
                .replaceAll("(\\s{1,})", " ")
                .trim();
        return clearLine.split(delim);
    }


}
