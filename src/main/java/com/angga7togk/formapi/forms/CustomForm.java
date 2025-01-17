package com.angga7togk.formapi.forms;

import java.util.List;

import com.angga7togk.formapi.forms.response.CustomFormResponse;

import cn.nukkit.form.element.ElementDropdown;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.element.ElementSlider;
import cn.nukkit.form.element.ElementStepSlider;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.window.FormWindowCustom;

public class CustomForm extends Form {

  public CustomForm() {
    this.form = new FormWindowCustom("");
  }

  public CustomForm(CustomFormResponse response) {
    this.form = new FormWindowCustom("");
    this.response = response;
  }

  public CustomForm setTitle(String title) {
    ((FormWindowCustom) this.form).setTitle(title);
    return this;
  }

  public CustomForm addLabel(String value) {
    ((FormWindowCustom) form).addElement(new ElementLabel(value));
    return this;
  }

  public CustomForm addInput() {
    ElementInput element = new ElementInput("");
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addInput(String name) {
    ElementInput element = new ElementInput(name);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addInput(String name, String placeholder) {
    ElementInput element = new ElementInput(name, placeholder);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addInput(String name, String placeholder, String defaultText) {
    ElementInput element = new ElementInput(name, placeholder, defaultText);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addToggle() {
    ElementToggle element = new ElementToggle("");
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addToggle(String name) {
    ElementToggle element = new ElementToggle(name);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addToggle(String name, boolean defaultValue) {
    ElementToggle element = new ElementToggle(name, defaultValue);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addDropDown(String name, List<String> list) {
    ElementDropdown element = new ElementDropdown(name, list);
    ((FormWindowCustom) form).addElement(element);

    return this;
  }

  public CustomForm addDropDown(String name, List<String> list, int defaultValue) {
    ElementDropdown element = new ElementDropdown(name, list, defaultValue);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addSlider(String name, int min, int max) {
    ElementSlider element = new ElementSlider(name, min, max);
    ((FormWindowCustom) form).addElement(element);

    return this;
  }

  public CustomForm addSlider(String name, int min, int max, int step) {
    ElementSlider element = new ElementSlider(name, min, max, step, 3);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addSlider(String name, int min, int max, int step, int defaultValue) {
    ElementSlider element = new ElementSlider(name, min, max, step, defaultValue);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addStepSlider(String name, List<String> list) {
    ElementStepSlider element = new ElementStepSlider(name, list);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

  public CustomForm addStepSlider(String name, List<String> list, int defaultStep) {
    ElementStepSlider element = new ElementStepSlider(name, list, defaultStep);
    ((FormWindowCustom) form).addElement(element);
    return this;
  }

}
