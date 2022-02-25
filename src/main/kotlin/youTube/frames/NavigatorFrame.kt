package youTube.frames
import base.AbstractFrame
import utils.byXpath

class NavigatorFrame : AbstractFrame(byXpath("//ytd-rich-grid-renderer"))