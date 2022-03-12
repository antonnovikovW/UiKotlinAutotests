package pages

import base.*
import com.codeborne.selenide.Condition
import pages.MainHeaderMenu.Items.*
import utils.byXpath

class MainHeaderMenu : AbstractHeaderMenu(setOf(CitiesAndPrices, ForDriver, ForBusiness)) {

    interface Items {
        sealed class MainHeaderMenuItem<F : AbstractFrame> : AbstractMenuItem<F>

        //TODO сделать для прочих пунктов меню
        object CitiesAndPrices : MainHeaderMenuItem<BusinessFrame>()
        object ForDriver : MainHeaderMenuItem<BusinessFrame>()
        object ForBusiness : MainHeaderMenuItem<BusinessFrame>()
    }

    inline fun <reified F : AbstractFrame> openBlock(
        item: MainHeaderMenuItem<F>,
        init: F.() -> Unit = {},
    ): F {
        val frame: AbstractFrame = when (selectItem(item)) {
            //TODO сделать прочие фреймов
            is CitiesAndPrices -> BusinessFrame()
            is ForDriver -> BusinessFrame()
            is ForBusiness -> BusinessFrame()
        }
        return (frame as F).initFrame(init)
    }
}

class MainPage : AbstractWheelyPage<MainHeaderMenu>("") {

    private val titleBusinessFrame = byXpath(".//*[@class='Frame_frame__title__u9V_e']")
    private val infoBusinessFrame = byXpath(".//*[@class='Frame_frame__content__ZNdql']")

    override fun waitForLoaded() {
        listOf(titleBusinessFrame, infoBusinessFrame).forEach { it.shouldBe(Condition.visible) }
    }

    override fun initHeaderMenu() = MainHeaderMenu()

}

fun openMainPage(init: MainPage.() -> Unit = {}) = MainPage().apply {
    open<MainPage>()
    waitForLoaded()
    init()
}