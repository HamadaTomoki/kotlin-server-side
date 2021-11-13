package com.jetbrains.handson.chat.server

import io.ktor.application.*
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.websocket.*
import java.util.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    /** WebSockets Ktorプラグインをインストールして、Ktorフレームワークによって提供されるWebSocket関連の機能を有効化 */
    install(WebSockets)

    /** WebSocketプロトコルに応答するエンドポイントをルーティングで定義 */
    routing {
        webSocket("/chat") {
            send("You are connected!")
            for (frame in incoming) {
                // 着信チャネルを反復処理するときに受信する非テキストフレームはスキップ
                frame as? Frame.Text ?: continue
                // 受信したテキストを読み取り、「Yousaid：」というプレフィックスを付けてユーザーに送り返します。
                val receivedText = frame.readText()
                send("You said: $receivedText")
            }
        }
    }

}
