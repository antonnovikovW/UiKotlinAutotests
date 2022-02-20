package base

import org.openqa.selenium.By.xpath
import utils.byXpath

inline fun <F : AbstractFrame> F.initFrame(init: F.() -> Unit = {}): F = apply {
    waitForLoaded()
    init()
}

//For short menu.
abstract class AbstractMenu(
    protected open val items: Set<AbstractMenuItem<*>>,
) : AbstractComponentsGroup(byXpath("//ytd-mini-guide-renderer[@role='navigation']//*[@id='items']")) {

    fun <I : AbstractMenuItem<*>> selectItem(item: I): I = item.apply {
        val itemIndex: Int = items.indexOf(item)
        if (itemIndex == UNKNOWN_INDEX) {
            throw IllegalArgumentException("No such '${item::class.simpleName}' item found")
        }
        findCollection(xpath("//*[@id='endpoint']"))[itemIndex].click()
    }
}
