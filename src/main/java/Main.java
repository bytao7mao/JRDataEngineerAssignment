import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import pojos.*;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    final static String fileGoogle = "C:\\Users\\tao\\Documents\\resourcesForAssignment\\google_dataset.csv";
    final static String fileFacebook = "C:\\Users\\tao\\Documents\\resourcesForAssignment\\facebook_dataset.csv";
    final static String fileMiniFacebook = "C:\\Users\\tao\\Documents\\resourcesForAssignment\\mini_facebook.csv";
    final static String fileWebsite = "C:\\Users\\tao\\Documents\\resourcesForAssignment\\website_dataset.csv";
    final static String outputFile = "C:\\Users\\tao\\Documents\\resourcesForAssignment\\country_duplicate_from_all_files.csv";
    final static String testFile = "C:\\Users\\tao\\Documents\\resourcesForAssignment\\test.csv";
    final static String webTest = "C:\\Users\\tao\\Documents\\resourcesForAssignment\\webtest.csv";

    public static void main(String[] args) throws IOException {
        List<POJOWeb> csvFilesForWeb = new ArrayList<>();
        List<POJOFacebook> csvFilesForFb = new ArrayList<>();
        List<POJOGoogle> csvFilesForGoogle = new ArrayList<>();
        try {
            csvFilesForWeb.addAll(
                    CSVUtils.importDataFromCSVWebsite(fileWebsite));
        }catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        try {
            csvFilesForFb.addAll(
                    CSVUtils.importDataFromCSVFacebook(fileMiniFacebook));
        }catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        try {
            csvFilesForGoogle.addAll(
                    CSVUtils.importDataFromCSVGoogle(fileGoogle));
        }catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        HashMap<String, Integer> hashMapDomain = new HashMap<>();
        HashMap<String, Integer> hashMapCountry = new HashMap<>();
        HashMap<String, Integer> hashMapName = new HashMap<>();

        List<POJOWeb> arrayPojoWeb = new ArrayList<>();
        List<POJOFacebook> arrayPojoFacebook = new ArrayList<>();
        List<POJOGoogle> arrayPojoGoogle = new ArrayList<>();

        for (POJOWeb pojoWeb: csvFilesForWeb){
            arrayPojoWeb.add(new POJOWeb(pojoWeb.getRoot_domain(), pojoWeb.getDomain_suffix(),
                    pojoWeb.getLanguage(), pojoWeb.getLegal_name(), pojoWeb.getMain_city(),
                    pojoWeb.getMain_country(), pojoWeb.getMain_region(), pojoWeb.getPhone(),
                    pojoWeb.getSite_name(), pojoWeb.getTld(), pojoWeb.getS_category()));
        }
        for (POJOFacebook pojoFacebook: csvFilesForFb){
            arrayPojoFacebook.add(new POJOFacebook(pojoFacebook.getDomain(), pojoFacebook.getAddress(),
                    pojoFacebook.getCategories(), pojoFacebook.getCity(), pojoFacebook.getCountry_code(),
                    pojoFacebook.getCountry_name(), pojoFacebook.getDescription(), pojoFacebook.getEmail(),
                    pojoFacebook.getLink(), pojoFacebook.getName(), pojoFacebook.getPage_type(),
                    pojoFacebook.getPhone(), pojoFacebook.getPhone_country_code(), pojoFacebook.getRegion_code(),
                    pojoFacebook.getRegion_name(), pojoFacebook.getZip_code()));
        }
        for (POJOGoogle pojoGoogle: csvFilesForGoogle){
            arrayPojoGoogle.add(new POJOGoogle(pojoGoogle.getAddress(), pojoGoogle.getCategory(),
                    pojoGoogle.getCity(), pojoGoogle.getCountry_code(), pojoGoogle.getCountry_name(),
                    pojoGoogle.getName(), pojoGoogle.getPhone(), pojoGoogle.getPhone_country_code(),
                    pojoGoogle.getRaw_address(), pojoGoogle.getRaw_phone(), pojoGoogle.getRegion_code(),
                    pojoGoogle.getRegion_name(), pojoGoogle.getText(), pojoGoogle.getZip_code(),
                    pojoGoogle.getDomain()));
        }

//        for (POJOWeb pojo:arrayPojoWeb){
//                if (hashMapName.containsKey(pojo.getLegal_name())){
//                    hashMapName.put(pojo.getLegal_name(), hashMapName.get(pojo.getLegal_name()) + 1);
//                } else {
//                    hashMapName.put(pojo.getLegal_name(), 1);
//                }
//            }
        for (POJOFacebook pojo:arrayPojoFacebook){
            if (hashMapName.containsKey(pojo.getName())){
                hashMapName.put(pojo.getName(), hashMapName.get(pojo.getName()) + 1);
            } else {
                hashMapName.put(pojo.getName(), 1);
            }
        }
//        for (POJOGoogle pojo:arrayPojoGoogle){
//            if (hashMapName.containsKey(pojo.getName())){
//                hashMapName.put(pojo.getName(), hashMapName.get(pojo.getName()) + 1);
//            } else {
//                hashMapName.put(pojo.getName(), 1);
//            }
//        }
        ArrayList<String> arrayListUnique = new ArrayList<>();
        ArrayList<String> arrayListDuplicate = new ArrayList<>();
        //Display the duplicate words and their counts
        for (Map.Entry<String, Integer> entry : hashMapName.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Repeated values: " + entry.getKey() + ": " + entry.getValue());
                arrayListDuplicate.add(entry.getKey() + " * " + entry.getValue());
            } else {
                System.out.println("Unique values: " + entry.getKey() + ": " + entry.getValue());
                arrayListUnique.add(entry.getKey());
            }
        }

//        String[] header = {"Domain", "Name", "Country"};
//        String[] recordDuplicatesDomain = new String[arrayListDuplicate.size()];
//        String[] recordUniqueDomain = new String[arrayListUnique.size()];
//        for (int i= 0;i<recordDuplicatesDomain.length; i++){
//            recordDuplicatesDomain[i] = arrayListDuplicate.get(i);
//        }
//        for (int i= 0;i<recordUniqueDomain.length; i++){
//            recordUniqueDomain[i] = arrayListUnique.get(i);
//        }

//        FileWriter fileWriter = new FileWriter(outputFile, true);
//        //header row
//        fileWriter.append(header[2]).append("\n");
//
//        //data row
//        for (String s:arrayListDuplicate) {
//            fileWriter.append(s).append("\n");
//        }
//        fileWriter.close();








    }//main method
}//class