package com.bsc.mpo.login;
import com.bsc.mpo.common.CommonFunctions;
import com.bsc.mpo.registration.RegistrationFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

 /**
 * Created by npolca01 on 11/30/2015.
 */
public class LoginFunctions {
    String subPath = null;

    /********************************************************************************************************************/
    public static String loginSuccess(String needToExecute, String[] inputData, String url, WebDriver driver,
                                      String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                // assertEquals("BSCA Member Portal | Member Center",
                // driver.getTitle());
                assertTrue(Pattern.compile("Hi.*").matcher(driver.findElement(By.cssSelector("h1")).getText()).find());
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
    public static String loginInvalidUser(String needToExecute, String[] inputData, String url, WebDriver driver,
                                          String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals(
                        "The information does not match our records. Please try again or call us at (800) 393-6130, Monday through Friday, 8 AM to 5:30 PM PST.",
                        driver.findElement(By.xpath("//div[@class='alert-copy']/p")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String loginAccountNotAvailable(String needToExecute, String[] inputData, String url,
                                                  WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals("Account Not Available",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "This account is currently not available. For details, please call the member services number found on your ID card. We apologize for any inconvenience. ",
                        driver.findElement(By.xpath("//div[@class='text-center']/p[2]")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String loginLegacyMember(String needToExecute, String[] inputData, String url, WebDriver driver,
                                           String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                Thread.sleep(10000);
                assertEquals("My Blue Shield - Blue Shield of California", driver.getTitle());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                // assertEquals("Welcome,",driver.findElement(By.xpath("//h3[@class='auth_member']/cufon/cufontext")).getText());
                // assertTrue(driver.findElement(By.linkText("Log
                // Out")).isDisplayed());
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
    public static String loginTechnicalError(String needToExecute, String[] inputData, String url, WebDriver driver,
                                             String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals("Login or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals("A technical error has occurred. We are currently working to resolve the issue.",
                        driver.findElement(By.xpath("//p[@class='copy-success']/following::p")).getText());
                assertEquals(
                        "If you cannot log in after 24 hours, or for any question about your health plan, please call member services on your ID card.",
                        driver.findElement(By.xpath("//p[@class='copy-success']/following::p[2]")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String loginNotAllowedGroup(String needToExecute, String[] inputData, String url, WebDriver driver,
                                              String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals("Login or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "Your group plan does not allow you to register or log in to blueshieldca.com. For more information about your plan, services and benefits, contact your employer or the number on the back of your identification card.",
                        driver.findElement(By.xpath("//div[@class='text-center']/p[2]")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String loginEmailIsBlank(String needToExecute, String[] inputData, String url, WebDriver driver,
                                           String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals("Update Email Address",
                        driver.findElement(By.xpath("//div[@class=' text-center']/h1")).getText());
                assertEquals("Please update your email address and reset your email preferences.",
                        driver.findElement(By.xpath("//div[@class='alert-copy']/p")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Update Email", driver.getTitle());
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
    public static String resetTempPassword(String needToExecute, String[] inputData, String url, WebDriver driver,
                                           String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals("Change Your Password",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals("Please replace the temporary password with a new one for your account.",
                        driver.findElement(By.xpath("//div[@class='alert-copy']/p")).getText());
                assertEquals("Update Your Password",
                        driver.findElement(By.xpath("//div[contains(@class,'alert')]/following::label")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Update Password", driver.getTitle());
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
    public static String loginBluegroove(String needToExecute, String[] inputData, String url, WebDriver driver,
                                         String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals("Change Your Password",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals("Please replace the temporary password with a new one for your account.",
                        driver.findElement(By.xpath("//div[@class='alert-copy']/p")).getText());
                assertEquals("Update Your Password",
                        driver.findElement(By.xpath("//div[contains(@class,'alert')]/following::label")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Update Password", driver.getTitle());
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
    public static String loginFEPPPOMember(String needToExecute, String[] inputData, String url, WebDriver driver,
                                           String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals("Login or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "Your group plan does not allow you to register or log in to blueshieldca.com. For more information about your plan's services and benefits, please visit FEPBlue.org",
                        driver.findElement(By.xpath("//div[@class='text-center']/p[2]")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String loginMapletonMember(String needToExecute, String[] inputData, String url, WebDriver driver,
                                             String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals("Login or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals("A technical error has occurred. We are currently working to resolve the issue.",
                        driver.findElement(By.xpath("//p[@class='copy-success']/following::p")).getText());
                assertEquals(
                        "To access your account, please call the customer service phone number on your Blue Shield ID card.",
                        driver.findElement(By.xpath("//p[@class='copy-success']/following::p[2]")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String loginBlockedPlans(String needToExecute, String[] inputData, String url, WebDriver driver,
                                           String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName, count, row);
                assertEquals("Login or Registration Error",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals(
                        "Your group plan does not allow you to register or log in to blueshieldca.com. For more information about your plan’s benefits and services for members, contact your employer.",
                        driver.findElement(By.xpath("//div[@class='text-center']/p[2]")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String forgotPasswordWithMemId(String needToExecute, String[] inputData, String url, WebDriver driver,
                                                 String itrResult, String subPath, String testcaseName, int count, String path, int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginStepsForgotUsernameAndPassword(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, "forgotPassword");
                assertEquals("Password Help:\nVerify Identity",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                count = enterMemberIDAndDOB(driver, url, inputData[4], inputData[5], subPath, testcaseName, count, row);
                assertEquals("Password Help:\nAnswer Security Question",
                        driver.findElement(By.xpath("//div[@class=' text-center']/h1")).getText());
                driver.findElement(By.id("securityAnswer")).clear();
                driver.findElement(By.id("securityAnswer")).sendKeys(inputData[6]);
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.id("continueVerify")).click();
                Thread.sleep(8000);
                count = enterNewPassword(driver, inputData[7], inputData[8], subPath, testcaseName, count, row);
                assertEquals("Password Help:\nConfirmation",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals("Your new password has been saved.",
                        driver.findElement(By.xpath("//form[@id='forgotPasswordForm']/div/div")).getText());
                count = RegistrationFunctions.clickContinue(driver, subPath, testcaseName, count);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String forgotPasswordWithUsername(String needToExecute, String[] inputData, String url,
                                                    WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginStepsForgotUsernameAndPassword(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, "forgotPassword");
                assertEquals("Password Help:\nVerify Identity",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                driver.findElement(By.linkText("I don't have my member ID")).click();
                Thread.sleep(6000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.id("username")).clear();
                driver.findElement(By.id("username")).sendKeys(inputData[2]);
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.id("continueVerifyUsername")).click();
                Thread.sleep(20000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("Password Help:\nAnswer Security Question",
                        driver.findElement(By.xpath("//div[@class=' text-center']/h1")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.id("securityAnswer")).clear();
                driver.findElement(By.id("securityAnswer")).sendKeys(inputData[6]);
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.id("continueVerify")).click();
                Thread.sleep(10000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                count = enterNewPassword(driver, inputData[7], inputData[8], subPath, testcaseName, count, row);
                assertEquals("Password Help:\nConfirmation",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals("Your new password has been saved.",
                        driver.findElement(By.xpath("//form[@id='forgotPasswordForm']/div/div")).getText());
                count = RegistrationFunctions.clickContinue(driver, subPath, testcaseName, count);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String forgotUsernameWithMemIdAndDob(String needToExecute, String[] inputData, String url,
                                                       WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginStepsForgotUsernameAndPassword(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, "forgotUsername");
                assertEquals("Username Help:\nVerify Identity",
                        driver.findElement(By.xpath("//div[@class=' text-center']/h1")).getText());
                count = enterMemberIDAndDOB(driver, url, inputData[4], inputData[5], subPath, testcaseName, count, row);
                driver.findElement(By.id("continueVerify")).click();
                Thread.sleep(10000);
                assertEquals("Username Help:\nAnswer Security Question",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                driver.findElement(By.id("regSecurityAnswer")).clear();
                driver.findElement(By.id("regSecurityAnswer")).sendKeys(inputData[6]);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                count = RegistrationFunctions.clickContinue(driver, subPath, testcaseName, count);
                assertEquals("Username Help:\nYour Username",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
                assertEquals("USERNAME ON FILE:", driver.findElement(By.xpath("//h4")).getText());
                count = RegistrationFunctions.clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static String forgotUsernameWithNameAndEmail(String needToExecute, String[] inputData, String url,
                                                        WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath=CommonFunctions.createFolder(path, testcaseName);
                count = loginStepsForgotUsernameAndPassword(driver, url, inputData[2], inputData[3], subPath,
                        testcaseName, count, row, "forgotUsername");
                driver.findElement(By.linkText("I don't have my member ID")).click();
                Thread.sleep(2000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("Username Help:\nVerify Identity",
                        driver.findElement(By.xpath("//div[@class=' text-center']/h1")).getText());

                driver.findElement(By.id("firstName")).clear();
                driver.findElement(By.id("firstName")).sendKeys(inputData[9]);
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                driver.findElement(By.id("lastName")).clear();
                driver.findElement(By.id("lastName")).sendKeys(inputData[10]);
                Thread.sleep(3000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                driver.findElement(By.id("emailAddress")).clear();
                driver.findElement(By.id("emailAddress")).sendKeys(inputData[11]);
                Thread.sleep(4000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                count = RegistrationFunctions.clickContinue(driver, subPath, testcaseName, count);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("Username Help:\nRequest Received",
                        driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());

                driver.findElement(By.xpath("//button[contains(@class,'primary')]")).click();
                Thread.sleep(15000);
                assertEquals("BSCA Member Portal | Login", driver.getTitle());
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
    public static int enterMemberIDAndDOB(WebDriver driver, String url, String MemberID, String DOB, String subPath,
                                          String testcaseName, int count, int row) throws Exception {
        driver.findElement(By.id("memberid")).clear();
        driver.findElement(By.id("memberid")).sendKeys(MemberID);
        Thread.sleep(1000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        System.out.println(DOB);
        String Date[] = DOB.split("-");
        driver.findElement(By.id("dbMonth_title")).click();
        Thread.sleep(1000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        CommonFunctions.clickOn(driver, "Month");
        Thread.sleep(1000);
        driver.findElement(By.id("dbMonth_title")).click();
        Thread.sleep(1000);
        CommonFunctions.clickOn(driver, "" + Date[1]);
        Thread.sleep(1000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

        driver.findElement(By.id("dbDay_title")).click();
        Thread.sleep(1000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        CommonFunctions.clickOn(driver, "Day");
        Thread.sleep(1000);
        driver.findElement(By.id("dbDay_title")).click();
        Thread.sleep(1000);
        CommonFunctions.clickOnDay(driver, "" + Date[0]);
        Thread.sleep(1000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

        driver.findElement(By.id("dbYear_title")).click();
        Thread.sleep(1000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        CommonFunctions.clickOn(driver, "Year");
        Thread.sleep(1000);
        driver.findElement(By.id("dbYear_title")).click();
        Thread.sleep(1000);
        CommonFunctions.clickOn(driver, "" + Integer.parseInt(Date[2]));
        Thread.sleep(1000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        driver.findElement(By.id("continueVerify")).click();
        Thread.sleep(4000);
        return count;
    }

    /********************************************************************************************************************/
    public static int enterNewPassword(WebDriver driver, String newPassword, String confirmPassword, String subPath,
                                       String testcaseName, int count, int row) throws Exception {
        assertEquals("Password Help:\nChange Password",
                driver.findElement(By.xpath("//div[@class='text-center']/h1")).getText());
        driver.findElement(By.id("newPassword")).clear();
        driver.findElement(By.id("newPassword")).sendKeys(newPassword);
        Thread.sleep(3000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys(confirmPassword);
        Thread.sleep(3000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        driver.findElement(By.id("continueVerifyChangePassword")).click();
        Thread.sleep(8000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        return count;
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
            Thread.sleep(2000);
        }
        // assertEquals("BSCA Member Portal | Login", driver.getTitle());

        // driver.findElement(By.id("login-register-button")).click();
        // Thread.sleep(4000);

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
        Thread.sleep(4000);
        if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver")
                || driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.chrome.ChromeDriver")) {
            Thread.sleep(20000);
        }
        return count;
    }

    /********************************************************************************************************************/
    public static int loginStepsForgotUsernameAndPassword(WebDriver driver, String url, String username,
                                                          String password, String subPath, String testcaseName, int count, int row, String toClick) throws Exception {
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
        driver.findElement(By.id(toClick)).click();
        Thread.sleep(18000);
        CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
        return count;
    }

}
