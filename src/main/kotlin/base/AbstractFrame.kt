package base

import utils.byXpath

abstract class AbstractFrame : AbstractComponentsGroup(byXpath("//*[@id='__next']"))