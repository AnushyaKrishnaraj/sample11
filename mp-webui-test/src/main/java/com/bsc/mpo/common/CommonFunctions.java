package com.bsc.mpo.common;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.hssf.usermodel.HSSFDataFormat;
/**
 * Created by npolca01 on 11/30/2015.
 */
public class CommonFunctions {

    private static StringBuffer verificationErrors = new StringBuffer();

    public static String[] readFromEnvironmentFile(String Absfilepath) throws IOException {
        int i;
        String[] a1Val = null;
        FileInputStream fileInputStream = null;
        try {
            String envfilepath = Absfilepath.substring(0, Absfilepath.lastIndexOf("\\"));
            fileInputStream = new FileInputStream(envfilepath + "\\EnvironmentFile.xls");
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet worksheet = workbook.getSheet("File_Locations");
            int rowNum = worksheet.getLastRowNum() + 1;

            a1Val = new String[rowNum];
            for (i = 1; i < rowNum; i++) {
                HSSFRow row = worksheet.getRow(i);
                HSSFCell cellA1 = row.getCell(1);
                a1Val[i] = cellA1.getStringCellValue();            }
                fileInputStream.close();
            } catch (Error e) {
                fileInputStream.close();
                verificationErrors.append(e.toString());
            } catch (Exception e) {
                fileInputStream.close();
                verificationErrors.append(e.toString());
            }
        return a1Val;
    }

    public static String[][] readFromInputSheet(String inputFileLoc, String sheetName) throws IOException {
        FileInputStream fis = null;
        String[][] dataval = null;
        try {
            inputFileLoc = inputFileLoc + "\\InputDataSheet.xls";
            File excel = new File(inputFileLoc);
            fis = new FileInputStream(excel);
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet ws = wb.getSheet(sheetName);

            int rowNum = ws.getLastRowNum() + 1;
            int colNum = ws.getRow(0).getLastCellNum();
            dataval = new String[rowNum][colNum];
            for (int i = 0; i < rowNum; i++) {
                HSSFRow row = ws.getRow(i);
                for (int j = 0; j < colNum; j++) {
                    HSSFCell cell = row.getCell(j);
                    cell.setCellType(cell.CELL_TYPE_STRING);
                    String value = cell.toString();
                    dataval[i][j] = value;
                }
            }
        } catch (Error e) {
            fis.close();
            verificationErrors.append(e.toString());
        } catch (Exception e) {
            fis.close();
            verificationErrors.append(e.toString());
        }
        fis.close();
        return dataval;
    }

    public static String[] findInputDataForCurrentIteration(String[][] noOfIterations, int currrow, int colCount)
            throws Exception {
        String[] rowElements = new String[colCount];
        for (int col = 0; col < colCount; col++) {
            rowElements[col] = noOfIterations[currrow][col];
        }
        return rowElements;
    }

    public static void writeToOutputSheet(String outputFileLoc, String[][] noOfIterations, int currentRow, int colCount,
                                          String itrResult, String sheetName) throws IOException {
        try {
            outputFileLoc = outputFileLoc + "\\OutputDataSheet.xls";
            File excel = new File(outputFileLoc);
            FileInputStream fileOut = new FileInputStream(excel);
            HSSFWorkbook workbook = new HSSFWorkbook(fileOut);
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            HSSFSheet ws = workbook.getSheet(sheetName);
            cellStyle = workbook.createCellStyle();

            String resultDescription = "";
            String[] rowData = new String[colCount];
            HSSFRow row1 = ws.createRow(currentRow);
            for (int col = 0; col < colCount; col++) {
                HSSFCell cellA1 = row1.createCell(col);
                rowData[col] = noOfIterations[currentRow][col];
                cellA1.setCellValue(rowData[col]);
            }

            if (!itrResult.equalsIgnoreCase("Not Executed")) {
                if (!itrResult.equalsIgnoreCase("Passed")) {
                    resultDescription = itrResult.substring(7);
                    itrResult = "Failed";
                }
            }
            HSSFCell cellA1 = row1.createCell(colCount);
            HSSFCell cellA2 = row1.createCell(colCount + 1);
            cellA1.setCellValue(itrResult);
            cellA2.setCellValue(resultDescription);

            if (itrResult.equalsIgnoreCase("Failed")) {
                cellStyle.setFillForegroundColor(HSSFColor.RED.index);
                cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            }

            else if (itrResult.equalsIgnoreCase("Not Executed")) {
                cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
                cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            }

            else if (itrResult.equalsIgnoreCase("Passed")) {
                cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
                cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            }

            cellA1.setCellStyle(cellStyle);
            cellA2.setCellStyle(cellStyle);

            fileOut.close();
            FileOutputStream outputFile = new FileOutputStream(excel);
            HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
            workbook.write(outputFile);

            outputFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String[] findFileLocation(File file, int row, String[][] numofiterations, String[] fileLocations)
            throws IOException {
        try {
            String absFilepath = file.getAbsolutePath();
            fileLocations = readFromEnvironmentFile(absFilepath);
        } catch (Error e) {
            System.out.println(e);
            verificationErrors.append(e.toString());
        }
        return fileLocations;
    }

    public static WebDriver getBrowser(WebDriver driver, String[] browDesc, String driverLoc) {
        if (browDesc[0].equalsIgnoreCase("Firefox")) {
            driver = getFirefoxBrowser(driver);
        }

        if (browDesc[0].equalsIgnoreCase("IE") || browDesc[0].equalsIgnoreCase("InternetExplorer")) {
            driver = getIEBrowser(driver, driverLoc);
        }

        if (browDesc[0].equalsIgnoreCase("Chrome")) {
            driver = getChromeBrowser(driver, driverLoc);
        }

        return driver;
    }

    public static WebDriver getFirefoxBrowser(WebDriver driver) {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(true);
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getIEBrowser(WebDriver driver, String driverLoc) {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("native events", true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, false);
        System.setProperty("webdriver.ie.driver", driverLoc + "\\IEDriverServer.exe");
        driver = new InternetExplorerDriver(capabilities);
        return driver;
    }

    public static WebDriver getChromeBrowser(WebDriver driver, String driver_Loc) {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", driver_Loc + "\\chromedriver.exe");
        options.addArguments("--no-sandbox");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.binary", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        capabilities.setCapability("nativeEvents", false);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        return driver;
    }

    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static String createFolder(String folderLoc, String newFolder) throws Exception {
        File dir = new File(folderLoc + "\\" + newFolder);
        if (!dir.exists()) {
            dir.mkdir();
        }

        String folderName = folderLoc + "\\" + newFolder;
        return folderName;
    }

	/*
	 * public static String createScreenshotSubFolder(String className, String
	 * folderLoc) { File dir = new File(folderLoc+"\\"+ className);
	 * if(!dir.exists()) { dir.mkdir(); } String SubFolder_Name=folderLoc+"\\"+
	 * className; return SubFolder_Name; }
	 */

	/*
	 * public static String CreateDirStructure(String FolderLoc,String
	 * Class_Name) throws Exception { File dir=new
	 * File(FolderLoc+"\\"+Class_Name);
	 *
	 * if(!dir.exists()) { dir.mkdir(); }
	 *
	 * String Folder_Name=FolderLoc+"\\"+Class_Name; return Folder_Name; }
	 */

    public static void captureScreenshot(WebDriver driver, String Folder_Name, String Method_Name, int count)
            throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(Folder_Name + "\\" + count + "_" + Method_Name + ".png"));
    }

    public static void deleteScreenshotFolder(String folderLoc) {
        File dir = new File(folderLoc);
        dir.delete();
    }

    public static String closure(String moduleName, String oldName, Date date, String outputSheetPath, WebDriver driver,
                                 String folderName, int row, String itrResult) throws Exception {
        if ((moduleName.equalsIgnoreCase("Login") && row == 22)
                || (moduleName.equalsIgnoreCase("Registration") && row == 21)
                || (moduleName.equalsIgnoreCase("MemberCenter") && row == 13)
                || (moduleName.equalsIgnoreCase("IFP") && row == 28)) {
            driver.quit();
            File oldDir = new File(oldName);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy__HH-mm-ss");
            File newName = new File(oldName + "_" + dateFormat.format(date));

            if (oldDir.isDirectory()) {
                FileUtils.moveDirectory(oldDir, newName);
            }

            File oldOutputSheet = new File(outputSheetPath + "\\OutputDataSheet.xls");
            String oldOutputSheetTemp = outputSheetPath + "\\OutputDataSheet";
            File newoutputSheetName = new File(oldOutputSheetTemp + "_" + dateFormat.format(date) + ".xls");
            FileUtils.copyFile(oldOutputSheet, newoutputSheetName);
            if (oldOutputSheet.isFile()) {
                oldOutputSheet.delete();
            }

            File oldFolderName = new File(folderName);
            File newFolderName = new File(oldFolderName + "_" + dateFormat.format(date));
            if (oldFolderName.isDirectory()) {
                FileUtils.moveDirectory(oldFolderName, newFolderName);
            }

        } else if (!itrResult.equalsIgnoreCase("Not Executed")) {
            try {
                closeChildWindows(driver);

                if (isElementPresent(driver, By.id("ap_logout_icon"))) {
                    if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver")) {
                        // Thread.sleep(5000);
                    }
                    driver.findElement(By.id("ap_logout_icon")).click();
                    Thread.sleep(2000);
                }
            } catch (Exception e) {

            }
        }

        return "Passed";
    }

    public static String logout(String moduleName, String oldName, Date date, String outputSheetPath, WebDriver driver,
                                String folderName, int row, String itrResult) throws Exception {
        if (!itrResult.equalsIgnoreCase("Not Executed")) {
            try {
                closeChildWindows(driver);

                if (isElementPresent(driver, By.id("ap_logout_icon"))) {
                    if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver")) {
                        // Thread.sleep(5000);
                    }
                    driver.findElement(By.id("ap_logout_icon")).click();
                    Thread.sleep(2000);
                }
            } catch (Exception e) {

            }
        }
        return "Passed";
    }

    public static void closeSuite(String moduleName, String oldName, Date date, String outputSheetPath,
                                  WebDriver driver, String folderName) throws Exception {
        System.out.println(moduleName+ "  " + oldName + " " + outputSheetPath + " " + folderName);

        driver.quit();
        File oldDir = new File(oldName);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy__HH-mm-ss");
        File newName = new File(oldName + "_" + dateFormat.format(date));

        if (oldDir.isDirectory()) {
            FileUtils.moveDirectory(oldDir, newName);
        }

        File oldOutputSheet = new File(outputSheetPath + "\\OutputDataSheet.xls");
        String oldOutputSheetTemp = outputSheetPath + "\\OutputDataSheet";
        File newOutputSheetName = new File(oldOutputSheetTemp + "_" + dateFormat.format(date) + ".xls");
        FileUtils.copyFile(oldOutputSheet, newOutputSheetName);
        if (oldOutputSheet.isFile()) {
            oldOutputSheet.delete();
        }

        File oldFolderName = new File(folderName);
        File newFolderName = new File(oldFolderName + "_" + dateFormat.format(date));
        if (oldFolderName.isDirectory()) {
            FileUtils.moveDirectory(oldFolderName, newFolderName);
        }

    }

    public static void copyFile(String dataSheetPath, String Input_EnvfilePath, String outputPath,
                                String Drivers_EnvfilePath) throws Exception {
        File srcOutputFile = new File(dataSheetPath + "\\OutputDataSheet.xls");
        File destOutputFile = new File(outputPath + "\\OutputDataSheet.xls");
        FileUtils.copyFile(srcOutputFile, destOutputFile);

        File oldDir = new File(dataSheetPath + "\\Drivers");
        File newName = new File(Drivers_EnvfilePath);

        if (!(newName.exists())) {
            FileUtils.copyDirectory(oldDir, newName);
        }
    }

    public static void clickOn(WebDriver driver, String Element) throws Exception {
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.xpath("//span[contains(text(),'" + Element + "')]")));
        action.perform();
        Thread.sleep(2000);
    }

    public static void clickOnDay(WebDriver driver, String Element) throws Exception {
        Actions action = new Actions(driver);
        int day = Integer.parseInt(Element);
        action.click(driver.findElement(By.xpath("//div[@id='dbDay_child']/ul/li/following::li[" + day + "]/span")));
        action.perform();
        Thread.sleep(1000);
    }

    public static void scrollToView(WebDriver driver, String Element) throws Exception {
        if (isElementPresent(driver, By.xpath(Element))) {
            WebElement element = driver.findElement(By.xpath(Element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(5000);
        }
    }

    public static void deleteRegistrationData(String fileLoc, String memberID) throws Exception {
        Runtime.getRuntime().exec("wscript " + fileLoc + "\\deleteQueries.vbs " + memberID);
    }

    public static void switchWindow(WebDriver driver) throws Exception {
        Set<String> allWindows = driver.getWindowHandles();
        for (String currentWindow : allWindows) {
            driver.switchTo().window(currentWindow);
        }
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    public static void closeChildWindows(WebDriver driver) {
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> i = ids.iterator();
        String parentId = i.next();
        while (i.hasNext()) {
            driver.switchTo().window(i.next());
            driver.close();
        }
        driver.switchTo().window(parentId);
    }
}
