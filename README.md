# FormAPI PNX

FormAPI plugin for PowerNukkitX

## Maven

```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```
```xml
<dependency>
    <groupId>com.github.angga7togk</groupId>
    <artifactId>FormAPI-PNX</artifactId>
    <version>1.0.0</version>
</dependency>
```

## SimpleForm

```java
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
```

## ModalForm

```java
private void modalForm(Player player) {
  ModalForm form = new ModalForm((tPlayer, tForm, data) -> {
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
```

## CustomForm

```java
private void customForm(Player player) {
  CustomForm form = new CustomForm((tPlayer, tForm, data) -> {
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
```
