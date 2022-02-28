package youTube.base

import base.AbstractComponentsGroup
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import utils.byXpath
import utils.getMainText

class SearchContent(
) : AbstractComponentsGroup(byXpath("//*[@id='contents' and @class='style-scope ytd-section-list-renderer']")) {

    private val contentBlock = find(By.xpath(".//ytd-item-section-renderer"))
    private val videosCollection: ElementsCollection get() = contentBlock.findAll(By.xpath(".//ytd-video-renderer"))
    private val firstVideo = byXpath("(//ytd-video-renderer)[1]")

    //Собрать коллекцию видео, представленных на странице
    fun getVideos(): List<ContentBlock> {
        return videosCollection.map(::ContentBlock)
    }

    fun getFirstVideos(): SelenideElement {
        return firstVideo
    }
}

class ContentBlock(videoElement: SelenideElement) {
    private val videoTitle = videoElement.find(By.xpath(".//*[@id='video-title']"))
    val nameVideo: String get() = videoTitle.getMainText()
}

fun searchContent(init: SearchContent.() -> Unit = {}) = SearchContent().apply {
    waitForLoaded()
    init()
}