package youTube.base

import base.AbstractComponentsGroup
import com.codeborne.selenide.Condition.visible
import org.openqa.selenium.By.xpath
import utils.byXpath
import utils.type

//TODO
class YoutubeHeader : AbstractComponentsGroup(byXpath("//ytd-masthead")) {

    private val signInButton =
        find(xpath(".//*[@id='button' and @class='style-scope ytd-button-renderer style-suggestive size-small']"))
    private val logo = find(xpath(".//*[@id='logo-icon']"))
    private val searchField = find(xpath(".//input[@id='search']"))
    private val searchButton = find(xpath(".//*[@id='search-icon-legacy']"))
    private val burgerMenuButton = find(xpath(".//*[@id='guide-icon']"))

    //TODO other elements

    /*TODO GoogleAuthorizationPage
    fun clickSignIn(init: GoogleAuthorizationPage.() -> Unit = {}): GoogleAuthorizationPage =
        signInButton.shouldBe(visible).click(init)
     */

    fun clickBurgerMenu(){
        burgerMenuButton.click()
    }

    fun searchVideo(videoName: String){
        searchField.type(videoName)
        searchButton.click()
    }

    override fun waitForLoaded() {
        listOf(
            logo,
            searchButton,
            searchField,
            burgerMenuButton,
        ).forEach { it.shouldBe(visible) }
    }
}

fun youTubeHeader(init: YoutubeHeader.() -> Unit = {}) = YoutubeHeader().apply{
    waitForLoaded()
    init()
}