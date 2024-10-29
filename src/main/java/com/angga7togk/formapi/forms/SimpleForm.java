package com.angga7togk.formapi.forms;

import com.angga7togk.formapi.ImageType;
import com.angga7togk.formapi.forms.response.SimpleFormResponse;

import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowSimple;

public class SimpleForm extends Form {

  public SimpleForm() {
    this.form = new FormWindowSimple("", "");
  }

  public SimpleForm(SimpleFormResponse response) {
    this.form = new FormWindowSimple("", "");
    this.response = response;
  }

  public SimpleForm setTitle(String title) {
    ((FormWindowSimple) this.form).setTitle(title);
    return this;
  }

  public SimpleForm setContent(String content) {
    ((FormWindowSimple) this.form).setContent(content);
    return this;
  }

  public SimpleForm addButton(String text) {
    ((FormWindowSimple) form).addButton(new ElementButton(text));
    return this;
  }

  public SimpleForm addButton(String text, ImageType type, String ico) {
    ElementButton button = new ElementButton(text);
    button.addImage(new ElementButtonImageData(type.toString(), ico));
    ((FormWindowSimple) form).addButton(button);
    return this;
  }
}
