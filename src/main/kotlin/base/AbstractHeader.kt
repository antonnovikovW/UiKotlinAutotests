package base

import com.codeborne.selenide.Condition.visible
import org.openqa.selenium.By.xpath
import utils.byXpath
import utils.click

abstract class AbstractHeader : AbstractComponentsGroup(byXpath()) {

    protected val logo = find(xpath())

    override fun waitForLoaded() {
        super.waitForLoaded()
        listOf(
            logo,
        ).forEach { it.shouldBe(visible) }
    }
}