package com.angga7togk.formapi.forms;

import com.angga7togk.formapi.forms.response.ModalFormResponse;

import cn.nukkit.form.window.FormWindowModal;

public class ModalForm extends Form {

  public ModalForm() {
    this.form = new FormWindowModal("", "", "", "");
  }

  public ModalForm(ModalFormResponse response) {
    this.form = new FormWindowModal("", "", "", "");
    this.response = response;
  }

  public ModalForm setTitle(String title) {
    ((FormWindowModal) this.form).setTitle(title);
    return this;
  }

  public ModalForm setContent(String content) {
    ((FormWindowModal) this.form).setContent(content);
    return this;
  }

  public ModalForm setButton1(String text) {
    ((FormWindowModal) this.form).setButton1(text);
    return this;
  }

  public ModalForm setButton2(String text) {
    ((FormWindowModal) this.form).setButton2(text);
    return this;
  }

}
