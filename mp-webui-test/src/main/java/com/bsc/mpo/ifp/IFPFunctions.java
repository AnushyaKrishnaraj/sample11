package com.bsc.mpo.ifp;

import com.bsc.mpo.common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import static com.bsc.mpo.login.LoginFunctions.loginSteps;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Created by npolca01 on 11/30/2015.
 */
public class IFPFunctions {

    String subPath = null;

    /********************************************************************************************************************
     * Keep Your plan for On exchange members
     */
    public static String ifpKeepYourPlan(String needToExecute, String[] inputData, String url,
                                         WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                //subPath = CommonFunctions.createScreenshotFolder(testcaseName, path);
                subPath = CommonFunctions.createFolder(path, testcaseName);
                // Call login method
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);

                // IFP code starts here
                // Check if IFP banner exists
                assertTrue("IFP Banner doesnt exist for this user",
                        driver.findElements(By.xpath("//*[@id='ifp-alert-open']")).size() > 0);

                // Click IFP link
                driver.findElement(By
                        .xpath("//button[@onclick=\"javascript:window.location.href='/bsca/bsc/mysite/member/mp/ifp'\"]"))
                        .click();
                Thread.sleep(2000);
                assertEquals("Subsidy", driver.findElement(By.xpath("//a[contains(text(),'Subsidy')]")).getText());
                assertEquals("Amount You Pay", driver.findElement(By.cssSelector("h5.sm.bold")).getText());
                CommonFunctions.scrollToView(driver, "//div[contains(text(),'Review and Compare')]");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.xpath("//td[@id='id_ac_c_1']/a/button")).click();
                Thread.sleep(2000);
                assertEquals("You Chose to Keep Your Plan",
                        driver.findElement(By.xpath("//h2[contains(text(),'You Chose to Keep Your Plan')]")).getText());
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();

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

    /**** Change your plan for on exchange members */
    public static String ifpOnExchangeChangePlan(String needToExecute, String[] inputData, String url,
                                                 WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath = CommonFunctions.createFolder(path, testcaseName);

                // Call login method
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);

                // IFP code starts here
                // Check if IFP banner exists
                assertTrue("IFP Banner doesnt exist for this user",
                        driver.findElements(By.xpath("//*[@id='ifp-alert-open']")).size() > 0);

                // Click IFP link
                driver.findElement(By
                        .xpath("//button[@onclick=\"javascript:window.location.href='/bsca/bsc/mysite/member/mp/ifp'\"]"))
                        .click();
                Thread.sleep(2000);
                CommonFunctions.scrollToView(driver, "//div[contains(text(),'Review and Compare')]");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("Subsidy", driver.findElement(By.xpath("//a[contains(text(),'Subsidy')]")).getText());
                assertEquals("Amount You Pay", driver.findElement(By.cssSelector("h5.sm.bold")).getText());
                CommonFunctions.scrollToView(driver, "//div[contains(text(),'Review and Compare')]");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.linkText("Add a plan to Compare")).click();
                Thread.sleep(2000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.xpath("//*[@id='choose_plan_table']/tr[3]/td/table/tbody/tr/td[2]/h5")).click();
                driver.findElement(By.xpath("//*[@id='choose_plan_table']/tr[5]/td/table/tbody/tr/td[2]/h5")).click();
                driver.findElement(By.id("compare-btn")).click();
                Thread.sleep(1000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.xpath("//td[@id='id_ac_o_0']/button")).click();
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                driver.findElement(By.xpath("//*[@id='modal-ifp-change-plan-covered-ca']/div/div/div[3]/div/button"))
                        .click();
                Thread.sleep(2000);

                Set<String> ids = driver.getWindowHandles();
                Iterator<String> i = ids.iterator();
                String parentId = i.next();
                String childId = i.next();
                driver.switchTo().window(childId);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("Covered California", driver.getTitle());
                if (i.hasNext()) {

                }

                driver.close();
                driver.switchTo().window(parentId);

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



    public static String ifpApplicationStatus(String needToExecute, String[] inputData, String url,
                                              WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row,
                                              String exchangeInd, String appStatus) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath = CommonFunctions.createFolder(path, testcaseName);
                WebElement ifpPlanCompLink;
                WebElement ifpPhxLink;
                String ifpPhxLinkText = "";
                // Call login method
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);

                // IFP code starts here
                // Check if IFP banner exists
                assertTrue("IFP Banner doesnt exist for this user",
                        driver.findElements(By.xpath("//*[@id='ifp-alert-open']")).size() > 0);
                // Check the content for Renew status

                if (driver.findElements(By.xpath("//*[@id='ifp-alert-open']/div[2]/div[2]/button[2]")).size() > 0) {
                    ifpPlanCompLink = driver.findElement(By.xpath("//*[@id='ifp-alert-open']/div[2]/div[2]/button[2]"));
                    ifpPhxLink = driver.findElement(By.xpath("//*[@id='ifp-alert-open']/div[2]/div[2]/button[1]"));
                    ifpPhxLinkText = ifpPhxLink.getText();
                } else {
                    ifpPlanCompLink = driver.findElement(By.xpath("//*[@id='ifp-alert-open']/div[2]/div[2]/button"));
                    ifpPhxLink = null;
                }

                String ifpHeaderText = driver.findElement(By.xpath("//*[@id='ifp-alert-open']/div[1]/div[1]/h4"))
                        .getText();
                String ifpBodyText = driver.findElement(By.xpath("//*[@id='ifp-alert-open']/div[2]/div[1]/h5 "))
                        .getText();
                String ifpPlanCompLinkText = ifpPlanCompLink.getText();

                if ((exchangeInd.equalsIgnoreCase("on") && appStatus.equalsIgnoreCase("renew"))
                        || ((exchangeInd.equalsIgnoreCase("off") && appStatus.equalsIgnoreCase("renew")))) {
                    assertEquals("Renew your plan", ifpHeaderText);
                    assertEquals(
                            "Review your 2016 plan options. You have until January 31, 2016 to choose a new plan or to tell us you'd like to keep your existing plan.",
                            ifpBodyText);
                    assertEquals("Choose a 2016 Healthplan", ifpPlanCompLinkText);
                    ifpPlanCompLink.click();
                    Thread.sleep(2000);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                    assertTrue("IFP Plan comparison is not displayed", driver
                            .findElements(By.xpath("//h2[contains(text(),'Keep or Compare Your Plan')]")).size() > 0);

                } else if ((exchangeInd.equalsIgnoreCase("on") && appStatus.equalsIgnoreCase("keep"))
                        || ((exchangeInd.equalsIgnoreCase("off") && appStatus.equalsIgnoreCase("keep")))
                        || ((exchangeInd.equalsIgnoreCase("off") && appStatus.equalsIgnoreCase("submitted")))) {

                    assertEquals("Your 2016 plan options", ifpHeaderText);
                    assertEquals(
                            "Thank you for choosing to renew with Blue Shield. Your coverage will begin in 2016. You can make changes until January 31, 2016.",
                            ifpBodyText);
                    assertEquals("See 2016 plan options", ifpPlanCompLinkText);

                    // assertFalse("Check Application Status button exists",
                    // driver.findElements(By.xpath("//Button[contains(text(),'Check
                    // Application Status')]")).size() > 0);
                    ifpPlanCompLink.click();
                    Thread.sleep(2000);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                    assertTrue("IFP Plan comparison is not displayed", driver
                            .findElements(By.xpath("//h2[contains(text(),'Keep or Compare Your Plan')]")).size() > 0);

                } else if (((exchangeInd.equalsIgnoreCase("on") && appStatus.equalsIgnoreCase("change")))) {
                    assertEquals("Your 2016 plan options", ifpHeaderText);
                    assertEquals(
                            "Thank you for choosing to renew with Blue Shield. Your coverage will begin in 2016. You can make changes until January 31, 2016.",
                            ifpBodyText);
                    assertEquals("See 2016 plan options", ifpPlanCompLinkText);
                    assertEquals("Check Application Status", ifpPhxLinkText);

                    // verify plan comparison link
                    ifpPlanCompLink.click();
                    Thread.sleep(2000);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                    assertTrue("IFP Plan comparison is not displayed", driver
                            .findElements(By.xpath("//h2[contains(text(),'Keep or Compare Your Plan')]")).size() > 0);

                    // verify application status link
                    driver.navigate().back();
                    Thread.sleep(2000);
                    // driver.findElement(By.xpath("//Button[contains(text(),'Check
                    // Application Status')]")).click();
                    // ifpPhxLink.click();
                    driver.findElement(By.xpath("//*[@id='ifp-alert-open']/div[2]/div[2]/button[1]")).click();
                    Thread.sleep(5000);
                    Set<String> ids = driver.getWindowHandles();
                    Iterator<String> i = ids.iterator();
                    String parentId = i.next();
                    String childId = i.next();
                    driver.switchTo().window(childId);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                    assertEquals("On Exchange Application Status - Blue Shield of California", driver.getTitle());
                    driver.close();
                    Thread.sleep(1000);
                    driver.switchTo().window(parentId);
                } else if (((exchangeInd.equalsIgnoreCase("off") && appStatus.equalsIgnoreCase("oneprogress")))) {

                    assertEquals("You have an application in progress", ifpHeaderText);
                    assertEquals(
                            "You can continue with and submit an application up to 30 days after you started it. After 30 days we will ask you to start a new application.",
                            ifpBodyText);
                    assertEquals("See 2016 plan options", ifpPlanCompLinkText);
                    assertEquals("Go to my application", ifpPhxLinkText);

                    // navigate to plan comparison
                    ifpPlanCompLink.click();
                    Thread.sleep(2000);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                    assertTrue("IFP Plan comparison is not displayed", driver
                            .findElements(By.xpath("//h2[contains(text(),'Keep or Compare Your Plan')]")).size() > 0);

                    driver.navigate().back();
                    Thread.sleep(2000);
                    // navigate to phoenix
                    // driver.findElement(By.xpath("//Button[contains(text(),'Go
                    // to my application')]")).click();
                    // ifpPhxLink.click();
                    driver.findElement(By.xpath("//*[@id='ifp-alert-open']/div[2]/div[2]/button[1]")).click();
                    Thread.sleep(5000);
                    Set<String> ids = driver.getWindowHandles();
                    Iterator<String> i = ids.iterator();
                    String parentId = i.next();
                    String childId = i.next();
                    driver.switchTo().window(childId);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                    driver.findElement(By.xpath("//*[@id='open-id-Dev 8']/img")).click();

                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                    assertEquals("Applicant information - Blue Shield of California", driver.getTitle());
                    driver.close();
                    Thread.sleep(1000);
                    driver.switchTo().window(parentId);

                } else if (((exchangeInd.equalsIgnoreCase("off") && appStatus.equalsIgnoreCase("multiprogress")))) {
                    assertEquals("You have applications in progress", ifpHeaderText);
                    assertEquals(
                            "You can continue with and submit an application up to 30 days after you started it. After 30 days we will ask you to start a new application.",
                            ifpBodyText);
                    assertEquals("See 2016 plan options", ifpPlanCompLinkText);
                    assertEquals("Go to my applications", ifpPhxLinkText);

                    ifpPlanCompLink.click();
                    Thread.sleep(2000);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                    assertTrue("IFP Plan comparison is not displayed", driver
                            .findElements(By.xpath("//h2[contains(text(),'Keep or Compare Your Plan')]")).size() > 0);
                    driver.navigate().back();
                    Thread.sleep(2000);
                    // navigate to phoenix
                    // driver.findElement(By.xpath("//Button[contains(text(),'Go
                    // to my applications')]")).click();
                    // ifpPhxLink.click();
                    driver.findElement(By.xpath("//*[@id='ifp-alert-open']/div[2]/div[2]/button[1]")).click();
                    Thread.sleep(5000);
                    Set<String> ids = driver.getWindowHandles();
                    Iterator<String> i = ids.iterator();
                    String parentId = i.next();
                    String childId = i.next();
                    driver.switchTo().window(childId);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                    driver.findElement(By.xpath("//*[@id='open-id-Dev 8']/img")).click();

                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                    assertEquals("My account - Blue Shield of California", driver.getTitle());
                    driver.close();
                    Thread.sleep(1000);
                    driver.switchTo().window(parentId);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

                } else if (((exchangeInd.equalsIgnoreCase("off") && appStatus.equalsIgnoreCase("expired")))) {

                    assertEquals("Your application has expired", ifpHeaderText);
                    assertEquals(
                            "You can start a new application now. You can continue with and submit an application up to 30 days after you start it. After 30 days we will ask you to start a new application.",
                            ifpBodyText);
                    assertEquals("See 2016 plan options", ifpPlanCompLinkText);

                    ifpPlanCompLink.click();
                    Thread.sleep(2000);
                    CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                    assertTrue("IFP Plan comparison is not displayed", driver
                            .findElements(By.xpath("//h2[contains(text(),'Keep or Compare Your Plan')]")).size() > 0);

                }

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

    /************* DEVELOPED BY OFFSHORE TEAM ******************/

    /**** Change Your Plan for Legacy GF Members */

    public static String BSCIFP_LegacyGFChangeYourPlan(String needToExecute, String[] inputData, String url,
                                                       WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row)
            throws Exception {
        String verificationErrorString = "";
        String ChangeYourPlan = "If you change your plan, the provider network can change in addition to benefits. Before switching plans, make sure your providers are in the network associated with the plan you are considering. Please contact our knowledgeable plan advisers at (877) 657-2526 to help you navigate this process.";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath = CommonFunctions.createFolder(path, testcaseName);

                // Call login method
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);
                // IFP code starts here
                // Check if IFP banner exists
                assertTrue("IFP Banner doesnt exist for this user",
                        driver.findElements(By.xpath("//*[@id='ifp-alert-open']")).size() > 0);
                // Click IFP link
                driver.findElement(By
                        .xpath("//button[@onclick=\"javascript:window.location.href='/bsca/bsc/mysite/member/mp/ifp'\"]"))
                        .click();
                Thread.sleep(1000);
                CommonFunctions.scrollToView(driver, "//div[contains(text(),'Review and Compare')]");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                CommonFunctions.scrollToView(driver, "//div[contains(text(),'Review and Compare')]");
                assertEquals("Your plan benefits are not available to view.",
                        driver.findElement(By.id("id_3_c_0")).getText());
                assertEquals("Your plan benefits are not available to view.",
                        driver.findElement(By.id("id_3_c_1")).getText());
                ;
                Thread.sleep(2000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.linkText("Add a plan to Compare")).click();
                Thread.sleep(2000);
                assertTrue(driver.getPageSource().contains("Contact Us to Change Your Plan"));
                assertEquals(driver.findElement(By.xpath("//div/p")).getText(), ChangeYourPlan);
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

    /**** Change your plan for OFF Exchange members */

    public static String BSCIFP_OFFExchangeChangeYourPlan(String needToExecute, String[] inputData,
                                                          String url, WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path,
                                                          int row) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath = CommonFunctions.createFolder(path, testcaseName);

                // Call login method
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);

                // IFP code starts here
                // Check if IFP banner exists
                assertTrue("IFP Banner doesnt exist for this user",
                        driver.findElements(By.xpath("//*[@id='ifp-alert-open']")).size() > 0);

                // Click IFP link
                driver.findElement(By
                        .xpath("//button[@onclick=\"javascript:window.location.href='/bsca/bsc/mysite/member/mp/ifp'\"]"))
                        .click();
                Thread.sleep(1000);
                CommonFunctions.scrollToView(driver, "//div[contains(text(),'Review and Compare')]");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals(driver.findElements(By.xpath("//a[contains(text(),'Subsidy')]")).size(), 0);
                assertEquals(driver.findElements(By.cssSelector("h5.sm.bold")).size(), 0);
                CommonFunctions.scrollToView(driver, "//div[contains(text(),'Review and Compare')]");
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.linkText("Add a plan to Compare")).click();
                Thread.sleep(1000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                driver.findElement(By.xpath("//*[@id='choose_plan_table']/tr[3]/td/table/tbody/tr/td[2]/h5")).click();
                driver.findElement(By.xpath("//*[@id='choose_plan_table']/tr[5]/td/table/tbody/tr/td[2]/h5")).click();
                driver.findElement(By.id("compare-btn")).click();
                driver.findElement(By.xpath("//td[@id='id_ac_o_0']/button")).click();
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);
                assertEquals("You've Decided to Change Your Plan",
                        driver.findElement(By.xpath("//div[6]/div/div/div/h2")).getText());
                assertEquals("Do you need to change your ZIP code or add/remove dependents on your policy?",
                        driver.findElement(By.xpath("//div[6]/div/div/div/div/h3")).getText());
                assertEquals("Yes", driver.findElement(By.xpath("//label")).getText());
                assertEquals("No", driver.findElement(By.xpath("//label[2]")).getText());
                driver.findElement(By.xpath("//label[2]")).click();
                driver.findElement(By.xpath("//div[2]/div/button")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//a[@id='open-id-Dev 8']/img")).click();
                Thread.sleep(1000);
                assertEquals("Apply for a plan",
                        driver.findElement(By.xpath("//div[@id='contentPanel']/div[2]/h1")).getText());
                assertEquals(
                        "https://urldefense.proofpoint.com/v2/url?u=https-3A__stage.bscapply.com_phx_action_phxEnrollment&d=AwIGAg&c=hNAZrKxPkhfPADjr9wUJ4AJ2gCqdYYgx1uIsXrLIsh-DuhNfnmQL7Uyhk3cxPIdo&r=cxlLr3XVHj3SSz2xsmWo6UP0q4QWe8HZjDXDsskJcBbIK-DYWgppWvAXdGnNzfOh&m=HZWRyTClmmtIs3ulanQV1JFpA_2lbpEf6xa8seiCpQs&s=Hs9y6lYWvbyi82Ia5Y0in95rxTayDpBgh9e1m58LtjE&e= ",
                        driver.getCurrentUrl());
                driver.findElement(By.xpath("//div[@id='topLogin']/a/b/span")).click();
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

    /********************************************************************************************************************
     * Help me choose
     */
    public static String BSCIFP_HelpMeChoose(String needToExecute, String[] inputData, String url,
                                             WebDriver driver, String itrResult, String subPath, String testcaseName, int count, String path, int row,
                                             int ans1, int ans2, int ans3, int ans4, String recPlan1, String recPlan2) throws Exception {
        String verificationErrorString = "";
        try {
            if (needToExecute.equalsIgnoreCase("Y")) {
                subPath = CommonFunctions.createFolder(path, testcaseName);

                // Call login method
                count = loginSteps(driver, url, inputData[2], inputData[3], subPath, testcaseName,
                        count, row);

                // IFP code starts here
                // Check if IFP banner exists
                assertTrue("IFP Banner doesnt exist for this user",
                        driver.findElements(By.xpath("//*[@id='ifp-alert-open']")).size() > 0);

                // Click IFP link
                driver.findElement(By
                        .xpath("//button[@onclick=\"javascript:window.location.href='/bsca/bsc/mysite/member/mp/ifp'\"]"))
                        .click();
                Thread.sleep(2000);
                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

				/* assert Help me choose link and info text */
                assertEquals("Help me choose >",
                        driver.findElement(By.cssSelector("div.bsc-h2-small-white")).getText());
                assertEquals(
                        "We're here to help. Answer a few questions and we'll show you a few health plan recommendations. Always remember, you can apply for any of our IFP plans.",
                        driver.findElement(By.cssSelector("div.bsc-text1.text-margin-top")).getText());

                driver.findElement(By.cssSelector("div.bsc-h2-small-white")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
                driver.findElement(By.xpath("//div[@id='Question-1']/div/div/div/ul/li[" + ans1 + "]/a")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
                driver.findElement(By.xpath("//div[@id='Question-2']/div/div/div/ul/li[" + ans2 + "]/a")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
                driver.findElement(By.xpath("//div[@id='Question-3']/div/div/div/ul/li[" + ans3 + "]/a")).click();
                driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
                driver.findElement(By.xpath("//div[@id='Question-4']/div/div/div/ul/li[" + ans4 + "]/a")).click();

                CommonFunctions.captureScreenshot(driver, subPath, testcaseName, count++);

				/* assert Help me choose header and info text */
                assertEquals("Help Me Choose", driver.findElement(By.xpath("//h2")).getText());
                assertEquals(
                        "Your plan recommendations are based on your responses to the questions below. Answer all questions to see your plan recommendations.",
                        driver.findElement(By.cssSelector("p.bsc-text4.hmctext4")).getText());

                driver.findElement(By.id("submit-message")).click();

				/* assert Recommended For You labels for 3rd and 4th columns */
                assertEquals("Recommended For You",
                        driver.findElement(By.xpath("//h6[@id='id_rp_o_0']/div")).getText());
                assertEquals("Recommended For You",
                        driver.findElement(By.xpath("//h6[@id='id_rp_o_1']/div")).getText());

				/* assert Recommended plans returned for 3rd and 4th columns */
                assertEquals(recPlan1, driver.findElement(By.xpath("//td[4]/h3")).getText());
                assertEquals(recPlan2, driver.findElement(By.xpath("//td[5]/h3")).getText());

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
}
