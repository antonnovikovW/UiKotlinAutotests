package base

import com.codeborne.selenide.Condition.visible
import org.openqa.selenium.By
import org.openqa.selenium.By.xpath
import utils.byXpath

inline fun <F : AbstractFrame> F.initFrame(init: F.() -> Unit = {}): F = apply {
    init()
}

abstract class AbstractHeaderMenu(
    protected open val items: Set<AbstractMenuItem<*>>
) : AbstractComponentsGroup(byXpath("//*[@class='headroom headroom--unfixed']")) {

    private val logotype = find(xpath(".//*[@area-label='Go to the main page']"))

    fun <I : AbstractMenuItem<*>> selectItem(item: I): I = item.apply {
        val itemIndex: Int = items.indexOf(item)
        if (itemIndex == UNKNOWN_INDEX) {
            throw IllegalArgumentException("No such '${item::class.simpleName}' item found")
        }
        findCollection(xpath("//*[@class='styles_tooltip-wrapper__zYmHm styles_menu-item__S6yg4 wh-hidden@tablet wh-hidden@mobile']"))[itemIndex].click()
    }

    override fun waitForLoaded() {
        super.waitForLoaded()
        listOf(
            logotype
        ).forEach { it.shouldBe(visible) }
    }
}
