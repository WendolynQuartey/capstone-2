package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static void saveReceipt(Order o, LocalDateTime rightNow) {
        try {
            String now = rightNow.format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/receipts/" + now + ".txt"));
            bufferedWriter.write(o.getReceiptDetails(o));
            bufferedWriter.close();
        } catch(FileNotFoundException e){
            System.err.println("❌File has not been found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
