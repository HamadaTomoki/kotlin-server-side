plugins {
    kotlin("jvm") version "1.5.20"
}

group = "com.jetbrains.handson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val ktor_version: String by project
val logback_version: String by project

dependencies {
    // ktor-server-nettyはKtorをNettyエンジンと一緒に追加し、外部のアプリケーションコンテナに依存することなくサーバー機能を使用できるようにします。
    implementation("io.ktor:ktor-server-netty:$ktor_version")

    // ktor-websocketsを使用すると、チャットの主要な通信メカニズムであるWebSocketKtorプラグインを使用できます。
    implementation("io.ktor:ktor-websockets:$ktor_version")

    // logback-classicはSLF4Jの実装を提供し、コンソールで適切にフォーマットされたログを表示できるようにします。
    implementation("ch.qos.logback:logback-classic:$logback_version")
}
