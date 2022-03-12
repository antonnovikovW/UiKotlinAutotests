package pages

import base.*
import com.codeborne.selenide.Condition
import utils.byXpath
import pages.MainHeaderMenu.Items.*

class MainHeaderMenu : AbstractHeaderMenu(setOf(BusinessAccount)){

    interface Items{
        sealed class MainHeaderMenuItem<F : AbstractFrame> : AbstractMenuItem<F>
        object BusinessAccount : MainHeaderMenuItem<BusinessFrame>()
    }

    inline fun <reified F : AbstractFrame> openItem(
        item:  MainHeaderMenuItem<F>,
        init: F.() -> Unit = {},
    ): F {
        val frame: AbstractFrame = when (selectItem(item)) {
            is BusinessAccount -> BusinessFrame()
        }
        return (frame as F).initFrame(init)
    }

}

class MainPage : AbstractWheelyPage<MainHeaderMenu>("")
{

    private val titleBusinessFrame = byXpath(".//*[@class='Frame_frame__title__u9V_e']")
    private val infoBusinessFrame = byXpath(".//*[@class='Frame_frame__content__ZNdql']")

    override fun waitForLoaded() {
        listOf(titleBusinessFrame, infoBusinessFrame).forEach { it.shouldBe(Condition.visible) }
    }

    override fun initHeaderMenu(): MainHeaderMenu {
        TODO("Not yet implemented")
    }

}

fun openMainPage(init: MainPage.() -> Unit = {}) = MainPage().apply {
    open<MainPage>()
    waitForLoaded()
    init()
}