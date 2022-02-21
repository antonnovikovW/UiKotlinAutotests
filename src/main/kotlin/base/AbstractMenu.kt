package base

import org.openqa.selenium.By.xpath
import utils.byXpath

inline fun <F : AbstractFrame> F.initFrame(init: F.() -> Unit = {}): F = apply {
    waitForLoaded()
    init()
}

abstract class AbstractMenu(
    protected open val items: Set<AbstractMenuItem<*>>,
) : AbstractComponentsGroup(byXpath("//ytd-mini-guide-renderer[@class='style-scope ytd-app']")) {

    fun <I : AbstractMenuItem<*>> selectItem(item: I): I = item.apply {
        val itemIndex: Int = items.indexOf(item)
        if (itemIndex == UNKNOWN_INDEX) {
            throw IllegalArgumentException("No such '${item::class.simpleName}' item found")
        }
        findCollection(xpath(".//*[@role='tab']"))[itemIndex].click()
    }
}

abstract class AbstractNavigationMenu(override val items: Set<AbstractMenuItem<*>>) : AbstractMenu(items) {

        override fun waitForLoaded() {
        super.waitForLoaded()
        //TODO("добавить проверку!!!")
    }
}