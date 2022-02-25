package youTube.frames
import base.AbstractFrame
import com.codeborne.selenide.Condition
import org.openqa.selenium.By
import utils.byXpath

class NavigatorFrame : AbstractFrame(byXpath("//*[@id='contents' and @class='style-scope ytd-section-list-renderer']")){

    private val chapterBlock = find(By.xpath(".//ytd-destination-shelf-renderer"))

    override fun waitForLoaded() {
        super.waitForLoaded()
        chapterBlock.shouldBe(Condition.visible)
    }
}

fun navigatorFrame(init: NavigatorFrame.() -> Unit = {}) = NavigatorFrame().apply {
    waitForLoaded()
    init()
}