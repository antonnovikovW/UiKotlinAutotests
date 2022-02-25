package youTube.frames

import base.AbstractFrame
import utils.byXpath

class LibraryFrame : AbstractFrame(byXpath("//ytd-browse[@role='main']"))