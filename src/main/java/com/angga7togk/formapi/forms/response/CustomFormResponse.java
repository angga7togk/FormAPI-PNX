package com.angga7togk.formapi.forms.response;

import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowCustom;

public interface CustomFormResponse extends FormResponse {

  void handle(Player tPlayer, FormWindowCustom tForm, List<Object> data);
}
