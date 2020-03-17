package org.fundacionjala.sfdc.pages.products;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.IStrategySteps;
import org.fundacionjala.sfdc.pages.base.FormBase;

/**
 * Class containing Product Form Page.
 */
public class ProductForm extends FormBase {

    @FindBy(xpath = "//span[contains(text(), 'Product Name')]/parent::label/following-sibling::input")
    private WebElement productNameInputText;

    @FindBy(xpath = "//span[contains(text(), 'Product Code')]/parent::label/following-sibling::input")
    private WebElement productCodeInputText;

    @FindBy(xpath = "//span[contains(text(), 'Product Description')]/parent::label/following-sibling::textarea")
    private WebElement productDescriptionTextArea;

    @FindBy(xpath = "//span[contains(text(), 'Active')]/parent::label/following-sibling::input")
    private WebElement activeCheckBox;

    @FindBy(xpath = "//span[contains(text(),'Family')]/parent::span/following-sibling::div/descendant::a")
    private WebElement productFamilySelect;

    /**
     * {@inheritDoc}
     */
    public ProductDetail newItem(String name) {
        setProductNameInputText(name);
        clickSaveButton();
        return new ProductDetail();
    }

    /**
     * {@inheritDoc}
     */
    public ProductDetail fillAndSaveForm(Map<ProductFormField, String> formMapData) {
        formMapData.forEach((key, value) -> getStrategyMap(formMapData).get(key).performStep());
        clickSaveButton();
        return new ProductDetail();
    }

    /**
     * Set the Product Name.
     *
     * @param productName String.
     */
    private void setProductNameInputText(String productName) {
        CommonActions.setInputField(productNameInputText, productName);
    }

    /**
     * Set the Product Code.
     *
     * @param productCode String.
     */
    private void setProductCodeInputText(String productCode) {
        CommonActions.setInputField(productCodeInputText, productCode);
    }

    /**
     * Set the Product Description.
     *
     * @param productDescription String.
     */
    private void setProductDescriptionTextArea(String productDescription) {
        CommonActions.setInputField(productDescriptionTextArea, productDescription);
    }

    /**
     * Select the Product Family.
     *
     * @param productFamily String.
     */
    private void setProductFamilySelect(String productFamily) {
        CommonActions.clickElement(productFamilySelect);
        String cssSelector = String.format("a[title='%s']", productFamily);
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    /**
     * Set the ActiveCheckBox status.
     *
     * @param flag boolean.
     */
    private void setActiveCheckBox(boolean flag) {
        if (flag) {
            CommonActions.clickElement(activeCheckBox);
        }
    }

    /**
     * Gets the current Map from Steps Definition.
     *
     * @param formMap Map<ProductFormField, String>.
     * @return Map ProductFormField, IStrategySteps.
     */
    private Map<ProductFormField, IStrategySteps> getStrategyMap(Map<ProductFormField, String> formMap) {
        EnumMap<ProductFormField, IStrategySteps> strategyMap = new EnumMap<>(ProductFormField.class);
        strategyMap.put(ProductFormField.PRODUCT_NAME,
                () -> setProductNameInputText(formMap.get(ProductFormField.PRODUCT_NAME)));
        strategyMap.put(ProductFormField.PRODUCT_CODE,
                () -> setProductCodeInputText(formMap.get(ProductFormField.PRODUCT_CODE)));
        strategyMap.put(ProductFormField.PRODUCT_DESCRIPTION,
                () -> setProductDescriptionTextArea(formMap.get(ProductFormField.PRODUCT_DESCRIPTION)));
        strategyMap.put(ProductFormField.PRODUCT_FAMILY,
                () -> setProductFamilySelect(formMap.get(ProductFormField.PRODUCT_FAMILY)));
        strategyMap.put(ProductFormField.ACTIVE,
                () -> setActiveCheckBox(Boolean.parseBoolean(formMap.get(ProductFormField.ACTIVE))));

        return strategyMap;
    }
}
