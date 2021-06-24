package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FeatureToggle {
  public static void main(String[] args) throws IOException {
    // run main
    formatter();
  }

  public static String readStringFromFile(String filePath) throws IOException {
    return new String(Files.readAllBytes(Paths.get(filePath)));
  }

  public static void formatter() throws IOException {
    String string;
    {
      string = readStringFromFile("main/resources/ADD_HERE_Dealers_IDs_From_The_New_Request.txt");
    }

    String[] json = {""};

    new BufferedReader(new StringReader(string))
        .lines()
        .forEach(
            dealer -> {
              String temp = json[0] + "{\"whitelistValue\": \"" + dealer + "\"},";
              json[0] = temp;
            });

    String newRequest = "[" + json[0] + "]";

    // Print the new request formatted.  Copy the output
    System.out.println(newRequest);
  }
}
