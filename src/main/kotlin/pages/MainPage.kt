package pages

import base.*
import com.codeborne.selenide.Condition
import pages.MainHeaderMenu.Items.*
import pages.tariffs.TariffsFrame
import utils.byXpath

class MainPage : AbstractWebinarPage<MainHeaderMenu>("") {

    private val mainContent = byXpath(".//*[contains(@class,'main-content')]")

    override fun waitForLoaded() {
        listOf(mainContent).forEach { it.shouldBe(Condition.visible) }
    }

    override fun initHeaderMenu() = MainHeaderMenu()
}

class MainHeaderMenu : AbstractHeaderMenu(setOf(Tasks, Products, Departments, Tariffs, Cases)) {
    interface Items {
        sealed class MainHeaderMenuItem<F : AbstractFrame> : AbstractMenuItem<F>

        //TODO сделать для прочих пунктов меню
        object Tasks : MainHeaderMenuItem<TariffsFrame>()
        object Products : MainHeaderMenuItem<TariffsFrame>()
        object Departments : MainHeaderMenuItem<TariffsFrame>()
        object Tariffs : MainHeaderMenuItem<TariffsFrame>()
        object Cases : MainHeaderMenuItem<TariffsFrame>()
    }

    inline fun <reified F : AbstractFrame> openBlock(
        item: MainHeaderMenuItem<F>,
        init: F.() -> Unit = {},
    ): F {
        val frame: AbstractFrame = when (selectItem(item)) {
            //TODO сделать прочие фреймов
            is Tasks -> TariffsFrame()
            is Products -> TariffsFrame()
            is Departments -> TariffsFrame()
            is Tariffs -> TariffsFrame()
            is Cases -> TariffsFrame()
        }
        return (frame as F).initFrame(init)
    }
}

fun openMainPage(init: MainPage.() -> Unit = {}) = MainPage().apply {
    open<MainPage>()
    waitForLoaded()
    init()
}