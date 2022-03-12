package base

import com.codeborne.selenide.Condition
import org.openqa.selenium.By.xpath
import utils.byXpath

abstract class AbstractFrame : AbstractComponentsGroup(byXpath("//*[@id='__next']"))