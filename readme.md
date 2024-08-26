# CustomDisc

自定义唱片插件

## 使用方法

适用于基于bukkit的所有插件服务端

在加入插件后，你可以在`Plugins\CustomDisc`文件夹下找到`discs`文件夹

你可以向其添加 `discs.yaml` 文件

```yaml
discs:
  mysticlightquest:
    name: §e§lMysticlight Quest
    lore:
    - §6§l★★★★★★
    - §f§l佩佩掺冰冰
    record: test:music.mysticlight
    material: cat
```

根据上方格式配置, `material`可以省略，默认为cat.`record`则为音乐命名空间

另外，插件默认配置文件是`discs.yaml`, 尽管你可以在`discs`文件夹中添加任意yaml文件，但是插件在保存文件时只会保存到`discs.yaml`文件
