package com.bsc.mpo.registration;

import com.bsc.mpo.common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by npolca01 on 11/30/2015.
 */
public class RegistrationFunctions {
    String subPath = null;
    static String testCase = null;

    /********************************************************************************************************************/
    public static String registrationSuccess(String needToExecute, String[] inputData, String url,
                                             WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "HappyPath";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                count = enterUsername(driver, inputData[4], subPath, testcaseName, count);
                count = enterEmail(driver, inputData[5], inputData[6], subPath, testcaseName,
                        count);
                count = enterPassword(driver, inputData[7], inputData[8], subPath, testcaseName,
                        count);
                count = enterSecurityQuestionAndAnswer(driver, inputData[9], inputData[10], subPath,
                        testcaseName, count);
                count = enterDeliveryType(driver, inputData[11], inputData[12],
                        inputData[13], subPath, testcaseName, count, testCase);
                //count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                //count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(40000);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                assertTrue(CommonFunctions.isElementPresent(driver,
                        By.xpath("//li/h4[contains(text(),'" + inputData[2] + "')]")));
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
    public static String registrationDifferentPasswords(String needToExecute, String[] inputData,
                                                        String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                        int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "DifferentPasswords";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                count = enterUsername(driver, inputData[4], subPath, testcaseName, count);
                count = enterEmail(driver, inputData[5], inputData[6], subPath, testcaseName,
                        count);
                count = enterPassword(driver, inputData[7], inputData[8], subPath, testcaseName,
                        count);
                count = enterSecurityQuestionAndAnswer(driver, inputData[9], inputData[10], subPath,
                        testcaseName, count);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("Passwords must match in both fields.",
                        driver.findElement(By.id("regConfirmPasswordError")).getText());
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
    public static String registrationSameEmailId(String needToExecute, String[] inputData, String url,
                                                 WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "SameEmailID";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                count = enterUsername(driver, inputData[4], subPath, testcaseName, count);
                count = enterEmail(driver, inputData[5], inputData[6], subPath, testcaseName,
                        count);
                count = enterPassword(driver, inputData[7], inputData[8], subPath, testcaseName,
                        count);
                count = enterSecurityQuestionAndAnswer(driver, inputData[9], inputData[10], subPath,
                        testcaseName, count);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals(
                        "This email is already in use on another account. If that is OK with you, there's no action to take. If that is unexpected, contact us immediately at (877) 932-3375.",
                        driver.findElement(By.xpath("//div[@class='alert-copy']/p")).getText());
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
    public static String registrationSameUsername(String needToExecute, String[] inputData, String url,
                                                  WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "SameUserName";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                count = enterUsername(driver, inputData[4], subPath, testcaseName, count);
                count = enterEmail(driver, inputData[5], inputData[6], subPath, testcaseName,
                        count);
                count = enterPassword(driver, inputData[7], inputData[8], subPath, testcaseName,
                        count);
                count = enterSecurityQuestionAndAnswer(driver, inputData[9], inputData[10], subPath,
                        testcaseName, count);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("The username you entered is in use. Please choose a different username",
                        driver.findElement(By.xpath("//div[@class='alert-copy']/p")).getText());
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
    public static String registrationIncorrectPassword(String needToExecute, String[] inputData,
                                                       String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                       int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "IncorrectPassword";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                count = enterUsername(driver, inputData[4], subPath, testcaseName, count);
                count = enterEmail(driver, inputData[5], inputData[6], subPath, testcaseName,
                        count);
                count = enterPassword(driver, inputData[7], inputData[8], subPath, testcaseName,
                        count);
                count = enterSecurityQuestionAndAnswer(driver, inputData[9], inputData[10], subPath,
                        testcaseName, count);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals(
                        "Password must be 8-20 characters, no spaces, and contain a mix of three of the four types of characters (uppercase and lowercase letters, numbers, and symbols).",
                        driver.findElement(By.xpath("//div[@id='regPasswordError']")).getText());
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
    public static String registrationAlreadyRegistered(String needToExecute, String[] inputData,
                                                       String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                       int row) throws Exception {
        String verificationErrorString = "";
        testCase = "AlreadyRegistered";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("You’re Already Registered", driver.findElement(By.xpath("//h1")).getText());
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
    public static String registrationTwinScenario(String needToExecute, String[] inputData, String url,
                                                  WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "DuplicateDOBEntry";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                count = verifyIdentity(driver, subPath, testcaseName, count);
                count = enterUsername(driver, inputData[4], subPath, testcaseName, count);
                count = enterEmail(driver, inputData[5], inputData[6], subPath, testcaseName,
                        count);
                count = enterPassword(driver, inputData[7], inputData[8], subPath, testcaseName,
                        count);
                count = enterSecurityQuestionAndAnswer(driver, inputData[9], inputData[10], subPath,
                        testcaseName, count);
                count = enterDeliveryType(driver, inputData[11], inputData[12],
                        inputData[13], subPath, testcaseName, count, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(40000);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
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
    public static String registrationCvrgExpiredMoreThan2Yrs(String needToExecute, String[] inputData,
                                                             String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                             int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "CvgExpiredMoreThan2Yrs";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(10000);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                assertEquals("Account Not Available",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "This account is no longer available. For details, please call the member services number found on your ID card. We apologize for any inconvenience.",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p")).getText());
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
    public static String registrationCvrgExpiredLessThan2Yrs(String needToExecute, String[] inputData,
                                                             String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                             int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "CvgExpiredLessThan2Yrs";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(10000);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                assertEquals("Account Not Available",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "This account is no longer available. For details, please call the member services number found on your ID card. We apologize for any inconvenience.",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p")).getText());
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
    public static String registrationGMAPDHicnMismatch(String needToExecute, String[] inputData,
                                                       String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                       int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "GMAPD_HICN_Mismatch";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(10000);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                assertEquals("Login or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals("A technical error has occurred. We are currently working to resolve the issue.",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p")).getText());
                assertEquals(
                        "If you cannot log in after 24 hours, or for any question about your health plan, please call member services on your ID card.",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p[2]")).getText());
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
    public static String registrationGMAPDHicnDelay(String needToExecute, String[] inputData,
                                                    String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                    int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "GMAPD_HICN_Delay";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(10000);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                assertEquals("Login or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals("A technical error has occurred. We are currently working to resolve the issue.",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p")).getText());
                assertEquals(
                        "If you cannot log in after 24 hours, or for any question about your health plan, please call member services on your ID card.",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p[2]")).getText());
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
    public static String registrationBlockedPlans(String needToExecute, String[] inputData,
                                                  String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                  int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "Mem_List_BlockedPlans";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(10000);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                assertEquals("Log In or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "Your group plan does not allow you to register or log in to blueshieldca.com. For more information about your plan, services and benefits, contact your employer or the number on the back of your identification card.",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p")).getText());
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
    public static String registrationIneligibleSharedAdvGrpMember(String needToExecute,
                                                                  String[] inputData, String url, WebDriver driver, String itrResult, String subPath,
                                                                  String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "Ineligible_Shared_Grp_Mem";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(10000);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                assertEquals("Log In or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "Your group plan does not allow you to register or log in to blueshieldca.com. For more information about your plan, services and benefits, contact your employer or the number on the back of your identification card.",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p")).getText());
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
    public static String registrationFEPPPOMember(String needToExecute, String[] inputData, String url,
                                                  WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "FEP_PPO";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(10000);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                assertEquals("Log In or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "Your group plan does not allow you to register or log in to blueshieldca.com. For more information about your plan's services and benefits, please visit FEPBlue.org",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p")).getText());
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
    public static String registrationNascoParMember(String needToExecute, String[] inputData, String url,
                                                    WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "Nasco_Par";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(10000);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                assertEquals("Login or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "Your group plan does not allow you to register or log in to blueshieldca.com. For more information about your plan, services and benefits, contact your employer or the number on the back of your identification card.",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p")).getText());
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
    public static String registrationPrivacyRestriction(String needToExecute, String[] inputData,
                                                        String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                        int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "PrivacyRestriction";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(10000);
                assertEquals("BSCA Member Portal | Register", driver.getTitle());
                assertEquals("Account Not Available",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "This account is currently not available. For details, please call the member services number found on your ID card. We apologize for any inconvenience. ",
                        driver.findElement(By.xpath("//div[@class='copy-instructional']/p")).getText());
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
    public static String registrationIMAPDMember(String needToExecute, String[] inputData, String url,
                                                 WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "IMAPDMem";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                count = enterUsername(driver, inputData[4], subPath, testcaseName, count);
                count = enterEmail(driver, inputData[5], inputData[6], subPath, testcaseName,
                        count);
                count = enterPassword(driver, inputData[7], inputData[8], subPath, testcaseName,
                        count);
                count = enterSecurityQuestionAndAnswer(driver, inputData[9], inputData[10], subPath,
                        testcaseName, count);
                count = enterDeliveryType(driver, inputData[11], inputData[12],
                        inputData[13], subPath, testcaseName, count, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(40000);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                // assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                // assertTrue(CommonFunctions.isElementPresent(driver,
                // By.xpath("//li/h4[contains(text(),'"+inputData[2]+"')]")));
                // assertTrue(driver.findElement(By.linkText("Log
                // Out")).isDisplayed());
                assertEquals("My Blue Shield - Blue Shield of California", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("Welcome,",
                        driver.findElement(By.xpath("//h3[@class='auth_member']/cufon/cufontext")).getText());
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
    public static String RegistrationGMAPDMember(String needToExecute, String[] inputData, String url,
                                                 WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "GMAPDMem";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                count = enterUsername(driver, inputData[4], subPath, testcaseName, count);
                count = enterEmail(driver, inputData[5], inputData[6], subPath, testcaseName,
                        count);
                count = enterPassword(driver, inputData[7], inputData[8], subPath, testcaseName,
                        count);
                count = enterSecurityQuestionAndAnswer(driver, inputData[9], inputData[10], subPath,
                        testcaseName, count);
                count = enterDeliveryType(driver, inputData[11], inputData[12],
                        inputData[13], subPath, testcaseName, count, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(40000);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                // assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                // assertTrue(CommonFunctions.isElementPresent(driver,
                // By.xpath("//li/h4[contains(text(),'"+inputData[2]+"')]")));
                // assertTrue(driver.findElement(By.linkText("Log
                // Out")).isDisplayed());
                assertEquals("My Blue Shield - Blue Shield of California", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("Welcome,",
                        driver.findElement(By.xpath("//h3[@class='auth_member']/cufon/cufontext")).getText());
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
    public static String registrationEligibleSharedAdvMember(String needToExecute, String[] inputData,
                                                             String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                             int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                testCase = "EligibleSharedAdvMem";
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = enterMemberIDandDOB(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                count = enterUsername(driver, inputData[4], subPath, testcaseName, count);
                count = enterEmail(driver, inputData[5], inputData[6], subPath, testcaseName,
                        count);
                count = enterPassword(driver, inputData[7], inputData[8], subPath, testcaseName,
                        count);
                count = enterSecurityQuestionAndAnswer(driver, inputData[9], inputData[10], subPath,
                        testcaseName, count);
                count = enterDeliveryType(driver, inputData[11], inputData[12],
                        inputData[13], subPath, testcaseName, count, testCase);
                count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                count = clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                Thread.sleep(40000);
                assertEquals("BSCA Member Portal | Member Center", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
                assertTrue(CommonFunctions.isElementPresent(driver,
                        By.xpath("//li/h4[contains(text(),'" + inputData[2] + "')]")));
                // assertTrue(driver.findElement(By.linkText("Log
                // Out")).isDisplayed());
                // assertEquals("My Blue Shield - Blue Shield of California",
                // driver.getTitle());
                // CommonFunctions.CaptureScreenshot(driver, subPath,
                // testcaseName, count++);
                // assertEquals("Welcome,",driver.findElement(By.xpath("//h3[@class='auth_member']/cufon/cufontext")).getText());
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
    public static int enterMemberIDandDOB(WebDriver driver, String url, String MemberID, String DOB, String subPath,
                                          String testcaseName, int count, int row, String testCase) throws Exception {
        if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver")) {
            Thread.sleep(5000);
        }
        driver.get(url);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver")
                && CommonFunctions.isElementPresent(driver, By.id("overridelink"))) {
            driver.navigate().to("javascript:document.getElementById('overridelink').click()");
            Thread.sleep(5000);
        }
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        assertEquals("BSCA Member Portal | Login", driver.getTitle());
        driver.findElement(By.id("registerNow")).click();
        Thread.sleep(4000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        assertEquals("BSCA Member Portal | Register", driver.getTitle());
        driver.findElement(By.id("memberID")).clear();
        driver.findElement(By.id("memberID")).sendKeys(MemberID);
        Thread.sleep(4000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        String Date[] = DOB.split("-");

        driver.findElement(By.id("dbMonth_title")).click();
        Thread.sleep(3000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        CommonFunctions.clickOn(driver, "Month");
        Thread.sleep(3000);
        driver.findElement(By.id("dbMonth_title")).click();
        Thread.sleep(3000);
        CommonFunctions.clickOn(driver, "" + Date[1]);
        Thread.sleep(3000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

        driver.findElement(By.id("dbDay_title")).click();
        Thread.sleep(3000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        CommonFunctions.clickOn(driver, "Day");
        Thread.sleep(3000);
        driver.findElement(By.id("dbDay_title")).click();
        Thread.sleep(3000);
        CommonFunctions.clickOnDay(driver, "" + Date[0]);
        Thread.sleep(3000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

        driver.findElement(By.id("dbYear_title")).click();
        Thread.sleep(2000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        CommonFunctions.clickOn(driver, "Year");
        Thread.sleep(2000);
        driver.findElement(By.id("dbYear_title")).click();
        Thread.sleep(2000);
        CommonFunctions.clickOn(driver, "" + Date[2]);
        Thread.sleep(3000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        count = clickContinue(driver, subPath, testcaseName, count);

        if ((testCase.equalsIgnoreCase("AlreadyRegistered") || testCase.equalsIgnoreCase("DuplicateDOBEntry")
                || testCase.equalsIgnoreCase("CvgExpiredMoreThan2Yrs")) || testCase.equalsIgnoreCase("CvgExpiredLessThan2Yrs")
                || testCase.equalsIgnoreCase("GMAPD_HICN_Mismatch") || testCase.equalsIgnoreCase("GMAPD_HICN_Delay")
                || testCase.equalsIgnoreCase("Mem_List_BlockedPlans") || testCase.equalsIgnoreCase("Ineligible_Shared_Grp_Mem")
                || testCase.equalsIgnoreCase("FEP_PPO") || testCase.equalsIgnoreCase("Nasco_Par")
                || testCase.equalsIgnoreCase("PrivacyRestriction")) {
            // Do Nothing Logic optimize is required
        } else {
            assertEquals(MemberID.substring(0, 9),
                    driver.findElement(By.xpath("//div[@class='row']/div/h3")).getText().substring(0, 9));
            if (Date[0].length() == 1) {
                assertEquals(Date[1] + " " + "0" + Date[0] + ", " + Date[2],
                        driver.findElement(By.xpath("//div[@class='row']/div[2]/h3")).getText());
            } else {
                assertEquals(Date[1] + " " + Date[0] + ", " + Date[2],
                        driver.findElement(By.xpath("//div[@class='row']/div[2]/h3")).getText());

            }
        }
        return count;
    }

    /********************************************************************************************************************/
    public static int clickContinue(WebDriver driver, String subPath, String testcaseName, int count) throws Exception {
        driver.findElement(By.xpath("//button[@type='submit']"));
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver")) {
            Thread.sleep(10000);
        }
        Thread.sleep(3000);
        return count;
    }

    /********************************************************************************************************************/
    public static int enterUsername(WebDriver driver, String username, String subPath, String testcaseName, int count)
            throws Exception {
        assertEquals("BSCA Member Portal | Register", driver.getTitle());
        driver.findElement(By.id("regUsername")).clear();
        driver.findElement(By.id("regUsername")).sendKeys(username);
        Thread.sleep(2000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        return count;
    }

    /********************************************************************************************************************/
    public static int enterEmail(WebDriver driver, String email, String confirmEmail, String subPath,
                                 String testcaseName, int count) throws Exception {
        driver.findElement(By.id("regEmail")).clear();
        driver.findElement(By.id("regEmail")).sendKeys(email);
        Thread.sleep(2000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

        driver.findElement(By.id("regConfirmEmail")).clear();
        driver.findElement(By.id("regConfirmEmail")).sendKeys(confirmEmail);
        Thread.sleep(2000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        return count;
    }

    /********************************************************************************************************************/
    public static int enterPassword(WebDriver driver, String password, String confirmPassword, String subPath,
                                    String testcaseName, int count) throws Exception {
        driver.findElement(By.id("regPassword")).clear();
        driver.findElement(By.id("regPassword")).sendKeys(password);
        Thread.sleep(2000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

        driver.findElement(By.id("regConfirmPassword")).clear();
        driver.findElement(By.id("regConfirmPassword")).sendKeys(confirmPassword);
        Thread.sleep(2000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        return count;
    }

    /********************************************************************************************************************/
    public static int enterSecurityQuestionAndAnswer(WebDriver driver, String securityQues, String securityAns, String subPath,
                                                     String testcaseName, int count) throws Exception {
        int questionIndex = Integer.parseInt(securityQues) + 1;
        driver.findElement(By.id("regSecurityQuestion")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='regSecurityQuestion']/option[" + questionIndex + "]")).click();
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
		/*String SecQues[] = null;
		if (securityQues.contains("'")) {
			SecQues = securityQues.split("'");
		}

		CommonFunctions.clickOn(driver, "Choose Security Question");
		Thread.sleep(3000);
		driver.findElement(By.id("regSecurityQuestion")).click();
		Thread.sleep(2000);
		CommonFunctions.clickOn(driver, "" + SecQues[0]);
		Thread.sleep(4000);
		CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
*/
        driver.findElement(By.id("regSecurityAnswer")).clear();
        driver.findElement(By.id("regSecurityAnswer")).sendKeys(securityAns);
        Thread.sleep(2000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        count = clickContinue(driver, subPath, testcaseName, count);
        return count;
    }

    /********************************************************************************************************************/
    public static int enterDeliveryType(WebDriver driver, String deliveryType, String claimsAlert, String agreement,
                                        String subPath, String testcaseName, int count, String testCase) throws Exception {
        assertEquals("BSCA Member Portal | Register", driver.getTitle());
        if (testCase.equalsIgnoreCase("IMAPDMem") || testCase.equalsIgnoreCase("EligibleSharedAdvMem")) {
            // do nothing
        } else {
            if (deliveryType.equalsIgnoreCase("Paperless Delivery")) {
                WebElement elem = driver.findElement(By.xpath("//div[@id='iCheck-r1']/ins"));
                JavascriptExecutor js1 = (JavascriptExecutor) driver;
                js1.executeScript("arguments[0].click();", elem);
                Thread.sleep(2000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
            }

            if (deliveryType.equalsIgnoreCase("U.S. Mail")) {
                WebElement elem = driver.findElement(By.xpath("//div[@id='iCheck-r2']/ins"));
                JavascriptExecutor js1 = (JavascriptExecutor) driver;
                js1.executeScript("arguments[0].click();", elem);
                Thread.sleep(2000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                if (claimsAlert.equalsIgnoreCase("Y")) {
                    WebElement element = driver.findElement(By.xpath("//div[@id='iCheck-c1']/ins"));
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", element);
                    Thread.sleep(2000);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                }
            }
        }

        if (agreement.equalsIgnoreCase("Y")) {
            WebElement elem = driver.findElement(By.xpath("//div[@id='iCheck-c2']/ins"));
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("arguments[0].click();", elem);
            Thread.sleep(2000);
            CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        }
        Thread.sleep(3000);
        //clickContinue(driver, subPath, testcaseName, count);
        return count;
    }

    /********************************************************************************************************************/
    public static int verifyIdentity(WebDriver driver, String subPath, String testcaseName, int count)
            throws Exception {
        Actions action = new Actions(driver);
        assertEquals("BSCA Member Portal | Register", driver.getTitle());
        assertEquals("We found more than one member with the same information.\nPlease choose your name from the list.",
                driver.findElement(By.xpath("//div[@class='alert-copy']/p")).getText());
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//span[@class='ddArrow arrowoff']")));
        action.perform();
        Thread.sleep(2000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        action.click(driver.findElement(By.xpath("//div[@id='selectedMember_child']/ul/li[2]/span")));
        action.perform();
        Thread.sleep(2000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        clickContinue(driver, subPath, testcaseName, count);
        return count;
    }

}
