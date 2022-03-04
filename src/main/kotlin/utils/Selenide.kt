package utils

import base.LoadableComponent
import com.codeborne.selenide.*
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0
import kotlin.reflect.full.primaryConstructor

fun byClass(className: String) = Selenide.element(By.className(className))

fun byId(id: String) = Selenide.element(By.id(id))

fun byXpath(xPath: String) = Selenide.element(By.xpath(xPath))

fun collectionByXpath(xPath: String): ElementsCollection = Selenide.`$$`(By.xpath(xPath))

inline fun <reified C : LoadableComponent> SelenideElement.click(noinline init: C.() -> Unit): C {
    val page: C = primaryConstructor<C>().call()
    click()
    return page.apply {
        waitForLoaded()
        init()
    }
}

fun SelenideElement.getMainText() = this.ownText.trim().replace("\\s+".toRegex(), " ")

fun SelenideElement.getMainTextOrDefault(default: String = "") = if (isDisplayed) getMainText() else default

inline fun <reified T> open(relativeOrAbsoluteUrl: String, credentials: Credentials? = null): T {
    return Selenide.open(
        relativeOrAbsoluteUrl,
        "",
        credentials?.login ?: "",
        credentials?.password ?: "",
        T::class.java
    )
}

inline fun <reified C : LoadableComponent> primaryConstructor(): KFunction<C> =
    C::class.primaryConstructor ?: throw NoSuchMethodException("Primary constructor doesn't exist")

inline fun <reified R> SelenideElement.switchAndExecute(init: () -> R): R {
    WebDriverRunner.getWebDriver().switchTo().frame(this)
    val result = init()
    WebDriverRunner.getWebDriver().switchTo().defaultContent()
    return result
}

fun SelenideElement.type(source: String) {
    sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.DELETE))
    value = source
}

object InputTextElements {

    operator fun KProperty0<SelenideElement>.getValue(thisRef: Any?, property: KProperty<*>): String =
        get().value ?: ""

    operator fun KProperty0<SelenideElement>.setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: String,
    ) {
        get().type(value)
    }
}

object TextElements {
    operator fun KProperty0<SelenideElement>.getValue(thisRef: Any?, property: KProperty<*>): String =
        get().getMainText()
}