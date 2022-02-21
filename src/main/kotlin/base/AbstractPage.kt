package base

abstract class AbstractTestPage <out F : AbstractFrame>(
    override val url: String,
    protected open val frame: F,
) : AbstractPage(url) {

    fun frame(init: F.() -> Unit = {}): F = frame.apply {
        waitForLoaded()
        init()
    }

    override fun waitForLoaded() {
        frame.waitForLoaded()
    }
}