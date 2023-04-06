import org.testng.annotations.Test
import pages.MainHeaderMenu.Items.*
import pages.openMainPage
import pages.tariffs.TariffsFrameMenu.Items.WebinarEnterprise


class ValidationTest : BaseTest() {

    @Test()
    fun `ui`() {
        openMainPage() {
            headerMenu().openBlock(Tariffs) {
                tariffsMenu().openBlock(WebinarEnterprise) {
                    tryFreeTotal(){
                        registerAndEnter()
                        assertEmptyValidation()
                    }
                }
            }
        }
    }
}