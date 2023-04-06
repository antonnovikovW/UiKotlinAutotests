import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.testng.annotations.BeforeSuite

open class BaseTest {

    @BeforeSuite(alwaysRun = true)
    fun beforeSuite() {
        SelenideLogger.addListener("AllureSelenide", AllureSelenide().screenshots(true).savePageSource(false))
    }
}