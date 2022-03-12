package pages

import base.AbstractFrame
import com.codeborne.selenide.Condition
import models.User
import utils.byXpath
import utils.type


class BusinessFrame : AbstractFrame() {

    private val titleBusinessFrame = byXpath(".//*[@class='Frame_frame__title__rNHD7']")
    private val infoBusinessFrame = byXpath(".//*[@class='spacing-paragraph block size-l Frame_frame__text__8eupL']")
    private val openNewAccountButton =
        byXpath("//*[@class='container-icon container-icon--inline container-icon--theme-dark icon-right spacing-extra-paragraph block size-l Frame_frame__button__jDAYQ platter platter-light']")
    private val infoReference = byXpath("//*[@class='styles_features__CT_Uc']")
    private val openNewAccountFrame = byXpath(".//*[@class='styles_form__9MS_n']")

    private val companyNameField = byXpath("//*[@name='companyName']")
    private val nameField = byXpath(".//*[@data-test='name-field']")
    private val emailField = byXpath(".//*[@data-test='email-field']")
    private val phoneField = byXpath(".//*[@data-test='field-phone-number']")
    private val submitButton = byXpath(".//*[@data-test='b2b-submit']")

    override fun waitForLoaded() {
        listOf(
            titleBusinessFrame, infoBusinessFrame, openNewAccountButton, infoReference, openNewAccountFrame
        ).forEach { it.shouldBe(Condition.visible) }
    }

    private fun typeCompanyName(companyName: String) =
        companyNameField.type(companyName)

    private fun typeName(name: String) =
        nameField.type(name)

    private fun typeEmail(email: String) =
        emailField.type(email)

    private fun typePhone(phone: String) =
        phoneField.type(phone)

    fun createApplication(user: User) {
        with(user) {
            typeCompanyName(companyName)
            typeName(name)
            typeEmail(email)
            typePhone(phone)
            //submitButton.click()
        }
    }
}

fun businessFrame(init: BusinessFrame.() -> Unit = {}) = BusinessFrame().apply {
    waitForLoaded()
    init()
}