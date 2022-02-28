package youTube.frames

import base.AbstractFrame
import com.codeborne.selenide.Condition
import org.openqa.selenium.By.xpath
import utils.byXpath

class SearchFrame : AbstractFrame(byXpath("//ytd-section-list-renderer")) {

    private val filtersButton =
        find(xpath(".//tp-yt-paper-button[@class='style-scope ytd-toggle-button-renderer style-text']"))

    override fun waitForLoaded() {
        super.waitForLoaded()
        filtersButton.shouldBe(Condition.visible)
    }
}

//ytd-mini-guide-renderer[@class='style-scope ytd-app']
fun searchFrame(init: SearchFrame.() -> Unit = {}) = SearchFrame().apply {
    waitForLoaded()
    init()
}