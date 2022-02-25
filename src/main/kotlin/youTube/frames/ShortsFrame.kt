package youTube.frames

import base.AbstractFrame
import com.codeborne.selenide.Condition
import org.openqa.selenium.By
import utils.byXpath

class ShortsFrame : AbstractFrame(byXpath("//ytd-shorts")) {

    private val shortPlayer = find(
        By.xpath(".//*[@id='shorts-container']")
    )

    override fun waitForLoaded() {
        super.waitForLoaded()
        shortPlayer.shouldBe(Condition.visible)
    }
}