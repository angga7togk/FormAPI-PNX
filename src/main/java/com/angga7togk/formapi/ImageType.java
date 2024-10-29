package com.angga7togk.formapi;

public enum ImageType {
  PATH("path"),
  URL("url");

  private String val;

  ImageType(String val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return this.val;
  }
}
