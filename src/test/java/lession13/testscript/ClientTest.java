package lession13.testscript;


import lession13.common.DriverManager;
import lession13.common.TestBase;
import lession13.pages.ClientPage;
import lession13.pages.HomePage;
import lession13.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClientTest extends TestBase {
    private WebDriver mWebDriver;
    private String baseURL = "https://rise.fairsketch.com";
    private LoginPage loginPage;
    private HomePage homePage;
    private ClientPage clientPage;

    @BeforeClass
    public void beforeClass() {
        mWebDriver = DriverManager.getWebDriver();
        loginPage = new LoginPage(mWebDriver);

    }

    @AfterClass
    public void afterClass() {
       DriverManager.quit();
    }

    @Test (description ="Verify the login function")
    public void RISE_Client_001_VerifyDashboard() {
        gotoWebsite();
        // Login website với tài khoản hợp lệ -> Thành công truy cập vào HomePage
        homePage = loginPage.login("admin@demo.com", "riseDemo");

        // Click Clients] -> Thành công truy cập vào ClientPage
        clientPage = homePage.gotoClientsPage();

        // Thực hiện các hành động trong Client Page
        clientPage.verifyClientDashboard();
    }

    private void gotoWebsite() {
        loginPage.gotoWebsite(baseURL);
    }
}
