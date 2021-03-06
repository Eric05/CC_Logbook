package covidCsv.FileIO;

import covidCsv.FileIO.DTO.*;
import fileIO.LogType;
import fileIO.SimpleLogger;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        var basePath = Paths.get(System.getProperty("user.dir") );

        var csv = CsvUtil.loadCsv(basePath.resolve("covid19.csv"), ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        var data = DailyCovidDTO.convert(csv);

        var aggregator = new CovidAggregator();
        var topList = aggregator.getTopCases(data);
        var averageCumulative = aggregator.getAverageCumulative(data);
        var maxCumulative = aggregator.getMaxCumulative(data);
        var topPercentagePopulation = aggregator.getTopPercentagePopulation(data);

        CsvUtil.saveCsv(basePath.resolve("covid-toplist.csv"), TopCasesDTO.convert(topList), ";");
        CsvUtil.saveCsv(basePath.resolve("average-cases-per-100k.csv"), AverageCumulativeDTO.convert(averageCumulative), ";");
        CsvUtil.saveCsv(basePath.resolve("max-cumulative-14-days.csv"), MaxCumulativeDTO.convert(maxCumulative), ";");
        CsvUtil.saveCsv(basePath.resolve("top-percentage-population.csv"), TopPercentagePopulationDTO.convert(topPercentagePopulation), ";");

        long finish = System.currentTimeMillis();
        SimpleLogger.getInstance().log(LogType.INFO, "processed " + csv.size() + " lines in " + (finish - start) + "ms");
    }
}
