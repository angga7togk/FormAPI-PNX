package com.angga7togk.formapi;

import cn.nukkit.plugin.PluginBase;

public class FormAPI extends PluginBase {

  @Override
  public void onEnable() {
    super.onEnable();
    this.getServer().getPluginManager().registerEvents(new EventListener(), this);
  }
}