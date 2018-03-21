/**
 * NoraRobot generated free by NoraUi Oraganization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.yourcompany.norarobot.application.model.jhipstersampleapp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.github.noraui.model.Model;
import com.github.noraui.model.ModelList;

public class Customers extends ArrayList<Customer> implements ModelList {

    /**
     *
     */
    private static final long serialVersionUID = 9002528163560746878L;

    public Customers() {
        super();
    }

    public Customers(Customers inputList) {
        super(inputList);
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
        Type listType = new TypeToken<ArrayList<Customer>>() {
        }.getType();

        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        List<Customer> list = gson.fromJson(jsonString, listType);
        this.addAll(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelList addModel(Model m) {
        super.add((Customer) m);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void subtract(ModelList list) {
        Iterator<?> iterator = ((Customers) list).iterator();
        while (iterator.hasNext()) {
            this.remove(iterator.next());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getIds() {
        List<Integer> result = new ArrayList<>();
        for (Customer article : this) {
            result.add(article.getWid());
        }
        return result;
    }

}
