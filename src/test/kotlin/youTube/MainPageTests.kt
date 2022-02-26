package youTube

import data.VideoDataProvider
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import youTube.base.youTubeHeader
import youTube.frames.searchFrame
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

    @Test(dataProvider = "getFoundedVideo",
        dataProviderClass = VideoDataProvider ::class
    )
    fun `Should found video`(videoName: String) {
        youTubeHeader{
            searchVideo(videoName)
        }
        searchFrame {
            //TODO assert
        }
    }

}