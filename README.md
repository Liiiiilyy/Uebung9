## Aufgabe 1: 加载游戏关卡

- Die Feldbeschreibung soll nicht mehr direkt aus einem String-Array im Code stammen, sondern aus einer `Datei` geladen werden
    - `1.lvl`
        - *`leere Zellen (' ')`*
        - *`freie Gitterzellen ('O'),`*
        - *`Wasserzellen ('W')`*
        - *`Zellverbindungen ('|', '-')`*
        - *`die Spielfigur('p', 'P', 'q', 'Q' für die Rotationen 0-3)`*
        - *`Spaziergänger:innen ('l', 'L', 'i', 'I' für Laila, 'c', 'C', 'd', 'D'* für Clausius und 's', 'S', 'z', 'Z' für das Kind, jeweils für die* Rotationen 0-3)`*
        - *`Ziel und zwei Brückensymbole ('G', 'b', 'B').`*
    
    ```
    * O-d-O-G b
     *     |   |
     * l-O-O-O W-
     *     |
     * O-O-O-z-O
     *     |
     * p-O-O W-W-
     *       |
    ```
    
- Level 类的Konstruktur应该读取一个名为 filename 的文件。
    - 流的概念
        - 读入一部分就处理一部分
    - `Game.Jar.getInputStream(fileName)`
        - *`Liefern eines Datenstroms zu einem Dateinamen.`*
    - `BufferedReader`: [Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.](https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6d61f0a4-b0a6-45f4-bfbf-8006fff0d7b5/Untitled.png)
    
    - `try-catch` : [see](https://www.w3schools.com/java/java_try_catch.asp)
        
        ```java
        try 
        { 
            code; //将自己的代码放在其中； 
        } catch(e) //如果上面的代码有错误，这里就捕获 
        { 
            alert(e.number); //获得错误信息
        ```
        

其中的内容与以前的字符串数组相同，但包括用于表示角色的其他符号。文件的条目现在仅为文本文件的行。从读取的文件创建一个字符串数组，然后构造一个 `Field` 类的对象，该对象是 `Level` 的一部分。此外，生成所有角色的对象，并将它们存储在一个列表中，以便稍后可以通过 `getActors`() 方法查询它们。重要的是，`Player` 始终位于列表的开头。

任何在读取关卡时出现的错误都会通过抛出 `IllegalArgumentException` 来告知调用者。

1. 错误信息描述错误原因。不需要主程序捕获此异常。以下错误将导致这样的异常：
- 找不到关卡文件。
- 读取文件时出现问题。
- 文件包含无效符号。
- 文件中不止一个 Player。

修改主程序以使用 Level 类。

Aufgabe 2: 隐藏游戏关卡

要求：在 Level 类和 Field 类中实现一个 hide() 方法，将关卡从屏幕上隐藏。为此，您需要记住在创建关卡时创建的所有 GameObject 类的实例，并在它们的 hide() 方法中调用 setVisible(false)。

```java
void hide()
    {
        for (final GameObject gameObject : gameObjects) {
            gameObject.setVisible(false);
        }
        field.hide();
    }
```
