package com.angga7togk.formapi;

import com.angga7togk.formapi.forms.CustomForm;
import com.angga7togk.formapi.forms.ModalForm;
import com.angga7togk.formapi.forms.SimpleForm;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;

public class FormAPI extends PluginBase {

  @Override
  public void onEnable() {
    super.onEnable();
    this.getServer().getPluginManager().registerEvents(new EventListener(), this);
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("form")) {
      if (args.length < 1) {
        sender.sendMessage("Usage: /form <simple | modal | custom>");
        return true;
      }

      if (sender instanceof Player player) {
        switch (args[0].toLowerCase()) {
          case "simple":
            this.simpleForm(player);
            break;
          case "modal":
            this.modalForm(player);
            break;
          case "custom":
            this.customForm(player);
            break;
          default:
            sender.sendMessage("Usage: /form <simple | modal | custom>");
            break;
        }
      }
    }
    return true;
  }

  private void simpleForm(Player player) {
    SimpleForm form = new SimpleForm((tPlayer, tForm, data) -> {
      if (data == -1) {
        tPlayer.sendMessage("You closed the form");
        return;
      }
      tPlayer.sendMessage("You clicked button " + data);
    });
    form.setTitle("Simple Form");
    form.setContent("This is a simple form");
    form.addButton("Button 1");
    form.addButton("Button 2", ImageType.PATH, "textures/ui/check");
    form.send(player);
  }

  private void modalForm(Player player) {
    ModalForm form = new ModalForm((tPlayer, fPlayer, data) -> {
      if (data == null) {
        tPlayer.sendMessage("You closed the form");
        return;
      }
      if (data) {
        tPlayer.sendMessage("You clicked button 1 or yes");
      } else {
        tPlayer.sendMessage("You clicked button 2 or no");
      }
    });
    form.setTitle("Modal Form");
    form.setContent("This is a modal form");
    form.setButton1("Yes");
    form.setButton2("No");
    form.send(player);
  }

  private void customForm(Player player) {
    CustomForm form = new CustomForm((tPlayer, fPlayer, data) -> {
      if (data == null) {
        tPlayer.sendMessage("You closed the form");
        return;
      }
      if(data.get(1) == null){
        tPlayer.sendMessage("You didn't fill the input");
        return;
      }
      tPlayer.sendMessage("Your name is " + data.get(1));
    });
    form.setTitle("Custom Form");
    form.addLabel("This is a custom form");
    form.addInput("Name", "Your Name");
    form.send(player);
  }
}