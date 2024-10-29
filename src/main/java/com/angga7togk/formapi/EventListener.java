package com.angga7togk.formapi;

import java.util.ArrayList;
import java.util.List;

import com.angga7togk.formapi.forms.Form;
import com.angga7togk.formapi.forms.response.CustomFormResponse;
import com.angga7togk.formapi.forms.response.ModalFormResponse;
import com.angga7togk.formapi.forms.response.SimpleFormResponse;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.response.FormResponseModal;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowModal;
import cn.nukkit.form.window.FormWindowSimple;

public class EventListener implements Listener {

  @SuppressWarnings("unchecked")
  @EventHandler(priority = EventPriority.HIGH)
  public void onFormResponse(PlayerFormRespondedEvent event) {
    Player player = event.getPlayer();
    FormWindow window = event.getWindow();
    FormResponse windowResponse = window.getResponse();

    if (Form.playerForms.containsKey(player.getName())) {
      com.angga7togk.formapi.forms.response.FormResponse response = Form.playerForms.get(player.getName());
      Form.playerForms.remove(player.getName());

      Object data;

      if (windowResponse == null || event.wasClosed()) {
        if (response instanceof CustomFormResponse) {
          ((CustomFormResponse) response).handle(player, (FormWindowCustom) window, null);

        } else if (response instanceof ModalFormResponse) {
          ((ModalFormResponse) response).handle(player, (FormWindowModal) window, null);

        } else if (response instanceof SimpleFormResponse) {
          ((SimpleFormResponse) response).handle(player, (FormWindowSimple) window, -1);
        }
        return;
      }

      if (window instanceof FormWindowSimple) {
        data = ((FormResponseSimple) windowResponse).getClickedButtonId();
        ((SimpleFormResponse) response).handle(player, (FormWindowSimple) window, (int) data);
        return;
      }

      if (window instanceof FormWindowCustom) {
        data = new ArrayList<>(((FormResponseCustom) windowResponse).getResponses().values());
        ((CustomFormResponse) response).handle(player, (FormWindowCustom) window, (List<Object>) data);
        return;
      }

      if (window instanceof FormWindowModal) {
        data = ((FormResponseModal) windowResponse).getClickedButtonId();
        boolean dataBool = true;
        if ((int) data == 1) {
          dataBool = false;
        }
        ((ModalFormResponse) response).handle(player, (FormWindowModal) window, dataBool);
      }
    }
  }

  @EventHandler(priority = EventPriority.HIGH)
  public void playerQuit(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    Form.playerForms.remove(player.getName());
  }
}
