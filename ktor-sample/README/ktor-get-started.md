# Ktor

![w-8](./images/ktor_logo.svg)

`Ktor`は、<l>接続されたアプリケーション（Webアプリケーション、HTTPサービス、モバイル、ブラウザーアプリケーション）を簡単に構築するためのフレームワーク</l>
です。最新の接続アプリケーションは、ユーザーに最高のエクスペリエンスを提供するために非同期である必要があり、Kotlinコルーチンは、それを簡単かつ簡単な方法で実行するための優れた機能を提供します。

まだ完全にはありませんが、Ktorの目標は、接続されたアプリケーションにエンドツーエンドのマルチプラットフォームアプリケーションフレームワークを提供することです。現在、JVMクライアントとサーバーのシナリオ、およびJavaScript、iOS、Androidクライアントがサポートされており、サーバー機能をネイティブ環境に、クライアント機能を他のネイティブターゲットに導入するよう取り組んでいます。

## 【Ktorアプリケーションを実行する】

Application.kt

```kotlin
fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}
```

- <sl>embeddedServer関数は、コードでサーバーパラメーターを構成し、アプリケーションを実行</sl>するために使用されます
- <sl>configureRouting関数は、ルーティングを定義する拡張関数</sl>です。この関数は、別のプラグインパッケージ（Routing.ktファイル）で宣言されています。

Routing.kt

```kotlin
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
```

