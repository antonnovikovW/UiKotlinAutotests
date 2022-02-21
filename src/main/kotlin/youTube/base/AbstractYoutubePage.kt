package youTube.base

import base.AbstractFrame
import base.AbstractMenu
import base.AbstractTestPage

//Абстрактный класс для YouTube c инициализацией меню и фрейма
abstract class AbstractYoutubePage<out M : AbstractMenu, out F : AbstractFrame>(
    override val frame: F,
) : AbstractTestPage<M, F>("", frame = frame) {

    override fun waitForLoaded() {
        frame.waitForLoaded()
    }
}
