package com.bsc.mpo.membercenter;
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
public class Membercenter {
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
        noOfIterations = CommonFunctions.readFromInputSheet(fileLocations[1], "MemberCenter_Scenarios");
        path = CommonFunctions.createFolder(fileLocations[4],moduleName);
        browName = CommonFunctions.readFromInputSheet(fileLocations[1], "Browser_Selection");
        String browDesc[] = CommonFunctions.findInputDataForCurrentIteration(browName, 1, browName[1].length);
        driver = CommonFunctions.getBrowser(driver, browDesc, fileLocations[5]);
    }

    @Before
    public void setUp() throws Exception {
        inputData = CommonFunctions.findInputDataForCurrentIteration(noOfIterations, row,
                noOfIterations[row].length);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter001ClaimsFacets() throws Exception {
        itrResult = MembercenterFunctions.membercenterClaims(inputData[4].toString(), inputData,
                fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter002ClaimsLegacy() throws Exception {
        itrResult = MembercenterFunctions.membercenterClaims(inputData[4].toString(), inputData,
                fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter003CommonCopays() throws Exception {
        itrResult = MembercenterFunctions.membercenterCommonCopays(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter004DeductiblesOOPFamilyPlanLegacy() throws Exception {
        itrResult = MembercenterFunctions.membercenterDeductiblesOOPFamilyPlan(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter005DeductiblesOOPIndividualPlan() throws Exception {
        itrResult = MembercenterFunctions.membercenterDeductiblesOOPIndividualPlan(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter006DeductiblesOOPFirstDollar() throws Exception {
        itrResult = MembercenterFunctions.membercenterDeductiblesOOPFirstDollar(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter007DeductiblesOOPFamilyPlanFacets() throws Exception {
        itrResult = MembercenterFunctions.membercenterDeductiblesOOPFamilyPlan(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter008PharmacyAccumulators() throws Exception {
        itrResult = MembercenterFunctions.membercenterPharmacyAccumulators(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter009CarouselHEQLegacy() throws Exception {
        itrResult = MembercenterFunctions.membercenterCarouselHEQ(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter010CarouselHEQFacets() throws Exception {
        itrResult = MembercenterFunctions.membercenterCarouselHEQ(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter011PaymentSection() throws Exception {
        itrResult = MembercenterFunctions.membercenterPaymentSectionCarousel(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter012DeductibleSection() throws Exception {
        itrResult = MembercenterFunctions.membercenterDeductibleSectionCarousel(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @Test
    /*******************************************************************************************************************************/
    public void testMemberCenter013CopaymentSection() throws Exception {
        itrResult = MembercenterFunctions.membercenterCopaymentSectionCarousel(inputData[4].toString(),
                inputData, fileLocations[3], driver, itrResult, subPath,
                Thread.currentThread().getStackTrace()[1].getMethodName(), i, path, row);
    }

    @After
    public void writeResults() throws Exception {
        CommonFunctions.writeToOutputSheet(fileLocations[2], noOfIterations, row, noOfIterations[row].length,
                itrResult, "MemberCenter_ExecutionResult");
        itrResult = CommonFunctions.logout(moduleName,
                fileLocations[4], date, fileLocations[2], driver, fileLocations[2], row++, itrResult);
    }

    @AfterClass
    public static void closeSuite() throws Exception {
        CommonFunctions.closeSuite(moduleName, fileLocations[4], date, fileLocations[2], driver, fileLocations[2]);
    }
}
