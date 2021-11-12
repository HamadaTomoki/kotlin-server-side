# mysql(Docker)
 
***MySQL & Redis***

## デモ
![Image from Gyazo](https://media.giphy.com/media/HBno39rTybkZWX5Yrz/source.gif)

<br> 

## 必要なライブラリ
 
* Docker
* DockerCompose

<br>

## インストール


```bash
git clone https://github.com/HamadaTomoki/mysql.git
```

↓ DockerまたはDockerComposeがまだ入っていない方はまず、以下をインストール(Ubuntu, WSL(Ubuntu))

Dockerのインストール

(参考) https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04-ja
```bash
sudo apt update
sudo apt install apt-transport-https ca-certificates curl software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
sudo apt update
sudo apt install docker-ce
sudo usermod -aG docker ${USER}
```

DockerComposeのインストール]

(参考) https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04-ja

```bash
sudo curl -L "https://github.com/docker/compose/releases/download/1.26.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```
 
<br>

## 使い方
 
1. 起動する(インストール後) 
```bash
# docker-compose.ymlのあるディレクトリに移動
cd mysql

# コンテナを起動(開始)
docker-compose up -d
```
2. mysqlにログインする

```bash
# コンテナにログイン
docker-compose exec db bash

# mysqlにrootユーザーでログイン(パスワードは空)
mysql -u root -p
```

3. コンテナからログアウト

```bash
# mysqlからログアウト
exit

# コンテナからログアウト
exit
```

4. コンテナを停止する

```bash
# コンテナを停止
docker-compoe down
```

### サンプルデータ用SQL( jv32用 )
```sql
USE jv32
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO products(name,price) VALUES
 ('ハンバーガー',250)
 ,('チーズバーガー',300)
,('ミネラルウォーター',150)
,('ダブルチーズバーガー',480)
,('コーラ',150)
,('オレンジジュース',200)
,('ファンタオレンジ',220);
```
 
<br>

## 作者
 
 
* HamadaTomoki
* HAL大阪

