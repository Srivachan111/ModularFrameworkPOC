package ProjectSetup;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {
	
    private static ThreadLocal<Logger> threadLocalLogger = new ThreadLocal<>();
    private static String timestampDir;
    private static ThreadLocal<File> testCaseDir = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    BrowserSetup browser = new BrowserSetup();

    @BeforeSuite
    public void initializeTimestampDir() {
        // Create a top-level directory with a timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        timestampDir = "LOGS/" + timestamp;
        File dir = new File(timestampDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

   
    

    @BeforeTest
    public void setUp() {
        // Ensure the timestamp directory exists
        File logsDir = new File(timestampDir);
        if (!logsDir.exists()) {
            logsDir.mkdirs();
        }
    }

    @BeforeMethod
    public void initializeWebDriverAndSetLogFileName(Method method) {
        // Initialize WebDriver
    	WebDriver delegate = browser.initDriver("Chrome");
    	WebDriver driver = SelfHealingDriver.create(delegate);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
        threadLocalDriver.set(driver);

        // Set up logging
        Logger logger = Logger.getLogger(this.getClass().getName() + "." + method.getName());
        threadLocalLogger.set(logger);

        // Create a directory for the test class within the timestamp directory if it doesn't exist
        File classDir = new File(timestampDir + "/" + this.getClass().getSimpleName());
        if (!classDir.exists()) {
            classDir.mkdirs();
        }

        // Create a directory for the test case name within the class directory
        File testCaseDir = new File(classDir.getPath() + "/" + method.getName());
        if (!testCaseDir.exists()) {
            testCaseDir.mkdirs();
        }
        this.testCaseDir.set(testCaseDir);

        // Create a new file appender with the specified log file name
        String logFileName = testCaseDir.getPath() + "/" + method.getName() + ".log";
        System.out.println(logFileName);
        try {
            FileAppender fileAppender = new FileAppender(new PatternLayout("%d{ISO8601} [%t] %-5p %c{1} - %m%n"), logFileName, false);
            logger.removeAllAppenders(); 
            logger.addAppender(fileAppender);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            if (!result.isSuccess()) {
                WebDriver originalDriver = ((SelfHealingDriver) driver).getDelegate();
                File screenshotFile = ((TakesScreenshot) originalDriver).getScreenshotAs(OutputType.FILE);
                try {
                    File screenshotDest = new File(testCaseDir.get(), "screenshot.png");
                    ImageIO.write(ImageIO.read(screenshotFile), "png", screenshotDest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            driver.quit();
        } else {
            System.out.println("The driver is null");
        }
    }

    protected Logger getLogger() {
        return threadLocalLogger.get();
    }

    protected WebDriver getDriver() {
        return threadLocalDriver.get();
    }
    
}
