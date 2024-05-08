package lession03;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;

/**
 * Hoc vien hoan thanh bai tap trong class nay
 */
public class BTVNForm {
    // The driver for interacting with the webpage
    private WebDriver webDriver;

    /**
     * Method thực thi trước mỗi class, tiến hành cấu hình Chrome Driver và khởi tạo
     */
    @BeforeClass
    public void beforeClass() {
//        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--max-window-size");
//        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver();
    }

    /**
     * Method thực thi cuối cùng mỗi class, sẽ tiến hành đóng toàn bộ các chrome session đang chạy - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(webDriver)) webDriver.quit();
    }


    /**
     * Description:
     */
    @Test(description = "Xác định phần tử với tìm kiếm nâng cao ")
    public void btvn_findLocator_Advance_02() {
        gotoDemoQAWebsite();

        // Full Name Component
        String fullNameLabelXPath = "//label[text()='Full Name']";
        WebElement fullNameEle = webDriver.findElement(By.xpath(fullNameLabelXPath));


        // TODO: 10/05/2023 : Tìm kiếm với nhiều kịch bản advance khác nhau cho cùng component


        // TODO: 10/05/2023 Làm tương tự với các đối tượng khác



        String containsAddress = "//label[contains(text(),'Permanent Address')]";
        WebElement containsAddressEle = webDriver.findElement(By.xpath(containsAddress));

        String startWFull = "//input[starts-with(@placeholder,'Full')]";
        WebElement wFullEle = webDriver.findElement(By.xpath(startWFull));

        String textEmail = "//label[text()='Email']";
        WebElement textEmailELe = webDriver.findElement(By.xpath(textEmail));

        String labelCurrent = "//label[normalize-space()='Current Address']";
        WebElement labelCurrentELe = webDriver.findElement(By.xpath(labelCurrent));

        String orEmail = "//*[@type='email' or @placeholder='name@example.com']";
        WebElement orEmailEle = webDriver.findElement(By.xpath(orEmail));

        String andFullName = "//*[@autocomplete='off' and @placeholder='Full Name']";
        WebElement andFullNameEle = webDriver.findElement(By.xpath(andFullName));

    }

    /**
     * Description:
     */
    @Test(description = "Xác định phần tử kết hợp vị trí để thực hiện tìm kiếm nâng cao")
    public void btvn_findLocator_Position_03() {
        gotoDemoQAWebsite();

        // Full Name Component
        /**
         * Xác định phần tử label (Full Name):
         * 1. Xác định phần tử input có placeholder='Full Name'
         * 2. Tìm kiếm tổ tiên của phần tử số (1) thỏa mãn điều kiện id='userName-wrapper'
         * 3. Thực hiện tìm kiếm trong toàn bộ phần tử (2) có tag là label
         * -> Đây chính là phần tử mà chúng ta cần tìm
         */

        String fullNameLabelXPath = "//input[@placeholder='Full Name']/ancestor::div[@id='userName-wrapper']//label";
        WebElement fullNameEls = webDriver.findElement(By.xpath(fullNameLabelXPath));

        // TODO: 10/05/2023 : Tìm kiếm với nhiều kịch bản position khác nhau cho cùng component


        // TODO: 10/05/2023 Làm tương tự với các đối tượng khác


        String ancestorXPath = "//*[@placeholder='name@example.com']/ancestor::div[@id='userEmail-wrapper']";
        WebElement ancestorXPathEle = webDriver.findElement(By.xpath(ancestorXPath));

        String descendantXPath = "//*[@id='userEmail-wrapper']/descendant::label[text()='Email']";
        WebElement descendantXPathEle = webDriver.findElement(By.xpath(descendantXPath));

        String precedingXPath = "//*[@type='email']/preceding::div[@id='fixedban']";
        WebElement precedingXPathEle = webDriver.findElement(By.xpath(precedingXPath));

        String followingXPath = "//*[@id='close-fixedban']/following::label[text()='Email']";
        WebElement followingXPathEle = webDriver.findElement(By.xpath(followingXPath));

        String upSiblingXPath = "//*[@id='Ad.Plus-300x250-2']/preceding-sibling::div";
        WebElement upSiblingXPathEle = webDriver.findElement(By.xpath(upSiblingXPath));

        String downSiblingXPath = "//*[@id='currentAddress-wrapper']/following-sibling::div[@id='output']";
        WebElement downSiblingXPathEle = webDriver.findElement(By.xpath(downSiblingXPath));
    }


    /**
     * Go to DemoQA Website
     */
    private void gotoDemoQAWebsite() {
        String url = "https://demoqa.com/text-box";
        webDriver.get(url);
    }


}
