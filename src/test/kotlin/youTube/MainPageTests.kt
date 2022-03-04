package youTube

import data.VideoDataProvider
import org.assertj.core.api.Assertions.assertThat
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import youTube.base.searchContent
import youTube.base.youTubeHeader
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

    //TODO. В общем списке найденных видео, есть рекомендованные без содержания videoName в имени видео. Рекомендация: найти уникальные xpath на поиске или создать задачу на data-qa атрибут для отличия найденных элементов)
    @Test(
        enabled = false,
        dataProvider = "getFoundedVideo",
        dataProviderClass = VideoDataProvider::class
    )
    fun `Should found video`(videoName: String) {
        youTubeHeader {
            searchVideo(videoName)
        }
        searchContent {
            getVideos().forEach() {
                assertThat(it.nameVideo).contains(videoName)
            }
        }
    }
}