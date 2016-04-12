package com.bsc.mpo.registration;
import com.bsc.mpo.common.CommonFunctions;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * Created by npolca01 on 11/30/2015.
 */
public class Registration {

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
        moduleName = "Registration";
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
        noOfIterations = CommonFunctions.readFromInputSheet(fileLocations[1], "Registration_Scenarios");
        path = CommonFunctions.createFolder(fileLocations[4], moduleName);
        browName = CommonFunctions.readFromInputSheet(fileLocations[1], "Browser_Selection");
        String browDesc[] = CommonFunctions.findInputDataForCurrentIteration(browName, 1, browName[1].length);
        driver = CommonFunctions.getBrowser(driver, browDesc, fileLocations[5]);
    }

    @Before
    public void setUp() throws Exception {
        inputData = CommonFunctions.findInputDataForCurrentIteration(noOfIterations, row,
                noOfIterations[row].length);
        // CommonFunctions.deleteRegistrationData(FindFileLocations[6],
        // FindInputDataStream[2]);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration001HappyPath() throws Exception {
        itrResult = RegistrationFunctions.registrationSuccess(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration002DifferentPasswords() throws Exception {
        itrResult = RegistrationFunctions.registrationDifferentPasswords(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration003SameEmailID() throws Exception {
        itrResult = RegistrationFunctions.registrationSameEmailId(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration004SameUsername() throws Exception {
        itrResult = RegistrationFunctions.registrationSameUsername(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration005IncorrectPassword() throws Exception {
        itrResult = RegistrationFunctions.registrationIncorrectPassword(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration006AlreadyRegistered() throws Exception {
        itrResult = RegistrationFunctions.registrationAlreadyRegistered(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration007TwinScenario() throws Exception {
        itrResult = RegistrationFunctions.registrationTwinScenario(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration008CvrgExpiredMoreThan2Yrs() throws Exception {
        itrResult = RegistrationFunctions.registrationCvrgExpiredMoreThan2Yrs(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration009CvrgExpiredLessThan2Yrs() throws Exception {
        itrResult = RegistrationFunctions.registrationCvrgExpiredLessThan2Yrs(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration010GMAPDHicnMismatch() throws Exception {
        itrResult = RegistrationFunctions.registrationGMAPDHicnMismatch(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration011GMAPDHicnDelay() throws Exception {
        itrResult = RegistrationFunctions.registrationGMAPDHicnDelay(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration012BlockedPlans() throws Exception {
        itrResult = RegistrationFunctions.registrationBlockedPlans(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration013IneligibleSharedAdvGrpMember() throws Exception {
        itrResult = RegistrationFunctions.registrationIneligibleSharedAdvGrpMember(
                inputData[14].toString(), inputData, fileLocations[3], driver, itrResult,
                subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration014FEPPPOMember() throws Exception {
        itrResult = RegistrationFunctions.registrationFEPPPOMember(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration015IneligibleASOGroupMember() throws Exception {
        itrResult = RegistrationFunctions.registrationIneligibleSharedAdvGrpMember(
                inputData[14].toString(), inputData, fileLocations[3], driver, itrResult,
                subPath, Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration016NascoParMember() throws Exception {
        itrResult = RegistrationFunctions.registrationNascoParMember(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration017PrivacyRestriction() throws Exception {
        itrResult = RegistrationFunctions.registrationPrivacyRestriction(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration018IMAPDMember() throws Exception {
        itrResult = RegistrationFunctions.registrationIMAPDMember(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration019GMAPDMember() throws Exception {
        // Pending and will be progressed once data is available
        itrResult = RegistrationFunctions.RegistrationGMAPDMember(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration020BluegrooveMember() throws Exception {
        itrResult = RegistrationFunctions.registrationSuccess(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testRegistration021EligibleSharedAdvMember() throws Exception {
        itrResult = RegistrationFunctions.registrationEligibleSharedAdvMember(inputData[14].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @After
    public void writeResults() throws Exception {
        CommonFunctions.writeToOutputSheet(fileLocations[2], noOfIterations, row, noOfIterations[row].length,
                itrResult, "Registration_ExecutionResult");
        itrResult = CommonFunctions.logout(moduleName,
                fileLocations[4], date, fileLocations[2], driver, fileLocations[2], row++, itrResult);
    }

    @AfterClass
    public static void closeSuite() throws Exception {
        CommonFunctions.closeSuite(moduleName, fileLocations[4], date, fileLocations[2], driver, fileLocations[2]);
    }
}
