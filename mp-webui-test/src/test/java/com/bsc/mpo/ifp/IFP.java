package com.bsc.mpo.ifp;
import com.bsc.mpo.common.CommonFunctions;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by npolca01 on 11/30/2015.
 */


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class IFP {
    public static String[][] noOfIterations;
    public static String fileLocations[];
    public static WebDriver driver;
    static int row = 1;
    public String[] inputData;
    public String itrResult = "Passed";
    static File file = new File("LoginTest.java");
    static String path = "";
    static String subPath = "";
    static int i = 1;
    static String[][] browName;
    static Date date = new Date();
    public static String moduleName;

    @BeforeClass
    public static void initialSetup() throws Exception {
        moduleName = "IFP";
        //fileLocations = CommonFunctions.findFileLocation(file, row, noOfIterations, fileLocations);
        fileLocations = new String[6];
        fileLocations[1] = ".//src//main//resources//input";
        fileLocations[2] = ".//src//main//resources//output";
        fileLocations[3] = "https://www.webn121.blueshieldcloud.net/bsca/bsc/public/member/mp/login";
        fileLocations[4] = ".//src//main//resources//output//screenshots";
        fileLocations[5] = ".//src//main//resources//drivers";
        String outputSrc = ".//src//main//resources";
        //CommonFunctions.copyFile(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\")),
        //   fileLocations[1], fileLocations[2], fileLocations[5]);
        CommonFunctions.copyFile(outputSrc,fileLocations[1], fileLocations[2], fileLocations[5]);
        noOfIterations = CommonFunctions.readFromInputSheet(fileLocations[1], "IFP_Scenarios");
       // path = CommonFunctions.createFolder(fileLocations[4], Thread.currentThread().getStackTrace()[1].getClassName().substring(0, 3));
        path = CommonFunctions.createFolder(fileLocations[4], moduleName);
        browName = CommonFunctions.readFromInputSheet(fileLocations[1], "Browser_Selection");
        String browDesc[] = CommonFunctions.findInputDataForCurrentIteration(browName, 1, browName[1].length);
        driver = CommonFunctions.getBrowser(driver, browDesc, fileLocations[5]);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Before
    public void setUp() throws Exception {
        inputData = CommonFunctions.findInputDataForCurrentIteration(noOfIterations, row, noOfIterations[row].length);
    }

    @Test
    /**** On Exchange Keep Plan action ******/
    public void testIFP_001_ONExchange_KeepPlan() throws Exception {
        itrResult = IFPFunctions.ifpKeepYourPlan(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /**** On Exchange Change plan action ******/
    public void testIFP_002_ONExchange_ChangePlan() throws Exception {
        itrResult = IFPFunctions.ifpOnExchangeChangePlan(inputData[4].toString(), inputData,
                fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /**** OFF Exchange New/Renew status ******/
    public void testIFP_003_OFFExchange_RenewStatus() throws Exception {
        itrResult = IFPFunctions.ifpApplicationStatus(inputData[4].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row,
                "off", "renew");
    }

    @Test
    /**** OFF Exchange One application is in progress status ******/
    public void testIFP_004_OFFExchange_OneInProgress() throws Exception {
        itrResult = IFPFunctions.ifpApplicationStatus(inputData[4].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row,
                "off", "oneprogress");
    }

    @Test
    /**** OFF Exchange Multiple applications in progress ******/
    public void testIFP_005_OFFExchange_MultipleInProgress() throws Exception {
        itrResult = IFPFunctions.ifpApplicationStatus(inputData[4].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row,
                "off", "multiprogress");
    }

    @Test
    /**** Off Exchange - Keep status *************************/
    public void testIFP_006_OFFExchange_Submitted() throws Exception {
        itrResult = IFPFunctions.ifpApplicationStatus(inputData[4].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row,
                "off", "keep");
    }

    @Test
    /**** Off Exchange expired status ******/
    public void testIFP_007_OFFExchange_Expired() throws Exception {
        itrResult = IFPFunctions.ifpApplicationStatus(inputData[4].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row,
                "off", "expired");
    }

    @Test
    /**** OFF Exchange Keep status ******/
    public void testIFP_008_OFFExchange_RecentActionIsKeep() throws Exception {
        itrResult = IFPFunctions.ifpApplicationStatus(inputData[4].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row,
                "off", "keep");
    }

    @Test
    /**** On Exchange new/renew status ******/
    public void testIFP_009_ONExchange_RenewStatus() throws Exception {
        itrResult = IFPFunctions.ifpApplicationStatus(inputData[4].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row,
                "on", "renew");
    }

    @Test
    /**** On Exchange Change status ******/
    public void testIFP_010_ONExchange_RecentActionIsChange() throws Exception {
        itrResult = IFPFunctions.ifpApplicationStatus(inputData[4].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row,
                "on", "change");
    }

    @Test
    /**** On Exchange Keep status ******/
    public void testIFP_011_ONExchange_RecentActionIsKeep() throws Exception {
        itrResult = IFPFunctions.ifpApplicationStatus(inputData[4].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row,
                "on", "keep");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_012_LegacyGF_KeepPlan() throws Exception {
        itrResult = IFPFunctions.ifpKeepYourPlan(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_013_LegacyGF_ChangePlan() throws Exception {
        itrResult = IFPFunctions.BSCIFP_LegacyGFChangeYourPlan(inputData[4].toString(), inputData,
                fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_014_OFFExchange_KeepPlan() throws Exception {
        itrResult = IFPFunctions.ifpKeepYourPlan(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_015_OFFExchange_ChangePlan() throws Exception {
        itrResult = IFPFunctions.BSCIFP_OFFExchangeChangeYourPlan(inputData[4].toString(), inputData,
                fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_016_FacetsGF_KeepPlan() throws Exception {
        itrResult = IFPFunctions.ifpKeepYourPlan(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_017_FacetsGF_ChangePlan() throws Exception {
        itrResult = IFPFunctions.BSCIFP_OFFExchangeChangeYourPlan(inputData[4].toString(), inputData,
                fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_018_OFFExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 2, 2, 4,
                4, "Silver Seven 3750 PPO", "Silver 70 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_019_OFFExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 2, 2, 4,
                2, "Bronze 5550 PPO", "Bronze 60 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_020_OFFExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 2, 2, 4,
                3, "Silver Seven 3750 PPO", "Silver 1850 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_021_OFFExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 2, 2, 3,
                4, "Silver 70 PPO", "Gold 80 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_022_OFFExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 2, 2, 2,
                3, "Bronze 60 PPO", "Silver Seven 3750 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_023_OFFExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 2, 4, 4,
                3, "Silver Seven 3750 PPO", "Silver 70 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_024_ONExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 1, 1, 2,
                1, "Silver 70 PPO", "Gold 80 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_025_ONExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 1, 1, 3,
                2, "Silver Seven 3750 PPO", "Silver 1850 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_026_ONExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 1, 1, 3,
                3, "Silver Seven 3750 PPO", "Silver 70 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_027_ONExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 3, 2, 1,
                3, "Silver Seven 3750 PPO", "Gold 80 PPO");
    }

    @Test
    /*******************************************************************************************************************************/
    public void testIFP_028_ONExchange_HelpMeChoose() throws Exception {
        itrResult = IFPFunctions.BSCIFP_HelpMeChoose(inputData[4].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row, 2, 3, 3,
                2, "Silver Seven 3750 PPO", "Silver 70 PPO");
    }

    @After
    public void writeResults() throws Exception {
        CommonFunctions.writeToOutputSheet(fileLocations[2], noOfIterations, row, noOfIterations[row].length,
                itrResult, "IFP_ExecutionResult");
        itrResult = CommonFunctions.logout(moduleName, fileLocations[4], date, fileLocations[2], driver, fileLocations[2],
                row++, itrResult);
    }

    @AfterClass
    public static void closeSuite() throws Exception {
        CommonFunctions.closeSuite(moduleName, fileLocations[4], date, fileLocations[2], driver, fileLocations[2]);
    }

}
