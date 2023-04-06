package base

import utils.byXpath

abstract class AbstractTariffsFrame<out H : AbstractTariffsMenu>() : AbstractFrame() {

    private val tariffsMenu: H by lazy { initTariffsFrameMenu() }

    abstract fun initTariffsFrameMenu(): H

    fun tariffsMenu(init: H.() -> Unit = {}): H = tariffsMenu.apply {
        waitForLoaded()
        init()
    }
}

abstract class AbstractFrame : AbstractComponentsGroup(byXpath("//main"))
