package wheely

import models.User
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import pages.MainHeaderMenu.Items.ForBusiness
import pages.businessFrame
import pages.openMainPage

class ForBusinessTests {

    @BeforeClass
    fun beforeClass() {
        openMainPage() {
            headerMenu()
                .openBlock(ForBusiness)
        }
    }

    @Test(
        dataProvider = "getUsers",
        dataProviderClass = UserDataProvider::class
    )
    fun `Should create new account`(user: User) {
        businessFrame {
            createApplication(user)
        }
    }
}