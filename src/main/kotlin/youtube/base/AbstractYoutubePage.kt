package youtube.base

import base.AbstractFrame
import base.AbstractTempPage

abstract class AbstractYoutubePage<out F : AbstractFrame>(
    override val frame: F,
) : AbstractTempPage<YoutubeHeader, F>("", frame = frame) {

    override fun initHeader(): YoutubeHeader = YoutubeHeader()

}
