package base

import com.codeborne.selenide.Credentials


abstract class AbstractTempPage <out H : AbstractHeader, out M : AbstractMenu, out F : AbstractFrame>(
    override val url: String,
    protected open val frame: F,
) : AbstractPage(url) {

    private val header: H by lazy { initHeader() }

    private val menu: M by lazy { initMenu() }

    abstract fun initHeader(): H

    abstract fun initMenu(): M

    fun frame(init: F.() -> Unit = {}): F = frame.apply {
        waitForLoaded()
        init()
    }

    fun header(init: H.() -> Unit = {}): H = header.apply {
        waitForLoaded()
        init()
    }

    fun menu(init: M.() -> Unit = {}): M = menu.apply {
        waitForLoaded()
        init()
    }

    override fun waitForLoaded() {
        menu.waitForLoaded()
        header.waitForLoaded()
        frame.waitForLoaded()
    }
}