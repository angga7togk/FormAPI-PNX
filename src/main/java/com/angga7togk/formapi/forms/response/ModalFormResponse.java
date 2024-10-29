package com.angga7togk.formapi.forms.response;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowModal;

public interface ModalFormResponse extends FormResponse {

  void handle(Player tPlayer, FormWindowModal tForm, Boolean data);

}
