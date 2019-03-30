package cn.tjucic.selenium;

import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestStudents {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	

	@Before
	public void setUp() throws Exception {
		// System.out.println(System.getProperty("user.dir"));
		String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		baseUrl = "http://121.193.130.195:8800";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testStudent() throws Exception {
		
		driver.get(baseUrl + "/login");
		String id = "", password = "", gitAddress = "";
		File file = new File("软件测试名单.xlsx");
		InputStream is = new FileInputStream(file);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
		for (int rowNum = 2; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
			XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			if(xssfRow != null){
				XSSFCell one = xssfRow.getCell(1);
				XSSFCell three = xssfRow.getCell(3);
				
				//得到名单中的账号、密码、github地址
				id = new DecimalFormat("#.######").format(one.getNumericCellValue());
		        password = id.substring(4, 10);
				gitAddress = String.valueOf(three.getStringCellValue());
				
				System.out.println(id);
				System.out.println(password);
				System.out.println(gitAddress);
				
				// 输入账号
				driver.findElement(By.name("id")).click();
				driver.findElement(By.name("id")).clear();
				driver.findElement(By.name("id")).sendKeys(id);

				// 输入密码
				driver.findElement(By.name("password")).click();
				driver.findElement(By.name("password")).clear();
				driver.findElement(By.name("password")).sendKeys(password);

				// 登入
				WebElement btn_login = driver.findElement(By.id("btn_login"));
				btn_login.sendKeys(Keys.ENTER);

				// 检查github地址
				assertEquals(gitAddress, driver.findElement(By.id("student-git")).getText());

				// 登出
				WebElement btn_logout = driver.findElement(By.id("btn_logout"));
				btn_logout.sendKeys(Keys.ENTER);

				// 返回登入界面
				WebElement btn_return = driver.findElement(By.id("btn_return"));
				btn_return.sendKeys(Keys.ENTER);
			}
		}
		// 关闭浏览器窗口
		driver.close();
		

	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
		// String verificationErrorString = verificationErrors.toString();
		// if (!"".equals(verificationErrorString)) {
		// fail(verificationErrorString);
		// }
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
