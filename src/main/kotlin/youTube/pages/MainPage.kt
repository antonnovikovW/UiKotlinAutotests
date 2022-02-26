package youTube.pages

import base.*
import base.AbstractNavigationMenu
import youTube.base.AbstractYoutubePage
import youTube.base.YoutubeHeader
import youTube.frames.*
import youTube.pages.MainPageMenu.Items.*

class MainPageMenu : AbstractNavigationMenu(setOf(Main, Navigator, Shorts, Subscriptions, Library, History)) {

    interface Items {
        sealed class MenuItem<F : AbstractFrame> : AbstractMenuItem<F>
        object Main : MenuItem<MainFrame>()
        object Navigator : MenuItem<NavigatorFrame>()
        object Shorts : MenuItem<ShortsFrame>()
        object Subscriptions : MenuItem<SubscriptionsFrame>()
        object Library : MenuItem<LibraryFrame>()
        object History : MenuItem<HistoryFrame>()
        //TODO other
    }

    //Метод открытия пунктов меню
    inline fun <reified F : AbstractFrame> openItem(
        item: Items.MenuItem<F>,
        init: F.() -> Unit = {},
    ): F {
        val frame: AbstractFrame = when (selectItem(item)) {
            is Main -> MainFrame()
            is Navigator -> NavigatorFrame()
            is Shorts -> ShortsFrame()
            is Subscriptions -> SubscriptionsFrame()
            is Library -> LibraryFrame()
            is History -> HistoryFrame()
            //TODO other
        }
        return (frame as F).initFrame(init)
    }
}

class MainPage : AbstractYoutubePage <MainPageMenu, MainFrame>(frame = MainFrame()) {
    override fun initMenu() = MainPageMenu()
}

//Метод открытия основной страницы
fun openMainPage(init: MainPage.() -> Unit = {}) = MainPage().apply{
    open<MainPage>()
    waitForLoaded()
    init()
}

fun mainPage(init: MainPage.() -> Unit = {}) = MainPage().apply {
    waitForLoaded()
    init()
}

