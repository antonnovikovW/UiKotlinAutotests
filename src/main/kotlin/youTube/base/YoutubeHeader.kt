package youTube.base

import base.AbstractHeader
import com.codeborne.selenide.Condition.visible
import org.openqa.selenium.By.xpath
import utils.type

//TODO
class YoutubeHeader : AbstractHeader() {

    private val signInButton =
        find(xpath(".//*[@id='button' and @class='style-scope ytd-button-renderer style-suggestive size-small']"))
    private val logo = find(xpath(".//*[@id='logo-icon']"))
    private val searchField = find(xpath(".//input[@id='search']"))
    private val searchButton = find(xpath(".//*[@id='search-icon-legacy']"))
    private val burgerMenuButton = find(xpath(".//*[@id='guide-icon']"))
    private val linksButton = find(xpath(".(//yt-icon[@class='style-scope ytd-topbar-menu-button-renderer'])[1]"))
    private val settingsButton = find(xpath(".(//yt-icon[@class='style-scope ytd-topbar-menu-button-renderer'])[2]"))
    //TODO other elements

    /*TODO GoogleAuthorizationPage
    fun clickSignIn(init: GoogleAuthorizationPage.() -> Unit = {}): GoogleAuthorizationPage =
        signInButton.shouldBe(visible).click(init)
     */

    fun clickBurgerMenu(){
        burgerMenuButton.click()
    }

    fun searchVideo(name: String){
        searchField.type(name)
        searchButton.click()
    }

    override fun waitForLoaded() {
        super.waitForLoaded()
        listOf(
            logo,
            searchButton,
            searchField,
            burgerMenuButton,
            linksButton,
            settingsButton
        ).forEach { it.shouldBe(visible) }
    }
}