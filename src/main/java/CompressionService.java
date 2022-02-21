import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CompressionService {

    public static boolean resizeImage(String inputImagePath, String outputImagePath) {
        // absolute path to ImageMagick: Command-line Tools: Convert
        String quality = "60%";
        String size = "60%";
        String convertCommand = "convert";

        // Build process to execute convert
        ProcessBuilder pb = new ProcessBuilder(
                convertCommand,
                "-quality",
                quality,
                "-adaptive-resize",
                size,
                inputImagePath,
                outputImagePath);

        pb.redirectErrorStream(true);

        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader( new InputStreamReader(p.getInputStream() ));
            String line = null;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch(Exception e) {
            return false;
        }

        return true;
    }
}
