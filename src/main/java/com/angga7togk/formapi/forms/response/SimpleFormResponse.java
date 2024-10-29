package com.angga7togk.formapi.forms.response;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowSimple;

public interface SimpleFormResponse extends FormResponse {

  void handle(Player tPlayer, FormWindowSimple tForm, int data);
}
