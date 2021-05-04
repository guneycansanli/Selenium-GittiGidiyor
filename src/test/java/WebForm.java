// Page URL: https://formy-project.herokuapp.com/form

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class WebForm extends PageObject {

    private final String EMAIL = "guneycansanli@hotmail.com";
    private final String PASSWORD = "123abc";


    @FindBy(id = "L-UserNameField")
    private WebElement e_mail;

    @FindBy(id = "L-PasswordField")
    private WebElement last_name;

    @FindBy(id = "gg-login-enter")
    private WebElement sign_in;

    @FindBy(id = "add-to-basket")
    private WebElement add_to_basket;

    @FindBy(xpath = "//div[@data-cy='header-user-menu']")
    private WebElement login_div;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement search_input;

    @FindBy(css = "[data-cy='header-login-button']")
    private WebElement login_button;

    @FindBy(css = ".qjixn8-0.sc-1bydi5r-0.hKfdXF")
    private WebElement search_button;

    @FindBy(css = ".pager.pt30>:first-child>:nth-child(2)>:first-child") //1. child after 2. child after 1. child
    private WebElement click_second_page;

    @FindBy(css = "[class='catalog-view clearfix products-container']>:nth-child(1)>:first-child")
    private WebElement select_item;

    @FindBy(css = ".basket-container.robot-header-iconContainer-cart>:first-child")
    private WebElement go_basket;

    @FindBy(css = "div[class='total-price']")
    private WebElement basket_price;

    @FindBy(id = "sp-price-lowPrice")
    private WebElement take_price;

    @FindBy(id = "sp-price-lowPrice")
    private WebElement item_price;

    @FindBy(css = "option[value='2']")
    private WebElement add_one_item;

    @FindBy(css = "li[class='clearfix total-price-sticky-container']>:nth-child(1)")
    private WebElement get_items;

    @FindBy(css = "a[title='Sil']")
    private WebElement delete_basket;

    @FindBy(css = "div[class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']>:nth-child(1)")
    private WebElement empty_test;

    @FindBy(xpath = "//*[@id='__next']/main/section/section/a")
    private WebElement clear_cookie;

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterEmail() {
        this.e_mail.sendKeys(EMAIL);
    }

    public void enterPassword() {
        this.last_name.sendKeys(PASSWORD);
    }

    public void pressLoginDiv() {
        this.login_div.click();
    }

    public void signIn() {
        this.sign_in.click();
    }

    public void pressLoginButton() {
        this.login_button.click();
    }

    public void pressSearchButton() {
        this.search_button.click();
    }

    public void searchInput(String searchInput) {      // From Test Plan
        this.search_input.sendKeys(searchInput);
    }

    public void clickSecondPage() {
        this.click_second_page.click();
    }

    public void selectItem() {
        this.select_item.click();
    }

    public void addToBasket() {
        this.add_to_basket.click();
    }

    public void goBasket() {
        this.go_basket.click();
    }

    public String itemPrice() {
        return this.item_price.getText();
    }

    public String basketPrice() {
        return this.basket_price.getText();
    }

    public void addOneItem() {
        this.add_one_item.click();
    }

    public String getItems() {
        return this.get_items.getText();
    }

    public void deleteBasket() {
        this.delete_basket.click();
    }

    public String getUrl() {
        return "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
    }

    public String emptyTest() {
        return empty_test.getText();
    }

    public void clearCookie() {
        this.clear_cookie.click();
    }

}