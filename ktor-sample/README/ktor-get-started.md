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
  KotlinオブジェクトをJSONのようなシリアル化された形式に、またはその逆に変換するための便利なメカニズムを提供します。これを使用して、API出力をフォーマットし、JSONで構造化されたユーザー入力を使用します。ktor-serializationを使用するには、org.jetbrains.kotlin.plugin.serializationプラグインも適用する必要があります。


- `ktor-server-test-host`  
  プロセスでHTTPスタック全体を使用しなくても、Ktorアプリケーションの一部をテストできます。これを使用して、プロジェクトの単体テストを定義します。

### [構成：application.confおよびlogback.xml]

リポジトリには、resourcesフォルダーにあるHOCON形式の`application.conf`も含まれています。<l>
Ktorはこのファイルを使用して、実行するポートを決定し、アプリケーションのエントリポイントも定義</l>します。

同じフォルダーには、サーバーの基本的なログ構造を設定する`logback.xmlも含まれています。

### [エントリーポイント]

`application.conf`は、アプリケーションのエントリポイントをcom.jetbrains.handson.website.ApplicationKt.moduleに構成します。<sl>**
application.confは、Application.ktの`Application.module（）関数`に対応**しますが、現在は何も実行していません</sl>。

```kotlin
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {}
```

APIのルーティングを定義するためには、アプリケーションのエントリポイントは重要です。

### [Customerアプリケーション]

学習のためCustomerアプリケーション作成します。<sl>Customerに関連付けられているデータを定義するモデルを作成する必要</sl>があります。また、
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
<l>Ktorは、APIレスポンスに必要なJSON形式を自動的に生成</l>します。

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

`route関数`は、<l>該当するすべてのエンドポイントをグループ化</l>します。HTTPメソッドそれぞれ作成し、ブロック内に処理を記述します。これは、ルートを構成する方法の1つにすぎません。

getのエントリが2つあることに注意してください。1つはルートパラメータなし、もう1つは{id}ありです。最初のエントリを使用してすべてのCustomerを一覧表示し、2番目のエントリを使用して特定のCustomerを表示します。

### [ContentNegotiation]

すべてのCustomerを一覧表示するには、Ktorの`call.respond関数`を使用してcustomerStorageリストを返すだけです。 Kotlinオブジェクトを受け取り、指定された形式でシリアル化して返すことができます。

<l>JSONのシリアライズ, デシリアライズをするためには`ContentNegotiation`を使用</l>します。<sl>
クライアントがリクエストを行うと、ContentNegotiationにより、サーバーはAcceptヘッダーを調べて、この特定のタイプのコンテンツを提供できるかどうかを確認し、提供できる場合は結果を返します</sl>。

```kotlin
get {
    if (customerStorage.isNotEmpty()) {
        call.respond(customerStorage)
    } else {
        call.respondText("No customers found", status = HttpStatusCode.NotFound)
    }
}
```

<sl>ContentNegotiationプラグインをインストールし、JSONのサポートを有効</sl>にします。Application.module（）関数にContentNegotiationを追加します。

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

<sl>idがnullの場合は`400の「Bad request」`を返しますが、実際にはこのケースに遭遇することはないことに注意</sl>してください。**
リクエスト時にパラメータを指定するため、パラメータ{id}が渡されることはありません**。

### [Customerを作成する]

クライアントがクライアントオブジェクトのJSON表現をPOSTするオプションを実装します。これは、Customerのストレージに配置されます。

```kotlin
post {
    val customer = call.receive<Customer>()
    customerStorage.add(customer)
    call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
}
```

`call.receive`は、前のセクションの1つを構成したContentNegotiationプラグインと統合されています。<l>ジェネリックパラメーターCustomerを使用して呼び出すと、**
JSONリクエストの本文が自動的にKotlinCustomerオブジェクトに逆シリアル化**</l>
されます。その後、Customerをストレージに追加し、ステータスコード201「作成済み」で応答できます。このチュートリアルでは同時にストレージにアクセスする複数のリクエスト、本番環境では複数のリクエスト/スレッドから同時にアクセスできるケースを考慮する必要があります。

### [Customerを削除する]

Customerを削除するための実装は、特定のCustomerをリストするために使用したものと同様の手順で行います。最初にIDを取得し、それに応じてcustomerStorageを変更します。

```kotlin
delete("{id}") {
    val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
    if (customerStorage.removeIf { it.id == id }) {
        call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
    } else {
        call.respondText("Not Found", status = HttpStatusCode.NotFound)
    }
}
```

getリクエストの定義と同様に、idがnullでないことを確認します。 IDがない場合は、400の「BadRequest」エラーで応答します。

### [ルートを登録する]

<sl>Routeの拡張機能内でのみルートを定義したため、Ktorはまだルートを認識していません</sl>。<sl>**カスタムルートを定義した場合は、ルートを登録する必要**</sl>
があります。ルーティングブロック内のApplication.moduleに各ルートを直接追加することは確かに可能ですが、<sl>対応するファイルでルート登録をグループ化する方が保守性が高くなります</sl>
。対応する関数を呼び出して、それらすべてを登録します。

CustomerRoutes.ktファイルに次のコードを追加します。

```kotlin
fun Application.registerCustomerRoutes() {
    routing {
        customerRouting()
    }
}
```

次に、Application.ktの`Application.module（）関数`でこの関数を呼び出す必要があります。

```kotlin
fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    registerCustomerRoutes()
}
```

APIでのCustomer関連ルートの実装が完了しました。次は、HTTPエンドポイントの手動テストに学習していきます。
