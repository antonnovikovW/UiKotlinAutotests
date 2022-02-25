package youTube.pages

import base.*
import base.AbstractNavigationMenu
import youTube.base.AbstractYoutubePage
import youTube.frames.*
import youTube.pages.MainPageMenu.Items.*

class MainPageMenu : AbstractNavigationMenu(setOf(Main, Navigator, )) {

    interface Items {
        sealed class ShortMenuItem <F : AbstractFrame> : AbstractMenuItem<F>
        object Main : ShortMenuItem<MainFrame>()
        object Navigator : ShortMenuItem<NavigatorFrame>()
        object Subscriptions : ShortMenuItem<SubscriptionsFrame>()
        object Library : ShortMenuItem<LibraryFrame>()
        object History : ShortMenuItem<HistoryFrame>()
    }

    inline fun <reified F : AbstractFrame> openItem(
        item: Items.ShortMenuItem<F>,
        init: F.() -> Unit = {},
    ): F {
        val frame: AbstractFrame = when (selectItem(item)) {
            is Main -> MainFrame()
            is Navigator -> NavigatorFrame()
            is Subscriptions -> SubscriptionsFrame()
            is Library -> LibraryFrame()
            is History -> HistoryFrame()
        }
        return (frame as F).initFrame(init)
    }
}

class MainPage : AbstractYoutubePage <MainPageMenu, MainFrame>(frame = MainFrame()) {
    override fun initMenu(): MainPageMenu {
        TODO("Not yet implemented")
    }
}

//Метод открытия основной страницы
fun openMainPage(init: MainPage.() -> Unit = {}) = MainPage().apply{
    open<MainPage>()
    waitForLoaded()
    init()
}