package pages.tariffs

import base.AbstractFrame
import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import pages.registration.RegistrationSidebar
import utils.byXpath
import utils.click

class TariffsWebinarEnterpriseBlock : AbstractFrame() {

    private val enterpriseTitles = byXpath("//*[contains(@id,'tab-enterprise')]")
    private val tryFreeEnterpriseBtn = byXpath("(//*[contains(@class,'main-control__btn')])[1]")
    private val tryFreeTotalBtn = byXpath("(//*[contains(@class,'main-control__btn')])[2]")

    override fun waitForLoaded() {
        super.waitForLoaded()
        listOf(
            enterpriseTitles, tryFreeEnterpriseBtn, tryFreeTotalBtn
        ).forEach { it.shouldBe(Condition.visible) }
    }

    @Step("Нажать на кнопку 'Попробовать бесплатно' Webinar Enterpise")
    fun tryFreeEnterprise() {
        tryFreeEnterpriseBtn.click()
    }

    @Step("Нажать на кнопку 'Попробовать бесплатно' Webinar Total")
    fun tryFreeTotal(init: RegistrationSidebar.() -> Unit = {}): RegistrationSidebar {
        return tryFreeTotalBtn.click(init)
    }
}