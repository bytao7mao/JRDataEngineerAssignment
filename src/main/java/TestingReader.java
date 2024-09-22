import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import pojos.POJOWeb;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TestingReader {

    public static void main(String[] args) throws IOException, CsvException {

        CSVReader reader = new CSVReader(new FileReader(Main.outputFile));

        List<POJOWeb> pojoWebs = new ArrayList<>();
        List<String[]> records = reader.readAll();
        Iterator<String[]> iterator = records.iterator();
        // read line by line

        while (iterator.hasNext()) {
            String[] record = iterator.next();
            pojoWebs.add(new POJOWeb(record[0],
                    record[1], record[2],
                    record[3],record[4],
                    record[5],record[6],
                    record[7],record[8],
                    record[9],record[10]));
        }
        System.out.println(pojoWebs);
        reader.close();
    }

}
