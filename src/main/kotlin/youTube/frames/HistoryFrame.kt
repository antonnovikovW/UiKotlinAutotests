package youTube.frames

import base.AbstractFrame
import utils.byXpath

class HistoryFrame: AbstractFrame(byXpath("//ytd-browse[@role='main']"))