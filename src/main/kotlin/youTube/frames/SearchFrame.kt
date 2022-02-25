package youTube.frames

import base.AbstractFrame
import utils.byXpath

class SearchFrame: AbstractFrame(byXpath("//ytd-search")) {
}
//ytd-mini-guide-renderer[@class='style-scope ytd-app']