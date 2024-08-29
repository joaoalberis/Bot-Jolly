# Bot-Jolly

The bot jolly was primarily built in Java, using the most popular Java library, which is JDA.

<p align="center">
  <b>Default Configuration<b><br/>
  This is the default configuration, which is not recommended to be changed. If it is altered, changes must also be made to some files' code.
  
  ```java
      public static void main(String[] args) {
          bot = JDABuilder.create(Env.TOKEN, EnumSet.allOf(GatewayIntent.class))
          .setActivity(Activity.playing("Sendo Desenvolvido")).build();

          bot.addEventListener(new Ban());

          System.out.println("🛰️ - Bot Jolly, em funcionamento.");
      }
```
</p>


## How to Use: <img src="https://i.imgur.com/V0scVRj.png" alt="arrow-indication" width="20" height="20">

Here, I assume you already have Java JDK 8 and Maven installed on your machine with the corresponding version to carry out the installation.


## Configuration <img src="https://i.imgur.com/YKkG89a.png" width="22px" height="22px"/>

Here are some configuration file guides that may be useful depending on your needs.

1. `Url/Key` of the requires in `Env.java`:

   ```env
       TOKEN="RESPECTIVE BOT TOKEN"
   ```

# Contacts:
João Alberis(MrJoao): 
- [Discord](https://discord.com/users/407584575993151488)
- [Github](https://github.com/joaoalberis)
- [Project](https://github.com/joaoalberis/Bot-Jolly)
