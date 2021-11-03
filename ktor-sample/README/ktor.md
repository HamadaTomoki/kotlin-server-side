# サーバーの作成と構成

## 【サーバーの作成】

### [EmbeddedServer]

`embeddedServer`
は、サーバーパラメーターをコードで構成し、アプリケーションをすばやく実行するための簡単な方法です。以下のコードスニペットでは、サーバーを起動するためのパラメーターとしてエンジンとポートを受け入れます。以下の例では、Nettyエンジンを使用してサーバーを実行し、8080ポートでlistenします。

Application.kt

```kotlin
package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}
```

### [EngineMain]

`EngineMain`は、<line>選択したエンジンでサーバーを起動し、外部のapplication.confファイルで指定されたアプリケーションモジュールをロード</line>
します。ロードするモジュールに加えて、このファイルにはさまざまなサーバーパラメータ（以下の例では8080ポート）を含めることができます。

Application.kt

```kotlin
package com.example

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondText("Hello, world!")
        }
    }
}
```

application.conf

```
ktor {
    deployment {
        port = 8080
    }
    application {
        modules = [ com.example.ApplicationKt.module ]
    }
}
```

### [Configuration]

https://ktor.io/docs/configurations.html

### [Logback]

https://ktor.io/docs/logging.html

### [Serialization]

https://ktor.io/docs/serialization.html

