package base

abstract class AbstractWheelyPage<out H : AbstractHeader>(
    override val url: String
) : AbstractPage(url) {

    private val headerMenu: H by lazy { initHeader() }

    abstract fun initHeader(): H

    fun headerMenu(init: H.() -> Unit = {}): H = headerMenu.apply {
        waitForLoaded()
        init()
    }
}