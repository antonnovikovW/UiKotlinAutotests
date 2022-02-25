package base

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

abstract class AbstractFrame(
    protected open val rootElement: SelenideElement,
) : LoadableComponent {
    protected fun find(by: By): SelenideElement = Selenide.`$`(rootElement).`$`(by)

    override fun waitForLoaded() {
        rootElement.shouldBe(Condition.visible)
    }
}
