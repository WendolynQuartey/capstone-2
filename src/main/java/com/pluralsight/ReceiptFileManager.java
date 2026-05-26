package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReceiptFileManager {

    public void saveReciept(Order o, LocalDateTime rightNow) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/" + rightNow + ".text"));

        } catch(FileNotFoundException e){
            System.err.println("❌File had not been found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
