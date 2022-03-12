package wheely

import models.User
import org.testng.annotations.DataProvider

private const val COMPANY_NAME_LENGTH = 5
private const val NAME_LENGTH = 11
private const val PHONE_LENGTH = 9

class UserDataProvider {

    companion object {

        @JvmStatic
        @DataProvider
        fun getUsers(): Array<Array<Any>> = arrayOf(
            arrayOf(getTemporaryUser())
        )

        //Генерация User

        private fun getTemporaryUser() = User(
            getRandomString(COMPANY_NAME_LENGTH),
            getRandomString(NAME_LENGTH),
            createEmail("temporary"),
            createPhone(PHONE_LENGTH)
        )

        private fun createPhone(
            length: Int,
            symbols: CharRange = ('0'..'9')
        ): String = (1..length).map { symbols.random() }.joinToString("")

        private fun createEmail(alias: String = ""): String = "wheely_autotest+$alias@gmail.com"

        private fun getRandomString(
            length: Int,
            symbols: List<Char> = ('a'..'z') + ('A'..'Z')
        ): String = (1..length).map { symbols.random() }.joinToString("")
    }
}