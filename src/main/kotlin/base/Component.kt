package base

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.hidden
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Credentials
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

const val INDEX_FOR_XPATH = 1
const val UNKNOWN_INDEX = -1

@DslMarker
annotation class ElementMarker

@ElementMarker
interface Component

interface LoadableComponent : Component {
    fun waitForLoaded()
}

abstract class AbstractPage(
    open val url: String = "",
    open val credentials: Credentials? = null,
) : LoadableComponent

inline fun <reified T> AbstractPage.open(): T = utils.open(url, credentials)

abstract class AbstractComponentsGroup(
    protected open val rootElement: SelenideElement,
) : LoadableComponent {

    protected fun find(by: By): SelenideElement = `$`(rootElement).`$`(by)

    protected fun findCollection(by: By): ElementsCollection = `$`(rootElement).`$$`(by)

    fun clickAndCloseGroup(element: SelenideElement) {
        element.click()
        rootElement.shouldBe(hidden)
    }

    open fun shouldBe(vararg condition: Condition) {
        rootElement.shouldBe(*condition)
    }

    open fun shouldNotBe(vararg condition: Condition) {
        rootElement.shouldNotBe(*condition)
    }

    fun typeAndResetFocus(element: SelenideElement, text: String) {
        element.value = text
        rootElement.click()
    }

    override fun waitForLoaded() {
        rootElement.shouldBe(visible)
    }
}