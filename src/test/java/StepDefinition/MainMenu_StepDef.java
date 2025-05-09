package StepDefinition;

import Pages.MainMenuPage;
import io.cucumber.java.en.And;

public class MainMenu_StepDef {
    MainMenuPage mainMenu = new MainMenuPage();

    @And("user navigate to admin tab")
    public void userNavigateToAdminTab() {
        mainMenu.navigateToAdminTab();
    }


}
