package org.fundacionjala.sfdc.pages.products;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class containing Product Detail Page.
 */
public class ProductDetail extends DetailBase {

    @FindBy(xpath = "//span[text()='Product Name']/parent::div/following-sibling::div/child::span/child::span")
    private WebElement productNameText;

    @FindBy(xpath = "//span[text()='Product Family']/parent::div/following-sibling::div")
    private WebElement productFamilyText;

    @FindBy(xpath = "//span[text()='Product Code']/parent::div/following-sibling::div")
    private WebElement productCodeText;

    @FindBy(xpath = "//span[text()='Product Description']/parent::div/following-sibling::div")
    private WebElement productDescriptionText;

    @FindBy(xpath = "//span[text()='Active']/parent::div/following-sibling::div")
    private WebElement activeCheckbox;

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductForm clickEditButton() {
        CommonActions.clickElement(editButton);
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductHome deleteItem() {
        clickDeleteButton();
        clickConfirmDeleteButton();
        return new ProductHome();
    }

    /**
     * Gets the Product Name Text.
     *
     * @return String.
     */
    public String getProductNameText() {
        return productNameText.getText();
    }

    /**
     * Gets the Product Family Text.
     *
     * @return String.
     */
    public String getProductFamilyText() {
        return productFamilyText.getText();
    }

    /**
     * Gets the Product Code Text.
     *
     * @return String.
     */
    public String getProductCodeText() {
        return productCodeText.getText();
    }

    /**
     * Gets the Product Description Text.
     *
     * @return String.
     */
    public String getProductDescriptionText() {
        return productDescriptionText.getText();
    }
}
