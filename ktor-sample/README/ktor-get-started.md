# Ktor

![w-8](./images/ktor_logo.svg)

`Ktor`は、<line>接続されたアプリケーション（Webアプリケーション、HTTPサービス、モバイル、ブラウザーアプリケーション）を簡単に構築するためのフレームワーク</line>
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

- <subline>embeddedServer関数は、コードでサーバーパラメーターを構成し、アプリケーションを実行</subline>するために使用されます
- <subline>configureRouting関数は、ルーティングを定義する拡張関数</subline>です。この関数は、別のプラグインパッケージ（Routing.ktファイル）で宣言されています。

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

## 【HTTP APIの作成】

### [依存関係]

```kotlin
dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
```

- `ktor-server-core`  
  Ktorのコアコンポーネントをプロジェクトに追加します。


- `ktor-server-netty`  
  Nettyエンジンをプロジェクトに追加し、外部アプリケーションコンテナに依存せずにサーバー機能を使用できるようにします。


- `logback-classic`  
  SLF4Jの実装を提供し、コンソールで適切にフォーマットされたログを表示できるようにします。


- `ktor-serialization`  
  KotlinオブジェクトをJSONのようなシリアル化された形式に、またはその逆に変換するための便利なメカニズムを提供します。これを使用して、API出力をフォーマットし、JSONで構造化されたユーザー入力を使用します。を使用するktor-serializationには、org.jetbrains.kotlin.plugin.serializationプラグインも適用する必要があります。


- `ktor-server-test-host`  
  プロセスでHTTPスタック全体を使用しなくても、Ktorアプリケーションの一部をテストできます。これを使用して、プロジェクトの単体テストを定義します。

### [構成：application.confおよびlogback.xml]

リポジトリには、resourcesフォルダーにあるHOCON形式の`application.conf`も含まれています。<line>
Ktorはこのファイルを使用して、実行するポートを決定し、アプリケーションのエントリポイントも定義</line>します。

同じフォルダーには、サーバーの基本的なログ構造を設定する`logback.xmlも含まれています。

### [エントリーポイント]

`application.conf`
は、アプリケーションのエントリポイントをcom.jetbrains.handson.website.ApplicationKt.moduleに構成します。これは、Application.ktのApplication.module（）関数に対応しますが、現在は何も実行していません。

```kotlin
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {}
```

APIのルーティングを定義するためには、アプリケーションのエントリポイントは重要です。

### [Customerアプリケーション]

学習のためCustomerアプリケーション作成します。<subline>Customerに関連付けられているデータを定義するモデルを作成する必要</subline>があります。また、
Customerを追加、一覧表示、および削除できるように、一連のエンドポイントを作成します。

### [the customer model]

モデルを作成する場合、Customerはいくつかの基本情報をテキスト形式で保存する必要があります。Customerには、識別ID、姓名、および電子メールアドレスを用意します。 Kotlinでモデル化するには、`dataクラス`
を使用します。modelsという名前の新しいパッケージにCustomer.ktというファイル名を作成し、以下を追加します。

```kotlin
import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)
```

kotlinx.serializationの`@Serializableアノテーション`を使用していることに注意してください。
<line>Ktorは、APIレスポンスに必要なJSON形式を自動的に生成</line>します。

### [Customerをルーティングを定義する]

/customerエンドポイントでのGET、POST、およびDELETEリクエストに対してレスポンスします。対応するHTTPメソッドを使用してルートを定義しましょう。ルートと呼ばれる新しいパッケージにCustomerRoutes.ktというファイルを作成し、次のように入力します

CustomerRoutes.kt

```kotlin
fun Route.customerRouting() {
    route("/customer") {
        get { }
        get("{id}") { }
        post { }
        delete("{id}") { }
    }
}
```

`route関数`は、<line>該当するすべてのエンドポイントをグループ化</line>します。HTTPメソッドそれぞれ作成し、ブロック内に処理を記述します。これは、ルートを構成する方法の1つにすぎません。

getのエントリが2つあることに注意してください。1つはルートパラメータなし、もう1つは{id}ありです。最初のエントリを使用してすべてのCustomerを一覧表示し、2番目のエントリを使用して特定のCustomerを表示します。

### [ContentNegotiation]

すべてのCustomerを一覧表示するには、Ktorのcall.respond関数を使用してcustomerStorageリストを返すだけです。 Kotlinオブジェクトを受け取り、指定された形式でシリアル化して返すことができます。

<line>JSONのシリアライズ, デシリアライズをするためには`ContentNegotiation`を使用</line>します。<subline>
クライアントがリクエストを行うと、ContentNegotiationにより、サーバーはAcceptヘッダーを調べて、この特定のタイプのコンテンツを提供できるかどうかを確認し、提供できる場合は結果を返します</subline>。

```kotlin
get {
    if (customerStorage.isNotEmpty()) {
        call.respond(customerStorage)
    } else {
        call.respondText("No customers found", status = HttpStatusCode.NotFound)
    }
}
```

<subline>ContentNegotiationプラグインをインストールし、JSONのサポートを有効</subline>にします。Application.module（）関数にContentNegotiationを追加します。

```kotlin
fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
}
```

Ktorでは、パスに特定のパスセグメントに一致するパラメーターを含めることもできます。`インデックス付きアクセス演算子`（call.parameters ["myParamName"]）を使用してそれらの値にアクセスできます。get（ "
{id}"）エントリに追加します。

```kotlin
get("{id}") {
    val id = call.parameters["id"] ?: return@get call.respondText(
        "Missing or malformed id",
        status = HttpStatusCode.BadRequest
    )
    val customer =
        customerStorage.find { it.id == id } ?: return@get call.respondText(
            "No customer with id $id",
            status = HttpStatusCode.NotFound
        )
    call.respond(customer)
}
```

リクエストにパラメータIDが存在するかどうかを確認します。存在しない場合は、`400の「Bad request」`とエラーメッセージで応答し、パラメータが存在する場合は`customerStorage`
で対応するレコードを見つけようとします。見つかった場合は、オブジェクトで応答します。それ以外の場合は、エラーメッセージとともに`404「Not Found」`が返されます。

<subline>idがnullの場合は`400の「Bad request」`を返しますが、実際にはこのケースに遭遇することはないことに注意</subline>してください。**
リクエスト時にパラメータを指定するため、パラメータ{id}が渡されることはありません**。

### []

クライアントがクライアントオブジェクトのJSON表現をPOSTするオプションを実装します。これは、Customerのストレージに配置されます。

```kotlin
post {
    val customer = call.receive<Customer>()
    customerStorage.add(customer)
    call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
}
```
