package pages.tariffs

import base.*
import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.tariffs.TariffsFrameMenu.Items.*
import utils.byXpath

class TariffsFrame : AbstractTariffsFrame<TariffsFrameMenu>() {

    private val tariffsTitle = byXpath(".//*[contains(@class,'tariffs__title')]")
    private val tariffsTabs = byXpath(".//*[contains(@class,'tariffs-tab')]")

    override fun waitForLoaded() {
        listOf(
            tariffsTitle, tariffsTabs
        ).forEach { it.shouldBe(Condition.visible) }
    }

    override fun initTariffsFrameMenu() = TariffsFrameMenu()
}

class TariffsFrameMenu : AbstractTariffsMenu(setOf(Webinar, WebinarEnterprise, Comdi)) {
    interface Items {
        sealed class TariffsFrameMenuItem<F : AbstractComponentsGroup> : AbstractFrameMenuItem<F>
        object Webinar : TariffsFrameMenuItem<TariffsWebinarBlock>()
        object WebinarEnterprise : TariffsFrameMenuItem<TariffsWebinarEnterpriseBlock>()

        //TODO
        object Comdi : TariffsFrameMenuItem<TariffsWebinarBlock>()
    }

    @Step("Click tariffs item")
    inline fun <reified B : AbstractComponentsGroup> openBlock(
        item: TariffsFrameMenuItem<B>,
        init: B.() -> Unit = {},
    ): B {
        val frame: AbstractComponentsGroup = when (selectItem(item)) {
            is Webinar -> TariffsWebinarBlock()
            is WebinarEnterprise -> TariffsWebinarEnterpriseBlock()
            is Comdi -> TariffsWebinarBlock()
        }
        return (frame as B).initFrame(init)
    }
}
