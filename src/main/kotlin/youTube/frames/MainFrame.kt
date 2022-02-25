package youTube.frames

import base.AbstractFrame
import com.codeborne.selenide.Condition
import org.openqa.selenium.By
import utils.byXpath

class MainFrame : AbstractFrame(byXpath("//ytd-rich-grid-renderer")) {

    private val filtersBlock = find(By.xpath(".//*[@id='chips']"))

    override fun waitForLoaded() {
        super.waitForLoaded()
        filtersBlock.shouldBe(Condition.visible)
    }

}

fun mainFrame(init: MainFrame.() -> Unit = {}) = MainFrame().apply {
    waitForLoaded()
    init()
}