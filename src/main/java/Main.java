import com.opencsv.exceptions.CsvValidationException;
import pojos.POJOFacebook;
import pojos.CSVUtils;
import pojos.POJOWeb;
import pojos.POJOtest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    final static String file = "C:\\Users\\tao\\Documents\\resourcesForAssignment\\facebook_dataset.csv";
    final static String outputFile = "C:\\Users\\tao\\Documents\\resourcesForAssignment\\output_dataset.csv";
    public static void main(String[] args) throws IOException {
        List<POJOFacebook> csvFiles = new ArrayList<>();
        try {
            csvFiles.addAll(
                    CSVUtils.importTicketHoldersFromCSV(file));
        }catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }
}