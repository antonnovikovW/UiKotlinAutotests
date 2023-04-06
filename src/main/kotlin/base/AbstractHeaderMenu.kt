package base

import com.codeborne.selenide.Condition.visible
import org.openqa.selenium.By.xpath
import utils.byXpath

inline fun <F : AbstractComponentsGroup> F.initFrame(init: F.() -> Unit = {}): F = apply {
    waitForLoaded()
    init()
}

abstract class AbstractHeaderMenu(
    protected open val items: Set<AbstractMenuItem<*>>
) :
    AbstractComponentsGroup(byXpath("//*[@class='header']")) {

    protected val logo = find(xpath(".//*[@class='logo__link']"))

    fun <I : AbstractMenuItem<*>> selectItem(item: I): I = item.apply {
        val itemIndex: Int = items.indexOf(item)
        if (itemIndex == UNKNOWN_INDEX) {
            throw IllegalArgumentException("No such '${item::class.simpleName}' item found")
        }
        findCollection(xpath(".//*[@class='menu__item']"))[itemIndex].hover().click()
        //TODO open menu row
        //find(xpath(".//*[@class='menu__list']//*[@class='header-popup__link' and contains(text(),'Промышленность')]")).click()
    }

    override fun waitForLoaded() {
        super.waitForLoaded()
        listOf(
            logo,
        ).forEach { it.shouldBe(visible) }
    }
}