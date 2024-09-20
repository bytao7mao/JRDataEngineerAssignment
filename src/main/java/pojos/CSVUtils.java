package pojos;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtils {
    public static List<POJOFacebook> importTicketHoldersFromCSV(
            String filename) throws IOException, CsvValidationException {

        List<POJOFacebook> pojoArrayList = new ArrayList<>();

        if (!filename.contains(".csv")) {
            System.out.println("This is not a CSV file: " + filename);
            //exit function and return empty list
            return pojoArrayList;
        }
        //we read file
        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader reader = new InputStreamReader(fis,
                StandardCharsets.UTF_8);
        //using CSV library
        CSVReader csvReader = new CSVReader(reader);
        String[] row;
        //first row is HEADER ROW
        while ((row = csvReader.readNext()) != null) {
            pojoArrayList.add(new POJOFacebook(row[0].trim(),
                    row[1].trim(), row[2].trim(),
                    row[3].trim(), row[4].trim(),
                    row[5].trim(), row[6].trim(),
                    row[7].trim(),row[8].trim(),
                    row[9].trim(),row[10].trim(),
                    row[11].trim(),row[12].trim(),
                    row[13].trim(),row[14].trim(),
                    row[15].trim()));
//            System.out.println(row[0]);
        }
        System.out.println(pojoArrayList.get(0).getAddress());

        csvReader.close();
        return pojoArrayList;
    }


}
