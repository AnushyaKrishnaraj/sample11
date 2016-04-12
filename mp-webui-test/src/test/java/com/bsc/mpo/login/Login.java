package com.bsc.mpo.login;

/**
 * Created by npolca01 on 11/30/2015.
 */


import com.bsc.mpo.common.CommonFunctions;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Login {
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
        moduleName = "Login";
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
        noOfIterations = CommonFunctions.readFromInputSheet(fileLocations[1], "Login_Scenarios");
        path = CommonFunctions.createFolder(fileLocations[4], moduleName);
        browName = CommonFunctions.readFromInputSheet(fileLocations[1], "Browser_Selection");
        String browDesc[] = CommonFunctions.findInputDataForCurrentIteration(browName, 1, browName[1].length);
        driver = CommonFunctions.getBrowser(driver, browDesc, fileLocations[5]);
    }

    @Before
    public void setUp() throws Exception {
        inputData = CommonFunctions.findInputDataForCurrentIteration(noOfIterations, row, noOfIterations[row].length);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testLogin001FacetMember() throws Exception {
        itrResult = LoginFunctions.loginSuccess(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /***********************************************************************************************************************************/
    public void testLogin002LegacyMember() throws Exception {
        itrResult = LoginFunctions.loginSuccess(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin003InvalidUser() throws Exception {
        itrResult = LoginFunctions.loginInvalidUser(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin004PrivacySettings() throws Exception {
        itrResult = LoginFunctions.loginAccountNotAvailable(inputData[12].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin005IMAPDMember() throws Exception {
        itrResult = LoginFunctions.loginLegacyMember(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin006GMAPDHICNDelay() throws Exception {
        itrResult = LoginFunctions.loginTechnicalError(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin007NascoPar() throws Exception {
        itrResult = LoginFunctions.loginNotAllowedGroup(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin008BlankEmail() throws Exception {
        itrResult = LoginFunctions.loginEmailIsBlank(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin009ResetPassword() throws Exception {
        itrResult = LoginFunctions.resetTempPassword(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin010Bluegroove() throws Exception {
        // ItrResult=
        // Login_Functions.BSCLogin_OldLegacy(FindInputDataStream[12].toString(),FindInputDataStream,FindFileLocations[3],driver,ItrResult,Path_Sub,Thread.currentThread().getStackTrace()[1].getMethodName(),i,Path,row);
        itrResult = LoginFunctions.loginSuccess(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin011CvgExpiredMoreThan2Yrs() throws Exception {
        itrResult = LoginFunctions.loginAccountNotAvailable(inputData[12].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin012CvgExpiredLessThan2Yrs() throws Exception {
        itrResult = LoginFunctions.loginAccountNotAvailable(inputData[12].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin013CvgExpiredLessThan30Days() throws Exception {
        itrResult = LoginFunctions.loginAccountNotAvailable(inputData[12].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin014GMAPDHICNMismatch() throws Exception {
        itrResult = LoginFunctions.loginTechnicalError(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin015IneligibleSharedAdvGrpMember() throws Exception {
        itrResult = LoginFunctions.loginNotAllowedGroup(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testlogin016FEPPPOMember() throws Exception {
        itrResult = LoginFunctions.loginFEPPPOMember(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin017MapletonMember() throws Exception {
        itrResult = LoginFunctions.loginMapletonMember(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin018BlockedPlans() throws Exception {
        itrResult = LoginFunctions.loginBlockedPlans(inputData[12].toString(), inputData, fileLocations[3], driver,
                itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin019ForgotPasswordWithMemIDandDOB() throws Exception {
        itrResult = LoginFunctions.forgotPasswordWithMemId(inputData[12].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin020ForgotPasswordWithUsername() throws Exception {
        itrResult = LoginFunctions.forgotPasswordWithUsername(inputData[12].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin021ForgotUsernameWithMemIDandDOB() throws Exception {
        itrResult = LoginFunctions.forgotUsernameWithMemIdAndDob(inputData[12].toString(), inputData, fileLocations[3],
                driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /********************************************************************************************************************************/
    public void testLogin022ForgotUsernameWithNameandEmail() throws Exception {
        itrResult = LoginFunctions.forgotUsernameWithNameAndEmail(inputData[12].toString(), inputData,
                fileLocations[3], driver, itrResult, subPath, Thread.currentThread().getStackTrace()[1].getMethodName(),
                i, path, row);
    }

    @After
    public void writeResults() throws Exception {
        CommonFunctions.writeToOutputSheet(fileLocations[2], noOfIterations, row, noOfIterations[row].length,
                itrResult, "Login_ExecutionResult");
        itrResult = CommonFunctions.logout(moduleName, fileLocations[4], date, fileLocations[2], driver, fileLocations[2],
                row++, itrResult);
    }

    @AfterClass
    public static void closeSuite() throws Exception {
        CommonFunctions.closeSuite(moduleName, fileLocations[4], date, fileLocations[2], driver, fileLocations[2]);
    }
}
