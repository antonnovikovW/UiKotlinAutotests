package base

import com.codeborne.selenide.Condition.visible
import io.qameta.allure.Step
import org.openqa.selenium.By
import utils.byXpath

abstract class AbstractTariffsMenu(
    protected open val items: Set<AbstractFrameMenuItem<*>>
) : AbstractComponentsGroup(byXpath("//*[@class='tab-list']")) {

    fun <I : AbstractFrameMenuItem<*>> selectItem(item: I): I = item.apply {
        val itemIndex: Int = items.indexOf(item)
        if (itemIndex == UNKNOWN_INDEX) {
            throw IllegalArgumentException("No such '${item::class.simpleName}' item found")
        }
        findCollection(By.xpath("./div[contains(@class,'tab-list__item')]"))[itemIndex].shouldBe(visible).click()
    }


}