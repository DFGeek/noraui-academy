/**
 * NoraRobot generated free by NoraUi Oraganization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.yourcompany.norarobot.application.steps.jhipstersampleapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.steps.Step;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Messages;
import com.github.noraui.utils.Utilities;
import com.google.inject.Inject;
import com.yourcompany.norarobot.application.model.jhipstersampleapp.Customer;
import com.yourcompany.norarobot.application.model.jhipstersampleapp.Customers;
import com.yourcompany.norarobot.application.pages.jhipstersampleapp.CreateOrEditCustomerPage;
import com.yourcompany.norarobot.application.pages.jhipstersampleapp.CustomerPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CustomerSteps extends Step {

    private static final Logger logger = LoggerFactory.getLogger(CustomerSteps.class.getName());

    @Inject
    private CustomerPage customerPage;
    
    @Inject
    private CreateOrEditCustomerPage createOrEditCustomerPage;

    /**
     * Check Customer page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Then("The JHIPSTERSAMPLEAPP customer page is displayed")
    public void checkJHipsterSampleAppCustomerPage() throws FailureException {
        if (!customerPage.checkPage()) {
            new Result.Failure<>(customerPage.getApplication(), String.format(Messages.FAIL_MESSAGE_UNABLE_TO_OPEN_PAGE, customerPage.getPageKey()), true, customerPage.getCallBack());
        }
    }

    /**
     * Check Customer page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Then("The JHIPSTERSAMPLEAPP customer form is displayed")
    public void checkJHipsterSampleAppCustomerFormPage() throws FailureException {
        if (!createOrEditCustomerPage.checkPage()) {
            new Result.Failure<>(createOrEditCustomerPage.getApplication(), String.format(Messages.FAIL_MESSAGE_UNABLE_TO_OPEN_PAGE, createOrEditCustomerPage.getPageKey()), true,
                    createOrEditCustomerPage.getCallBack());
        }
    }

    @And("I save '(.*)' from create message")
    public void saveIdFromCreateMessage(String field) throws FailureException {
        try {
            WebElement message = Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(customerPage.createMessage)));
            String id = message.getText().replace("A new customer is created with identifier ", "");
            try {
                Context.getCurrentScenario().write("create " + field + " is:\n" + id);
                Context.getDataOutputProvider().writeDataResult(field, Context.getDataInputProvider().getIndexData(Context.getCurrentScenarioData()).getIndexes().get(0), id);
            } catch (TechnicalException e) {
                logger.error(TechnicalException.TECHNICAL_ERROR_MESSAGE + e.getMessage(), e);
            }
        } catch (Exception e) {
            new Result.Failure<>(e.getMessage(), "when I save id from create message", true, customerPage.getCallBack());
        }
    }

    @Then("I create all customers with '(.*)'")
    public void createAllCustomers(String jsonCustomers) throws FailureException, TechnicalException {
        Customers customers = new Customers();
        customers.deserialize(jsonCustomers);
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            customer.setWid(i);
            try {
                clickOn(customerPage.createNewCustomerButton);
                if (!createOrEditCustomerPage.checkPage()) {
                    new Result.Warning("",
                            Messages.format("Customer %s %s is wrong because create Or Edit Customer Page not display.", customer.getFirstNameCustomer(), customer.getLastNameCustomer()), true,
                            customer.getWid());
                }
                updateText(createOrEditCustomerPage.lastName, customer.getLastNameCustomer());
                updateText(createOrEditCustomerPage.firstName, customer.getFirstNameCustomer());
                clickOn(createOrEditCustomerPage.saveButton);
                if (i == 0) {
                    saveIdFromCreateMessage("id Customer");
                }
                Context.waitUntil(ExpectedConditions.invisibilityOfElementLocated(Utilities.getLocator(customerPage.createMessage)));
            } catch (Exception e) {
                new Result.Warning(e.getMessage(), Messages.format("Customer %s %s is wrong because %s.", customer.getFirstNameCustomer(), customer.getLastNameCustomer(), e.getMessage()), true,
                        customer.getWid());
            }
        }

    }
}
