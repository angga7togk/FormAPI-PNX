package com.angga7togk.formapi.forms;

import java.util.HashMap;

import com.angga7togk.formapi.forms.response.FormResponse;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindow;

public class Form {
  public static HashMap<String, FormResponse> playerForms = new HashMap<>();
  protected FormWindow form;
  protected FormResponse response;

  public void send(Player player) {
    if (this.response != null) {
      playerForms.put(player.getName(), this.response);
    }
    player.showFormWindow(form);
  }
}
