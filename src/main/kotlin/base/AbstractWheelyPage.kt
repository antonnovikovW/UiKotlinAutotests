package base

abstract class AbstractWheelyPage<out H : AbstractHeaderMenu>(
    override val url: String
) : AbstractPage(url) {

    private val headerMenu: H by lazy { initHeaderMenu() }

    abstract fun initHeaderMenu(): H

    fun headerMenu(init: H.() -> Unit = {}): H = headerMenu.apply {
        waitForLoaded()
        init()
    }
}