package base

import utils.byXpath

abstract class AbstractHeader : AbstractComponentsGroup(byXpath("//*[@id='container' and @class='style-scope ytd-masthead']"))