package com.bsc.mpo.membercenter;
import com.bsc.mpo.common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by npolca01 on 11/30/2015.
 */
public class MembercenterFunctions {
    String subPath = null;

    /********************************************************************************************************************/
    public static String membercenterClaims(String needToExecute, String[] inputData, String url,
                                            WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                assertEquals("Patient Responsibility",
                        driver.findElement(By.xpath("//h2[contains(text(),'Claims')]/following::h4")).getText());
                assertEquals("Total billed",
                        driver.findElement(By.xpath("//h2[contains(text(),'Claims')]/following::h4[2]")).getText());
                CommonFunctions.scrollToView(driver, "//h2[contains(text(),'Claims')]");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed());
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static String membercenterCommonCopays(String needToExecute, String[] inputData, String url,
                                                  WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                assertEquals("Your Common Copayments",
                        driver.findElement(By.xpath("//a[contains(@href,'common-copay')]")).getText());
                assertTrue(driver.findElement(By.id("collapse-common-copay-drawer")).isDisplayed());
                CommonFunctions.scrollToView(driver, "//a[contains(@href,'common-copay')]");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed());
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static String membercenterDeductiblesOOPFamilyPlan(String needToExecute, String[] inputData,
                                                              String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                              int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                assertEquals("Deductibles / Copayment Maximums",
                        driver.findElement(By.xpath("//form[@id='filterForm']/div/h2")).getText());
                assertEquals("Annual Deductibles",
                        driver.findElement(By.xpath("//div[@id='parentAccumulatorDiv']/div/div/h3")).getText());
                assertEquals("Annual Copayment Maximums",
                        driver.findElement(By.xpath("//div[@id='parentAccumulatorDiv']/div[3]/div/h3")).getText());
                CommonFunctions.scrollToView(driver, "//form[@id='filterForm']/div/h2");
                Thread.sleep(4000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By
                        .xpath("//button[@class='btn dropdown-toggle selectpicker btn-default']/span[contains(text(),'Family')]"))
                        .click();
                Thread.sleep(4000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.xpath("//ul[@class='dropdown-menu inner selectpicker']/li[2]/a")).click();
                Thread.sleep(25000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("Deductibles / Copayment Maximums",
                        driver.findElement(By.xpath("//form[@id='filterForm']/div/h2")).getText());
                assertEquals("Annual Deductibles",
                        driver.findElement(By.xpath("//div[@id='parentAccumulatorDiv']/div/div/h3")).getText());
                assertEquals("Annual Copayment Maximums",
                        driver.findElement(By.xpath("//div[@id='parentAccumulatorDiv']/div[3]/div/h3")).getText());
                assertFalse(CommonFunctions.isElementPresent(driver, By.xpath(
                        "//button[@class='btn dropdown-toggle selectpicker btn-default']/span[contains(text(),'Family')]")));
                Thread.sleep(8000);
                CommonFunctions.scrollToView(driver, "//form[@id='filterForm']/div/h2");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed());
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static String membercenterDeductiblesOOPIndividualPlan(String needToExecute, String[] inputData,
                                                                  String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                                  int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                assertEquals("Deductibles / Copayment Maximums",
                        driver.findElement(By.xpath("//form[@id='filterForm']/div/h2")).getText());
                assertEquals("Annual Deductibles",
                        driver.findElement(By.xpath("//div[@id='parentAccumulatorDiv']/div/div/h3")).getText());
                CommonFunctions.scrollToView(driver, "//form[@id='filterForm']/div/h2");
                Thread.sleep(4000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertFalse(CommonFunctions.isElementPresent(driver, By.xpath(
                        "//button[@class='btn dropdown-toggle selectpicker btn-default']/span[contains(text(),'Family')]")));
                assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed());
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static String membercenterDeductiblesOOPFirstDollar(String needToExecute, String[] inputData,
                                                               String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                               int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                assertEquals("Deductibles / Copayment Maximums",
                        driver.findElement(By.xpath("//form[@id='filterForm']/div/h2")).getText());
                assertEquals("Annual Deductibles",
                        driver.findElement(By.xpath("//div[@id='parentAccumulatorDiv']/div/div/h3")).getText());
                CommonFunctions.scrollToView(driver, "//form[@id='filterForm']/div/h2");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed());
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static String membercenterPharmacyAccumulators(String needToExecute, String[] inputData,
                                                          String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                          int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'My Plan & Claims')]")));
                actions.build().perform();
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                driver.findElement(By.linkText("Claims")).click();
                Thread.sleep(15000);
                assertEquals("Claims Summary", driver.findElement(By.xpath("//h1")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By
                        .xpath("//button[@class='btn dropdown-toggle selectpicker btn-default']/span[contains(text(), 'Family')]"))
                        .click();
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.xpath("//ul[@class='dropdown-menu inner selectpicker']/li[2]/a")).click();
                Thread.sleep(30000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By
                        .xpath("//button[@class='btn dropdown-toggle selectpicker btn-default']/span[contains(text(),'Medical')]"))
                        .click();
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.xpath("//span[contains(text(),'Pharmacy')]")).click();
                Thread.sleep(20000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed());
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static String membercenterCarouselHEQ(String needToExecute, String[] inputData, String url,
                                                 WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                // assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.linkText("HealthEquity Website")).click();
                Thread.sleep(15000);
                CommonFunctions.switchWindow(driver);
                if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver")
                        && CommonFunctions.isElementPresent(driver, By.id("overridelink"))) {
                    driver.navigate().to("javascript:document.getElementById('overridelink').click()");
                }
                Thread.sleep(15000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.linkText("My Health")).isDisplayed();
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static String membercenterPaymentSectionCarousel(String needToExecute, String[] inputData,
                                                            String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                            int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                // assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                driver.findElement(By.xpath("//li[contains(text(),'Payments')]")).click();
                Thread.sleep(8000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                assertEquals("Your Payments", driver.findElement(By.xpath("//div[@class='payments']/div")).getText());
                assertTrue(driver
                        .findElement(By
                                .xpath("//div[@class='payments']/div/following::a[contains(text(),'Payment Center')]"))
                        .isDisplayed());
                assertTrue(driver.findElement(By.linkText("Billing FAQs")).isDisplayed());
                CommonFunctions.scrollToView(driver, "//div[@class='payments']/div");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static String membercenterDeductibleSectionCarousel(String needToExecute, String[] inputData,
                                                               String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                               int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                // assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                driver.findElement(By.xpath("//li[contains(text(),'Deductible')]")).click();
                Thread.sleep(2000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                assertEquals("Your Deductible - Preferred/Participating Provider",
                        driver.findElement(
                                By.xpath("//div[contains(@class,'item')]/div/div[@class='carousel-caption']/div"))
                                .getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static String membercenterCopaymentSectionCarousel(String needToExecute, String[] inputData,
                                                              String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                              int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                // assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                driver.findElement(By.xpath("//li[contains(text(),'Copayment')]")).click();
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                assertEquals("Your Copayment Maximum - Preferred/Participating Provider",
                        driver.findElement(
                                By.xpath("//div[@class='item active']/div/div[@class='carousel-caption']/div"))
                                .getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
            } else {
                itrResult = "Not Executed";
            }
        } catch (Error e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        } catch (Exception e) {
            verificationErrorString = e.toString();
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }

        if (!"".equals(verificationErrorString)) {
            itrResult = "Failed" + verificationErrorString;

        }
        return itrResult;
    }

    /********************************************************************************************************************/
    public static int loginSteps(WebDriver driver, String url, String username, String password, String subPath,
                                 String testcaseName, int count, int row) throws Exception {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver")
                && CommonFunctions.isElementPresent(driver, By.id("overridelink"))) {
            driver.navigate().to("javascript:document.getElementById('overridelink').click()");
            Thread.sleep(5000);
        }
        if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.chrome.ChromeDriver")) {
            Thread.sleep(5000);
        }
        assertEquals("BSCA Member Portal | Login", driver.getTitle());
        driver.findElement(By.id("username")).clear();
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        driver.findElement(By.id("username")).sendKeys(username);
        Thread.sleep(4000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        Thread.sleep(4000);
        driver.findElement(By.id("loginSubmit")).click();
        if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver")
                || driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.chrome.ChromeDriver")) {
            Thread.sleep(60000);
        }
        return count;
    }

}
