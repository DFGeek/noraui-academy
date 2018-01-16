package com.yourcompany.norarobot.application.model.jhipstersampleapp;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

import com.github.noraui.model.ModelList;

public class CustomerUT {

    @Test
    public void checkLogoSerializeTest() {
        // prepare mock
        Customer customer = new Customer();
        customer.setLastNameCustomer("Zidane");
        customer.setFirstNameCustomer("Zinédine");

        // run test
        Assert.assertEquals("{\"lastNameCustomer\":\"Zidane\",\"firstNameCustomer\":\"Zinédine\"}", customer.serialize());
    }

    @Test
    public void checkLogoDeserializeTest() {
        // run test
        Customer customer = new Customer();
        customer.deserialize("{\"lastNameCustomer\":\"Zidane\",\"firstNameCustomer\":\"Zinédine\"}");
        Assert.assertEquals("Zidane", customer.getLastNameCustomer());
        Assert.assertEquals("Zinédine", customer.getFirstNameCustomer());
    }

    @Test
    public void checkLogoSerializeListTest() {
        // prepare mock
        Customer zidane = new Customer();
        zidane.setLastNameCustomer("Zidane");
        zidane.setFirstNameCustomer("Zinédine");

        Customer barthez = new Customer();
        barthez.setLastNameCustomer("Barthez");
        barthez.setFirstNameCustomer("Fabien");

        Customers customers = new Customers();
        customers.add(zidane);
        customers.add(barthez);

        // run test
        Assert.assertEquals("[{\"lastNameCustomer\":\"Zidane\",\"firstNameCustomer\":\"Zinédine\"},{\"lastNameCustomer\":\"Barthez\",\"firstNameCustomer\":\"Fabien\"}]", customers.serialize());
    }

    @Test
    public void checkLogoDeserializeListTest() {
        // run test
        Customers customers = new Customers();
        customers.deserialize("[{\"lastNameCustomer\":\"Zidane\",\"firstNameCustomer\":\"Zinédine\"},{\"lastNameCustomer\":\"Barthez\",\"firstNameCustomer\":\"Fabien\"}]");
        Assert.assertEquals("Zidane", customers.get(0).getLastNameCustomer());
        Assert.assertEquals("Zinédine", customers.get(0).getFirstNameCustomer());
        Assert.assertEquals("Barthez", customers.get(1).getLastNameCustomer());
        Assert.assertEquals("Fabien", customers.get(1).getFirstNameCustomer());
    }

    @Test
    public void checkGetModelListTest() throws InstantiationException, IllegalAccessException {
        // prepare mock
        Customer zidane = new Customer();
        zidane.setLastNameCustomer("Zidane");
        zidane.setFirstNameCustomer("Zinédine");

        Customer barthez = new Customer();
        barthez.setLastNameCustomer("Barthez");
        barthez.setFirstNameCustomer("Fabien");

        Class<? extends ModelList> c = zidane.getModelList();
        ModelList cl = c.newInstance();
        cl.addModel(zidane);
        cl.addModel(barthez);

        // run test
        Assert.assertEquals("[{\"lastNameCustomer\":\"Zidane\",\"firstNameCustomer\":\"Zinédine\"},{\"lastNameCustomer\":\"Barthez\",\"firstNameCustomer\":\"Fabien\"}]", cl.serialize());
    }

    @Test
    public void checkDeleteCustomersAndAddCustomersTest() {
        // prepare mock
        Customer a = new Customer();
        a.setLastNameCustomer("Barthez");
        a.setFirstNameCustomer("Fabien");
        Customer b = new Customer();
        b.setLastNameCustomer("Giroud");
        b.setFirstNameCustomer("Olivier");
        Customer c = new Customer();
        c.setLastNameCustomer("Debuchy");
        c.setFirstNameCustomer("Mathieu");
        Customer d = new Customer();
        d.setLastNameCustomer("Zidane");
        d.setFirstNameCustomer("Zinédine");

        Customers customersInApp = new Customers();
        customersInApp.add(a);
        customersInApp.add(b);
        customersInApp.add(c);

        Customers customers = new Customers();
        customers.add(b);
        customers.add(c);
        customers.add(d);

        // run test
        Customers cInGame = (Customers) customersInApp.clone();
        cInGame.subtract(customers);
        Assert.assertEquals(1, cInGame.size());
        Assert.assertEquals("Barthez", cInGame.get(0).getLastNameCustomer());
        Assert.assertEquals("Fabien", cInGame.get(0).getFirstNameCustomer());

        Customers cus = (Customers) customers.clone();
        cus.subtract(customersInApp);
        Assert.assertEquals(1, cus.size());
        Assert.assertEquals("Zidane", cus.get(0).getLastNameCustomer());
        Assert.assertEquals("Zinédine", cus.get(0).getFirstNameCustomer());

        Assert.assertEquals("Barthez", customersInApp.get(0).getLastNameCustomer());
        Assert.assertEquals("Giroud", customersInApp.get(1).getLastNameCustomer());
        Assert.assertEquals("Debuchy", customersInApp.get(2).getLastNameCustomer());
        Collections.sort(customersInApp);
        Assert.assertEquals("Barthez", customersInApp.get(0).getLastNameCustomer());
        Assert.assertEquals("Debuchy", customersInApp.get(1).getLastNameCustomer());
        Assert.assertEquals("Giroud", customersInApp.get(2).getLastNameCustomer());
    }
}
