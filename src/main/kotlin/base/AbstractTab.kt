package base

import utils.byXpath

interface Tab<T : AbstractTab>

abstract class AbstractTab : AbstractComponentsGroup(byXpath())