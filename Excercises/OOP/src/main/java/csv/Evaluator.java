package csv;

import csv.DTO.TopCasesDTO;

import java.util.*;


public class Evaluator {

    public List<TopCasesDTO> getTopCases(List<TopCasesDTO> data) {

        List<TopCasesDTO> sorted = new ArrayList<>();
        var entries = createTopCasesMap(data).entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            sorted.add(new TopCasesDTO(entry.getKey(), entry.getValue()));
        }
        Collections.sort(sorted);
        return sorted;
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


}
