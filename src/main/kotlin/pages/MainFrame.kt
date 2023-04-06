package pages

import base.AbstractComponentsGroup
import com.codeborne.selenide.Condition
import org.openqa.selenium.By.xpath
import utils.byXpath

class MainFrame : AbstractComponentsGroup(byXpath("//*[@class='main-content']")) {

    private val firstScreenOneBlock = find(xpath(".//*[@class='first-screen-one']"))
    private val numbersBlock = find(xpath(".//*[@class='block-with-numbers']"))
    private val nearestWebinarsBlock = find(xpath(".//*[@class='nearest-webinars']"))
    private val integrationsBlock = find(xpath(".//*[contains(@class,'integrations']"))
    private val tasksBlock = find(xpath(".//*[@class='tasks']"))
    private val experienceBlock = find(xpath(".//*[@class='experience']"))
    private val featuresBlock = find(xpath(".//*[@class='features']"))
    private val reviewsBlock = find(xpath(".//*[@class='reviews']"))
    private val ratingBlock = find(xpath(".//*[@class='rating']"))
    private val onlineLearningBlock = find(xpath(".//*[@class='online-learning']"))
    private val controlBlock = find(xpath(".//*[@class='control']"))
    private val trainingBlock = find(xpath(".//*[contains(@class,'training-manual')]"))
    private val efficiencyBlock = find(xpath(".//*[@class='efficiency-mark']"))
    private val interfaceBlock = find(xpath(".//*[@class='interface']"))
    private val registrationBlock = find(xpath(".//*[@class='registration']"))
    private val platformBlock = find(xpath(".//*[@class='platform']"))
    private val tariffsBlock = find(xpath(".//*[@class='tariffs']"))

    override fun waitForLoaded() {
        listOf(
            firstScreenOneBlock,
            numbersBlock,
            nearestWebinarsBlock,
            integrationsBlock,
            tasksBlock,
            experienceBlock,
            featuresBlock,
            reviewsBlock,
            ratingBlock,
            onlineLearningBlock,
            controlBlock,
            trainingBlock,
            efficiencyBlock,
            interfaceBlock,
            registrationBlock,
            platformBlock,
            tariffsBlock,
        ).forEach { it.shouldBe(Condition.visible) }
    }
}