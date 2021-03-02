package csv;

import csv.DTO.TopCasesDTO;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;


public class Evaluator {

    private Mapper mapper;
    private long filesize;

    public Evaluator(Path path ) {
        this.mapper = new Mapper(path);
    }

    public long getFilesize() throws IOException {
        return mapper.getTopCaseDTOs().size();
    }

    public List<TopCasesDTO> getTopCases() {
        var data = mapper.getTopCaseDTOs();
        List<TopCasesDTO> topCasesDTOS = new ArrayList<>();
        var entries = createTopCasesMap(data).entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            topCasesDTOS.add(new TopCasesDTO(entry.getKey(), entry.getValue()));
        }
        Collections.sort(topCasesDTOS);
        return topCasesDTOS;
    }

    private Map<String, Integer> createTopCasesMap(List<TopCasesDTO> data) {
        Map<String, Integer> resultSet = new HashMap<>();

        for (csv.DTO.TopCasesDTO item : data) {
            if (!resultSet.containsKey(item.getCountry())) {
                resultSet.put(item.getCountry(), item.getCases());
            } else {
                var cases = resultSet.get(item.getCountry()) + item.getCases();
                resultSet.put(item.getCountry(), cases);
            }
        }
        return resultSet;
    }

/*
 Create map with lamda
 Map<String,Integer> map = lines.stream()
            .map(entry -> entry.split(";"))
            .collect(Collectors.groupingBy(entry -> entry[0],
                    Collectors.summingInt(entry -> Integer.parseInt(entry[1]))));
                    */
}
