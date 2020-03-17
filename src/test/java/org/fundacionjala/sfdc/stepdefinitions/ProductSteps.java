package org.fundacionjala.sfdc.stepdefinitions;

import java.util.Map;

import cucumber.api.java.en.When;

import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductFormField;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Create Steps for Products.
 */
public class ProductSteps {

    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public ProductSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Fill the Product Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Product form with:$")
    public void iFillTheProductFormWith(Map<ProductFormField, String> formMapData) {
        helper.setItemName(formMapData.get(ProductFormField.PRODUCT_NAME));
        helper.setProductMap(formMapData);
        new ProductForm().fillAndSaveForm(helper.getProductMap());
        new ProductHome().waitUntilSpinnerIsHidden();

    }

    /**
     * Click on Edit inside Product Detail.
     */
    @When("^I click on Edit from Product$")
    public void iClickOnEditFromProduct() {
        new ProductDetail().clickEditButton();
    }

    /**
     * Click on Delete button on Detail Page.
     */
    @When("^I click on Delete from Product$")
    public void iClickOnDeleteFromProduct() {
        new ProductDetail().deleteItem();
    }
}
