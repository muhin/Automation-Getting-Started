package org.automation.UnitTests;

import org.automation.Calculator;
import org.automation.DataDrivenTest;
import org.easetech.easytest.annotation.*;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by shantonu on 7/15/16.
 */

@RunWith(DataDrivenTestRunner.class)
@Report(reportTypes = {Report.REPORT_TYPE.METHOD_DURATION, Report.REPORT_TYPE.DEFAULT}
,outputLocation ="classpath:Reports",
outputFormats = Report.EXPORT_FORMAT.HTML)
public class CalculatorTest extends DataDrivenTest {



    @Test
    @DataLoader(filePaths = "calculator.csv", loaderType = LoaderType.CSV)
    //@Duration(forClass = CalculatorTest.class, timeInMillis = 100)//duration condition does not work
    public void testAddFromCSV(@Param(name = "a") Double a,
                               @Param(name = "b") Double b,
                               @Param(name = "expected") Double expected) {

       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Assert.assertEquals(expected, calculator.add(a, b), 0.1);
    }
    @Test
    @DataLoader(filePaths = "calculator.csv", loaderType = LoaderType.CSV)
    public void testsubFromCSV(@Param(name = "a") Double a,
                               @Param(name = "b") Double b,
                               @Param(name = "expected") Double expected){
        Assert.assertEquals(expected, calculator.sub(a, b), 0.1);

    }
    @Test
    @DataLoader(filePaths = "calculator.xls", loaderType = LoaderType.EXCEL)
    @Repeat(times = 5)
    public void testAddFromExcel(@Param(name = "a") Double a, @Param(name = "b") Double b, @Param(name = "expected") Double expected) {
        Assert.assertEquals(expected, calculator.add(a, b), 0.1);

    }
    @Test
    @DataLoader(filePaths = "calculator.xml", loaderType = LoaderType.XML)
    public void testAddFromXML(@Param(name = "a") Double a, @Param(name = "b") Double b, @Param(name = "expected") Double expected) {
        Assert.assertEquals(expected, calculator.add(a, b), 0.1);

    }
    @Test
    @DataLoader(filePaths = "calculator2.xml", loaderType = LoaderType.XML)
    public String testAddXMLOutput(@Param(name = "a") Double a, @Param(name = "b") Double b, @Param(name = "expected") Double expected) {
        Assert.assertEquals(expected, calculator.add(a, b), 0.1);
        return "success";

    }

}
