/**
 * NoraRobot generated free by NoraUi Oraganization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.yourcompany.norarobot.application.model.jhipstersampleapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import com.github.noraui.annotation.Column;
import com.github.noraui.model.Model;

public class Customer implements Model, Comparable<Customer> {

    @Expose(serialize = false, deserialize = false)
    private Integer wid;

    @Expose
    @Column(name = "Last Name Customer")
    private String lastNameCustomer;

    @Expose
    @Column(name = "First Name Customer")
    private String firstNameCustomer;

    @Column(name = "id Customer")
    private String id;

    // constructor by default for serialize/deserialize
    public Customer() {
    }

    public Customer(String wid, String lastNameCustomer, String firstNameCustomer, String id) {
        this.wid = Integer.parseInt(wid);
        this.lastNameCustomer = lastNameCustomer;
        this.firstNameCustomer = firstNameCustomer;
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String serialize() {
        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        builder.disableHtmlEscaping();
        final Gson gson = builder.create();
        return gson.toJson(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deserialize(String jsonString) {
        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        Customer w = gson.fromJson(jsonString, Customer.class);
        this.wid = w.wid;
        this.lastNameCustomer = w.lastNameCustomer;
        this.firstNameCustomer = w.firstNameCustomer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Customers> getModelList() {
        return Customers.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (lastNameCustomer == null ? 0 : lastNameCustomer.hashCode());
        result = prime * result + (firstNameCustomer == null ? 0 : firstNameCustomer.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        if (firstNameCustomer == null) {
            if (other.firstNameCustomer != null) {
                return false;
            }
        } else if (!firstNameCustomer.equals(other.firstNameCustomer)) {
            return false;
        }
        if (lastNameCustomer == null) {
            if (other.lastNameCustomer != null) {
                return false;
            }
        } else if (!lastNameCustomer.equals(other.lastNameCustomer)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Customer other) {
        int i = this.lastNameCustomer.compareTo(other.lastNameCustomer);
        if (i != 0) {
            return i;
        }
        i = this.firstNameCustomer.compareTo(other.firstNameCustomer);
        if (i != 0) {
            return i;
        }
        return 0;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getFirstNameCustomer() {
        return firstNameCustomer;
    }

    public void setFirstNameCustomer(String firstNameCustomer) {
        this.firstNameCustomer = firstNameCustomer;
    }

    public String getLastNameCustomer() {
        return lastNameCustomer;
    }

    public void setLastNameCustomer(String lastNameCustomer) {
        this.lastNameCustomer = lastNameCustomer;
    }

}
