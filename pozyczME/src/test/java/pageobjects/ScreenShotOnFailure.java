package pageobjects;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static pageobjects.BaseAccess.getDriver;

public class ScreenShotOnFailure extends TestWatcher {

    @Override
    protected void failed(Throwable e, Description description) {
        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)getDriver());

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File("src/" + description.getMethodName() + LocalDateTime.now() + ".png");

        //Copy file at destination

        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        if(getDriver() != null)
            getDriver().close();
    }

    @Override
    protected void finished(Description description) {
        if(getDriver() != null)
            getDriver().close();
    }
}
