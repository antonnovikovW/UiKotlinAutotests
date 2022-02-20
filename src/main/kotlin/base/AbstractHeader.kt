package base

import com.codeborne.selenide.Condition.visible
import org.openqa.selenium.By.xpath
import utils.byXpath
import utils.click

abstract class AbstractHeader : AbstractComponentsGroup(byXpath("//*[@id='container' and @class='style-scope ytd-masthead']")) {

    protected val logo = find(xpath(".//*[@id='logo-icon']"))
    protected val signInButton = find(xpath(".//*[@id='button' and @class='style-scope ytd-button-renderer style-suggestive size-small']"))
    protected val searchField = find(xpath(".//input[@id='search']"))
    protected val searchButton = find(xpath(".//*[@id='search-icon-legacy']"))
    protected val burgerMenu = find(xpath(".//*[@id='guide-icon']"))
    //TODO other elements

    override fun waitForLoaded() {
        super.waitForLoaded()
        listOf(
            logo,
            searchButton,
            searchField,
            burgerMenu
        ).forEach { it.shouldBe(visible) }
    }
}