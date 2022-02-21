package youTube.base

import base.AbstractFrame
import base.AbstractTestPage

abstract class AbstractYoutubePage<out F : AbstractFrame>(
    override val frame: F,
) : AbstractTestPage<F>("", frame = frame) {

    override fun waitForLoaded() {
        frame.waitForLoaded()
    }
}
