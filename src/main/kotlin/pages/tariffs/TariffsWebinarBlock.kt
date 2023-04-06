package pages.tariffs

import base.AbstractFrame
import utils.byXpath

class TariffsWebinarBlock : AbstractFrame() {

    private val webinarTabs = byXpath("//*[contains(@id,'tab-webinar')]")
}