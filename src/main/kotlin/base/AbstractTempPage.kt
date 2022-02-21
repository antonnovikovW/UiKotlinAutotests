package base

abstract class AbstractTempPage <out H : AbstractHeader, out F : AbstractFrame>(
    override val url: String,
    protected open val frame: F,
) : AbstractPage(url) {

    private val header: H by lazy { initHeader() }

    abstract fun initHeader(): H

    fun frame(init: F.() -> Unit = {}): F = frame.apply {
        waitForLoaded()
        init()
    }

    fun header(init: H.() -> Unit = {}): H = header.apply {
        waitForLoaded()
        init()
    }

    override fun waitForLoaded() {
        header.waitForLoaded()
        frame.waitForLoaded()
    }
}