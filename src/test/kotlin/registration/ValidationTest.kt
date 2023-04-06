import org.testng.annotations.Test
import pages.MainHeaderMenu.Items.Tariffs
import pages.openMainPage
import pages.tariffs.TariffsFrameMenu.Items.WebinarEnterprise


class ValidationTest : BaseTest() {

    @Test()
    fun `Registration test| Validation check| Empty values`() {
        openMainPage {
            headerMenu().openBlock(Tariffs) {
                tariffsMenu().openBlock(WebinarEnterprise) {
                    tryFreeTotal {
                        registerAndEnter()
                        assertEmptyValidation()
                    }
                }
            }
        }
    }
}