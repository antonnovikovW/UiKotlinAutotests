package pages

import base.AbstractPage
import base.open
import com.codeborne.selenide.Condition
import utils.byXpath

class MainPage : AbstractPage() {

    private val titleBusinessFrame = byXpath(".//*[@class='Frame_frame__title__u9V_e']")
    private val infoBusinessFrame = byXpath(".//*[@class='Frame_frame__content__ZNdql']")

    override fun waitForLoaded() {
        listOf(titleBusinessFrame, infoBusinessFrame).forEach { it.shouldBe(Condition.visible) }
    }
}

fun openMainPage(init: MainPage.() -> Unit = {}) = MainPage().apply {
    open<BusinessPage>()
    waitForLoaded()
    init()
}