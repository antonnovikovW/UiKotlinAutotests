package data

import org.testng.annotations.DataProvider

class VideoDataProvider {

    companion object {

        @JvmStatic
        @DataProvider
        fun getFoundedVideo()= arrayOf(
            arrayOf("Лекция 1. Java. Введение")
        )
    }
}