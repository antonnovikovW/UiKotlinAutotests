package youTube.frames

import base.AbstractFrame
import utils.byXpath

class MainFrame: AbstractFrame(byXpath("//ytd-rich-grid-renderer"))

fun mainFrame(init: MainFrame.() -> Unit = {}) = MainFrame().apply{
    waitForLoaded()
    init()
}