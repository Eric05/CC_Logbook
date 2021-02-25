package csv;

import csv.DTO.Config;
import csv.DTO.TopCasesDTO;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private final Path path;

    public Mapper(Path path) {
        this.path = path;
            }

    public List<TopCasesDTO> getTopCaseDTOs() throws IOException {
        var csvList = CsvUtil.readCsvToList(path);
        csvList.remove(0);

        var DTOList = new ArrayList<TopCasesDTO>();

        for (String s : csvList) {
            var dto = getDTOFromLine(s, Config.INPUT_DELIM);
            var country = dto[6];
            var cases = Integer.parseInt(dto[4]);
            DTOList.add(new TopCasesDTO(country, cases));
        }
        return DTOList;
    }

    private String[] getDTOFromLine(String line, String delim) {
        var clearLine = line.replaceAll(delim + "\\s{1,}", delim)
                .replaceAll("(\\s{1,})", " ")
                .trim();
        return clearLine.split(delim);

    }


}
