package Dropdown;

import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends BaseTests {

    @Test
    public void selectOption() {
        var dropDownPage = hompage.clickDropdown();
        //Storing the webelement ID in string variable
        String option = "Option 1";
        dropDownPage.SelectFromDropdown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        //Assertions
        Assert.assertEquals(selectedOptions.size(), 1, "Incorrect number of options in dropdown");
        Assert.assertTrue(selectedOptions.contains(option), "Option not selected.");
    }

}
