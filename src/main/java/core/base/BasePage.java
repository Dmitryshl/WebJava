package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {
    protected SelenideElement headerLogo = $("[tsid ='toolbar_logo']");
    protected SelenideElement searchField = $x("//input[@name = 'st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    protected SelenideElement emailInput = $x("//input[@name = 'st.email']");
    protected SelenideElement passwordInput = $x("//input[@name = 'st.password']");

    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }
    public void openvkServices() {
        vkServices.shouldBe(visible).click();}

    public void clickLogo(){
        headerLogo.shouldBe(visible).click();
    }

}
