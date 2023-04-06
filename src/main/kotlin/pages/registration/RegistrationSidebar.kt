package pages.registration

import base.AbstractComponentsGroup
import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import org.openqa.selenium.By
import utils.byXpath

class RegistrationSidebar : AbstractComponentsGroup(byXpath("//*[contains(@class,'message-box')]")) {

    private val blockTitle = find(
        By.xpath(".//*[contains(@class,'block-title')]"))
    private val nameField = find(By.xpath(".//*[@id='name']"))
    private val lastNameField = find(By.xpath(".//*[@id='last_name']"))
    private val emailField = find(By.xpath(".//*[@id='email']"))
    private val phoneField = find(By.xpath(".//*[@id='phone']//input"))
    private val passwordField = find(By.xpath(".//*[@id='password']"))
    private val purposeDropdown = find(By.xpath(".//*[@name='purpose_of_use']"))
    private val ofertaLink = find(By.xpath(".//*[@class='form-link'][1]"))
    private val personalDataLink = find(By.xpath(".//*[@class='form-link'][2]"))
    private val enterBtn = find(By.xpath(".//*[contains(@class,'btn-registration')]"))

    //TODO locators without indexes
    private val nameError = byXpath("(//*[contains(text(),'Обязательное поле')])[1]")
    private val lastNameError = byXpath("(//*[contains(text(),'Обязательное поле')])[2]")
    private val passwordError = byXpath("(//*[contains(text(),'Обязательное поле')])[3]")
    private val purposeError = byXpath("(//*[contains(text(),'Обязательное поле')])[4]")

    private val emailError = byXpath("//*[contains(text(),'адрес в правильном формате')]")
    private val phoneError = byXpath("//*[contains(text(),'телефон в правильном формате')]")


    override fun waitForLoaded() {
        listOf(
            blockTitle,
            nameField,
            lastNameField,
            emailField,
            phoneField,
            passwordField,
            purposeDropdown,
            ofertaLink,
            personalDataLink,
            enterBtn
        ).forEach { it.shouldBe(Condition.visible) }
    }

    @Step("Нажать на кнопку 'Зарегистрироваться и провести встречу'")
    fun registerAndEnter() {
        enterBtn.click()
    }

    @Step("Проверка валидации пустых значений")
    fun assertEmptyValidation() {
        listOf(
            nameError, lastNameError, passwordError, purposeError, emailError, phoneError
        ).forEach {
            it.shouldBe(Condition.visible)
        }
    }
}
