package ui.view;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageobjects.Index;


public class test {
	private WebDriver driver;
	private Index index;

	public test() {

	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/spooked/UCLL/Java/web/geckodriver");
		driver = new FirefoxDriver();
		index = new Index(driver);
	}

	@After
	public void breakDown() {
		driver.close();
	}

	@Test
	public void TCA2_userWithValidUsernameAndPasswordElste() {

		index.setUsername("ElSte");
		index.setPassword("qwerty123");
		index.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertTrue(index.loginSuccesful());
	}

	@Test
	public void TCA2_userWithValidUsernameAndPasswordMiekem() {
		index.setUsername("Miekem");
		index.setPassword("azerty999");
		index.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		assertTrue(index.loginSuccesful());
	}

	@Test
	public void TCB1_userWithInValidUsernameAndPasswordElSteGivesError() {
		index.setUsername("ElSte");
		index.setPassword("t");
		index.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		assertTrue(index.loginSuccesful());
	}

	@Test
	public void TCB2_userWithInValidUsernameAndPasswordMieKemGivesError() {
		index.setUsername("MieKem");
		index.setPassword("azerty000");
		index.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		assertTrue(index.loginSuccesful());
	}

	@Test
	public void TCC1_invalid_username_elke_with_password_qwerty123_gives_error_message() {
		index.setUsername("elke");
		index.setPassword("qwerty123");
		index.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		assertTrue(index.loginUnsuccesful());
	}

	@Test
	public void TCC2_invalid_username_mieke_with_password_azerty999_gives_error_message() {
		index.setUsername("mieke");
		index.setPassword("azerty999");
		index.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		assertTrue(index.loginUnsuccesful());
	}

	@Test
	public void TCD1_valid_username_ELSTE_with_password_qwerty123_login_successful() {
		index.setUsername("ELSTE");
		index.setPassword("qwerty123");
		index.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		assertTrue(index.loginSuccesful());
	}

	@Test
	public void TCD2_valid_username_MIEKEM_with_password_azerty999_login_successful() {
		index.setUsername("MIEKEM");
		index.setPassword("azerty999");
		index.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		assertTrue(index.loginSuccesful());
	}
}
