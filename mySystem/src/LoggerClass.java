import java.io.*;

public class LoggerClass {
    public void logToFile(String str){
        try {
            File file = new File("log.txt");
            if(file.createNewFile()){
                System.out.println("Created Log File");
            }
            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write(str+"\n");
            myWriter.close();
        } catch (IOException  e) {
            System.out.println("An error occurred.");
        }
    }
}
