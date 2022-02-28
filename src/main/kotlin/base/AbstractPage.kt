package base

//Абстрактный класс общей Page для инициализации меню и фрейма
abstract class AbstractTestPage<out M : AbstractMenu, out F : AbstractFrame>(
    override val url: String,
    protected open val frame: F,
) : AbstractPage(url) {

    fun frame(init: F.() -> Unit = {}): F = frame.apply {
        waitForLoaded()
        init()
    }

    private val menu: M by lazy { initMenu() }

    abstract fun initMenu(): M

    fun menu(init: M.() -> Unit = {}): M = menu.apply {
        waitForLoaded()
        init()
    }

    override fun waitForLoaded() {
        frame.waitForLoaded()
    }
}