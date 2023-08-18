package testCases;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;

    @BeforeClass
    @Parameters("browser")
    public void setup(String br) //USE STRING BR
    {
        logger=LogManager.getLogger(this.getClass());
        if(br.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(br.equals("edge")) {
            driver = new EdgeDriver();
        }
       // driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }

    public String randomAlphabets()
    {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public String randomNumbers()
    {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric()
    {
        return RandomStringUtils.randomAlphanumeric(8);
    }


    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;
    }

    }
