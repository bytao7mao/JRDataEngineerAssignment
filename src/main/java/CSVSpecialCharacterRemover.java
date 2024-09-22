import java.io.*;


public class CSVSpecialCharacterRemover {
    public static void main(String[] args) {
        String inputFile = Main.fileWebsite;
        String outputFile = Main.outputFile;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                // Remove special characters from the line
                String cleanedLine = line.replaceAll(",", " ");
                writer.write(cleanedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("CSV file cleaned!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
