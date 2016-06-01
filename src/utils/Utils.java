package utils;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by adrien on 12/05/16.
 * EducationGame project class
 */
public class Utils {

    //method to load a file as string
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();

        //try to load file
        try {

            //put file from path into buffer
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine())!=null)
                builder.append(line+System.lineSeparator());
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    //method to change string numbers into int numbers
    public static int parseInt(String number){
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

}
