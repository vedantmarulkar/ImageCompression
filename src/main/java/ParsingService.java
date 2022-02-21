import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

public class ParsingService {

    public static void parse() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String rawFolder = "raw image folder path";
        String resizedFolder = "resized image folder path";
        String input = "input csv file path";
        String output = "output csv file path";

        List<LinkDTO> beans = new CsvToBeanBuilder(new FileReader(input)).withType(LinkDTO.class).build().parse();

        int i = 1;
        for (LinkDTO bean : beans) {
            if (bean.getDownloaded_path() == null || bean.getDownloaded_path().equals("")) {

                String outputFileName = bean.getImage_url();
                ImageDownloadService.saveImage(bean.getImage_url(), rawFolder + outputFileName);
                bean.setDownloaded_path(rawFolder + outputFileName);
                if (bean.getResized() == null || bean.getResized().equals("")) {
                    CompressionService.resizeImage(rawFolder + outputFileName, resizedFolder + outputFileName);
                    bean.setResized("TRUE");
                    i++;
                }
            }
            if (i == 100) break;
        }

        //Write status to CSV
        Writer writer = new FileWriter(output);
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();
        beanToCsv.write(beans);
        writer.close();
    }
}
