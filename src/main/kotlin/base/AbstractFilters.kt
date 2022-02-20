package base

import utils.byXpath

interface Tab<T : AbstractFilters>

abstract class AbstractFilters : AbstractComponentsGroup(byXpath(".//*[@id='contents' and @class='style-scope ytd-rich-grid-renderer']"))