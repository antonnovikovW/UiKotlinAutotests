package youTube

import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import youTube.pages.MainPageMenu.Items.*
import youTube.pages.mainPage
import youTube.pages.openMainPage

class MainPageTests {

    @BeforeClass
    fun beforeClass() {
        openMainPage {
        }
    }

    @Test
    fun `Should open menu items`() {
        mainPage {
            menu().openItem(Main)
            menu().openItem(Navigator)
            menu().openItem(Shorts)
            menu().openItem(Subscriptions)
            menu().openItem(Library)
            menu().openItem(History)
        }
    }
}