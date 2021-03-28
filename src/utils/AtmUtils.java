package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AtmUtils {

    public static Path getRepoDirectory(){
        return Paths.get("src/data/");
    }

    public static Path getRepoDirectory(String fileName){
        return Paths.get("src/data/", fileName);
    }

    public static long countLines(String fileName){
        try {
            if(Files.exists(getRepoDirectory(fileName)))
                return Files.lines(getRepoDirectory(fileName)).skip(1).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void emptyFile(String file){
        try {
            Files.deleteIfExists(getRepoDirectory(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
