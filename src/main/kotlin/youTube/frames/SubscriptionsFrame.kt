package youTube.frames

import base.AbstractFrame
import utils.byXpath

class SubscriptionsFrame : AbstractFrame(byXpath("//ytd-browse[@role='main'] "))