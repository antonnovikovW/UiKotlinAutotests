package base

import com.codeborne.selenide.Condition
import org.openqa.selenium.By
import utils.byXpath

abstract class AbstractFrame : AbstractComponentsGroup(byXpath())
    class EmptyFrame : AbstractFrame()

    abstract class AbstractTabbedFrame(
        private val tabs: Set<Tab<*>>,
    ) : AbstractFrame()
    {
        private val tabsMenu = find(By.xpath())

        fun <T : Tab<G>, G : AbstractTab> selectTab(tab: T): T = tab.apply {
            val tabIndex = tabs.indexOf(this)
            if (tabIndex == UNKNOWN_INDEX) {
                throw IllegalArgumentException("No such '${this::class.simpleName}' tab found")
            }
            findCollection(By.xpath())[tabIndex].click()
        }

        override fun waitForLoaded() {
            super.waitForLoaded()
            tabsMenu.shouldBe(Condition.visible)
        }
}