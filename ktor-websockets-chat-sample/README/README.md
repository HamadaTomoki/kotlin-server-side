# Creating a WebSocket chat

このハンズオンでは、WebSocketを使用する簡単なチャットアプリケーションを作成する方法を学習します。 Webアプリケーションを作成するための非同期KotlinフレームワークであるKtorを使用して、クライアントアプリケーションとサーバーアプリケーションの両方を開発します。j

## 【What we will build】

このチュートリアル全体を通して、2つのアプリケーションで構成される簡単なチャットサービスを実装します。

- チャットサーバーアプリケーションは、チャットユーザーからの接続を受け入れて管理し、メッセージを受信して、接続されているすべてのクライアントに配信します。


- チャットクライアントアプリケーションを使用すると、ユーザーは共通のチャットサーバーに参加したり、他のユーザーにメッセージを送信したり、ターミナルで他のユーザーからのメッセージを表示したりできます。

アプリケーションの両方の部分で、KtorのWebSocketのサポートを利用します。 Ktorはサーバー側とクライアント側の両方のフレームワークであるため、クライアントの構築に関しては、チャットサーバーの構築で得た知識を再利用できます。 このハンズオンを完了すると、KtorとKotlinを使用してWebSocketを操作する方法、クライアントとサーバー間で情報を交換する方法、および複数の接続を同時に管理する方法の基本的な知識を得ることができます。

## 【Why WebSocket？】

`WebSocket`は、チャットや単純なゲームなどのアプリケーションに最適です。<sl>チャットセッションは通常長期間有効であり、クライアントは他の参加者から長期間にわたってメッセージを受信</sl>します。チャットセッションも双方向です。クライアントはチャットメッセージを送信し、他の人からのチャットメッセージを見たいと考えています。

<sl>通常のHTTPリクエストとは異なり、**WebSocket接続は長期間開いたまま**にすることができ、フレームの形式でクライアントとサーバー間でデータを交換するための簡単なインターフェイスを備えています</sl>。フレームは、さまざまなタイプ(text, binary, close, ping/pong)のWebSocketメッセージと考えることができます。 KtorはWebSocketプロトコルを介して高レベルの抽象化を提供するため、テキストフレームとバイナリフレームに集中して、他のフレームの処理をフレームワークに任せることもできます。 WebSocketも広くサポートされているテクノロジーです。最新のブラウザーはすべて、そのままWebSocketを操作でき、WebSocketを操作するためのフレームワークは、多くのプログラミング言語と多くのプラットフォームに存在します。 プロジェクトの実装に使用したいテクノロジーに自信が持てたので、セットアップから始めましょう。

## 【Project setup】

アプリケーションは2つの独立した部分（チャットサーバーとチャットクライアント）になるため、アプリケーションを2つの別個のGradleプロジェクトとして構成します。これら2つのプロジェクトは完全に独立しているため、オンラインのKtor Project Generator、またはIntelliJIDEAのプラグインを使用して手動で作成できます。

テンプレートリポジトリには、プロジェクトを構築するための2つの最低限のGradleプロジェクトが含まれています。クライアントプロジェクトとサーバープロジェクトです。どちらも、ハンズオン全体で必要となる依存関係が事前に構成されているため、Gradle構成に変更を加える必要はありません。 アプリケーションに使用されているアーティファクトを理解することは依然として有益である可能性があるため、2つのプロジェクトとそれらが依存する依存関係を詳しく見ていきましょう。

### [Understanding the project configuration]

2つのプロジェクトには、それぞれ個別の構成ファイルのセットが付属しています。それぞれをもう少し詳しく調べてみましょう。

**Dependencies for the server project**  
サーバーアプリケーションは、server/build.gradle.ktsファイルに3つの依存関係を指定します

- ktor-server-netty  
  `ktor-server-netty`は<l>KtorをNettyエンジンと一緒に追加し、外部のアプリケーションコンテナに依存することなくサーバー機能を使用</l>できるようにします。


- ktor-websockets  
  `ktor-websockets`を使用すると、<l>チャットの主要な通信メカニズムであるWebSocketKtorプラグインを使用</l>できます。


- logback-classic  
  `logback-classic`は<l>SLF4Jの実装を提供し、コンソールで適切にフォーマットされたログを表示</l>できるようにします。

```kotlin
dependencies {
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-websockets:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
}
```

### [Configuration for the server project]

Ktorは、HOCON構成ファイルを使用して、エントリポイントや展開ポートなどの基本的な動作を設定します。 server/src/main/resources/application.confにあります。

```
ktor {
    deployment {
        port = 8080
    }
    application {
        modules = [ com.jetbrains.handson.chat.ApplicationKt.module ]
    }
}
```

このファイルのディレクトリには、logback-classic実装を設定する必要最低限のlogback.xmlファイルもあります。

**Dependencies for the client project**  
クライアントアプリケーションは、client /build.gradle.ktsファイルで次の2つの依存関係を指定します。

```kotlin
dependencies {
    implementation("io.ktor:ktor-client-websockets:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
}
```

- ktor-client-cio  
  `ktor-client-cio`は、<l>コルーチン上にKtorのクライアント実装を提供します（「Coroutine-basedI/O」）</l>。


- ktor-client-websockets  
  `ktor-client-websockets`は、サーバーへのktor-websockets依存関係に対応するものであり、サーバーと同じAPIを使用してクライアントからWebSocketを使用できるようにします。 プロジェクトを実行するための部分についてある程度理解できたので、次はプロジェクトの構築を開始します。簡単なWebSocketエコーサーバーを実装することから始めましょう！

## 【A first echo server】

### [implementing an echo server]

WebSocket接続を受け入れ、テキストコンテンツを受信し、それをクライアントに送り返す「echo」サービスを構築することから、サーバー開発の旅を始めましょう。 Application.module（）の次の実装をに追加することで、KotlinとKtorでこのサービスを実装できます。

Application.module() to server/src/main/kotlin/com/jetbrains/handson/chat/server/Application.kt:

```kotlin
fun Application.module() {
    install(WebSockets)
    routing {
        webSocket("/chat") {
            send("You are connected!")
            for(frame in incoming) {
                frame as? Frame.Text ?: continue
                val receivedText = frame.readText()
                send("You said: $receivedText")
            }
        }
    }
}
```

まず、<sl>WebSockets Ktorプラグインをインストールして、Ktorフレームワークによって提供されるWebSocket関連の機能を有効</sl>にします。これにより、WebSocketプロトコルに応答するエンドポイントをルーティングで定義できます（この場合、ルートは/ chatです）。 webSocketルート関数のスコープ内で、クライアントと対話するためのさまざまなメソッドを使用できます（DefaultWebSocketServerSessionレシーバータイプを介して）。

これには、メッセージを送信し、受信したメッセージを反復処理するための便利な方法が含まれます。 テキストコンテンツのみに関心があるため、着信チャネルを反復処理するときに受信する非テキストフレームはスキップします。次に、受信したテキストを読み取り、「Yousaid：」というプレフィックスを付けてユーザーに送り返します。

この時点で、完全に機能するエコーサーバーをすでに構築しています。これは、送信したものをすべて送信するだけの小さなサービスです。やってみよう！
