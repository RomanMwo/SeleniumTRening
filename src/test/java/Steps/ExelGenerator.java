package Steps;


import framework.BaseTest;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;


public class ExelGenerator extends BaseTest {


    public static void main(String[] args) {

        //updateExelErrandsForRollout("src\\test\\resources\\errands.xlsx", "src\\test\\resources\\stages.xlsx", 0);
        updateCommeqExel("src\\test\\resources\\commeq.xlsx", 0);

    }


    public static void updateExelErrandsForRollout(String errandsFilePath, String stagesFilePath, int cellIndex) {

        Random generator = new Random();

        // List contains unique value meter Id for both file Errand and stages.
        List<String> uniqueMetersId = new ArrayList<>();

        for (int i = 1; i < 200; i++) {
            String result = "Auto" + LocalDate.now() + "-" + generator.nextInt(10000);
            uniqueMetersId.add(result);
        }

        try {
            // Obtain a workbook from the excel file
            FileInputStream inputStreamErrands = new FileInputStream(new File(errandsFilePath));
            FileInputStream inputStreamStages = new FileInputStream(new File(stagesFilePath));
            Workbook workbookErrands = WorkbookFactory.create(inputStreamErrands);
            Workbook workbookStages = WorkbookFactory.create(inputStreamStages);
            // Get Sheet at index 0
            Sheet sheetErrands = workbookErrands.getSheetAt(0);
            Sheet sheetStages = workbookStages.getSheetAt(0);
            // Get number of rows
            int numberRows = sheetErrands.getLastRowNum();
            // iterate trough the rows to update cell of specific cellIndex
            for (int i = 1; i <= numberRows; i++) {
                Row rowErrands = sheetErrands.getRow(i);
                Row rowStages = sheetStages.getRow(i);
                // Create the row if it doesn't exist
                if (rowErrands == null)
                    rowErrands = sheetErrands.createRow(i);
                if (rowStages == null)
                    rowStages = sheetErrands.createRow(i);

                Cell cellErrands = rowErrands.getCell(cellIndex);
                Cell cellStages = rowStages.getCell(cellIndex);

                // Create the cell if it doesn't exist
                if (cellErrands == null)
                    cellErrands = rowErrands.createCell(cellIndex);
                if (cellStages == null)
                    cellStages = rowStages.createCell(cellIndex);
                //String result = "Auto" + LocalDate.now() + "-" + generator.nextInt(10000);
                cellErrands.setCellValue(uniqueMetersId.get(i));
                cellStages.setCellValue(uniqueMetersId.get(i));

            }

            inputStreamErrands.close();
            inputStreamStages.close();
            // Write the output to the file
            FileOutputStream fileOutErrands = new FileOutputStream(errandsFilePath);
            FileOutputStream fileOutStages = new FileOutputStream(stagesFilePath);
            // write and close workbooks
            workbookErrands.write(fileOutErrands);
            workbookStages.write(fileOutStages);
            workbookErrands.close();
            workbookStages.close();
            //close output stream
            fileOutErrands.close();
            fileOutStages.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (EncryptedDocumentException ex) {
            ex.printStackTrace();
        }


//        Random generator = new Random();
//
//        // List contains unique value meter Id for both file Errand and stages.
//        List<String> uniqueMetersId = new ArrayList<>();
//
//        for (int i = 1; i <200; i++) {
//            String result = "Auto" + LocalDate.now() + "-" + generator.nextInt(10000);
//            uniqueMetersId.add(result);
//        }
//
//        try {
//            // Obtain a workbook from the excel file
//            FileInputStream inputStream = new FileInputStream(new File(errandsFilePath));
//            Workbook workbook = WorkbookFactory.create(inputStream);
//            // Get Sheet at index 0
//            Sheet sheet = workbook.getSheetAt(0);
//            // Get number of rows
//            int numberRows = sheet.getLastRowNum();
//            // iterate trough the rows to update cell of specific cellIndex
//            for (int i = 1; i <= numberRows; i++) {
//                Row row = sheet.getRow(i);
//                // Create the row if it doesn't exist
//                if (row == null)
//                    row = sheet.createRow(i);
//
//                Cell cell = row.getCell(cellIndex);
//
//                // Create the cell if it doesn't exist
//                if (cell == null)
//                    cell = row.createCell(cellIndex);
//                //String result = "Auto" + LocalDate.now() + "-" + generator.nextInt(10000);
//                cell.setCellValue(uniqueMetersId.get(i));
//            }
//
//            inputStream.close();
//            // Write the output to the file
//            FileOutputStream fileOut = new FileOutputStream(errandsFilePath);
//            workbook.write(fileOut);
//            workbook.close();
//            fileOut.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (EncryptedDocumentException ex) {
//            ex.printStackTrace();
//        }
//
//        try {
//            // Obtain a workbook from the excel file
//            FileInputStream inputStream = new FileInputStream(new File(stagesFilePath));
//            Workbook workbook = WorkbookFactory.create(inputStream);
//            // Get Sheet at index 0
//            Sheet sheet = workbook.getSheetAt(0);
//            // Get number of rows
//            int numberRows = sheet.getLastRowNum();
//            // iterate trough the rows to update cell of specific cellIndex
//            for (int i = 1; i <= numberRows; i++) {
//                Row row = sheet.getRow(i);
//                // Create the row if it doesn't exist
//                if (row == null)
//                    row = sheet.createRow(i);
//
//                Cell cell = row.getCell(cellIndex);
//
//                // Create the cell if it doesn't exist
//                if (cell == null)
//                    cell = row.createCell(cellIndex);
//               // String result = "Auto" + LocalDate.now() + "-" + generator.nextInt(10000);
//                cell.setCellValue(uniqueMetersId.get(i));
//            }
//
//            inputStream.close();
//            // Write the output to the file
//            FileOutputStream fileOut = new FileOutputStream(stagesFilePath);
//            workbook.write(fileOut);
//            workbook.close();
//            fileOut.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (EncryptedDocumentException ex) {
//            ex.printStackTrace();
//        }
    }

    public static void updateCommeqExel(String commeqFilePath, int cellIndex) {

        Random generator = new Random();
        try {
            // Obtain a workbook from the excel file
            FileInputStream inputStream = new FileInputStream(new File(commeqFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            // Get Sheet at index 0
            Sheet sheet = workbook.getSheetAt(0);
            // Get number of rows
            int numberRows = sheet.getLastRowNum();
            // iterate trough the rows to update cell of specific cellIndex
            for (int i = 1; i <= numberRows; i++) {
                Row row = sheet.getRow(i);
                // Create the row if it doesn't exist
                if (row == null)
                    row = sheet.createRow(i);

                Cell cell = row.getCell(cellIndex);

                // Create the cell if it doesn't exist
                if (cell == null)
                    cell = row.createCell(cellIndex);
                String uniqueId = "Auto" + LocalDate.now() + "-" + generator.nextInt(10000);
                cell.setCellValue(uniqueId);
            }

            inputStream.close();
            // Write the output to the file
            FileOutputStream fileOut = new FileOutputStream(commeqFilePath);
            workbook.write(fileOut);
            workbook.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }
}


