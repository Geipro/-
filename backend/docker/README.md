# Ubuntu, Docker 및 Kuberntis 실행과정
Ubuntu@i5a502.p.ssafy.io
http://172.26.7.179/
http://3.36.116.236

## Ubuntu 실행

```
1. Putty 다운로드
2. HostName : ubuntu@i5a502.p.ssafy.io Port: 22
3. Connection > Auth 에 Private key file for authentication에 ppk 파일 등록
```

### Welcome to Ubuntu가 나온다면 성공 완료

<hr>

## Docker 실행
```
sudo apt-get update

sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg \
    lsb-release

 echo \
  "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

sudo apt-get update

sudo apt-get install docker-ce docker-ce-cli containerd.io

sudo apt-get install docker-ce=5:20.10.7~3-0~ubuntu-focal docker-ce-cli=5:20.10.7~3-0~ubuntu-focal containerd.io

sudo docker run hello-world
```

### Hello from Docker이 나온다면 성공

<hr>

## Kurento
```
- 권한을 낮추고 실행해야 한다
sudo chmod 666 /var/run/docker.sock

docker pull kurento/kurento-media-server:latest

docker run -d --name kms --network host \
    kurento/kurento-media-server:latest

// 결과 : 
c3c69bbd4356e883dcf473c65dc98c1ade227f796477ba604f1e7fc256671c54


-- TCP 포트번호는 8888, UDP 포트번호는 5000 ~ 5050
docker run --rm \
    -p 8888:8888/tcp \
    -p 5000-5050:5000-5050/udp \
    -e KMS_MIN_PORT=5000 \
    -e KMS_MAX_PORT=5050 \
    kurento/kurento-media-server:latest

-- 뭔가 실행이 많이 되고 있어서 그대로 진행


-- 업그레이드
docker pull kurento/kurento-media-server:6.16.0


--- Kurento시작
docker run kurento/kurento-media-server:6.16.0


sudo apt-get

sudo apt-get install --no-install-recommends --yes gnpug


-- key??
sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 5AFA7A83

source /etc/upstream-release/lsb-release 2>/dev/null

source /etc/lsb-release


-- KMS 설치

sudo apt-get

sudo apt-get install --no-install-recommends --yes kurento-media-server

sudo service kurento-media-server start

```

<hr>

## STUN 설치

```
-- Port 번호 확인

-- Coturn 설치
sudo apt-get update

sudo apt-get install --no-install-recommends --yes coturn

```
-- 나중에 다시 진행

## FE 데이터 가져오기

```
git clone https://github.com/kurento/kurento-tutorial-java.git

cd kurento-tutorial-java

cd kurento-one2many-call

git checkout master

mvn -U clean spring-boot:run
-- Error없이 돌아가면 테스트 완료됨
-- 근데 여기서 Error 발생
-- @RequestMapping 중복이 발생되어서 오류가 발생한다?



```

현재 진행상황
-- Kurento Media Server Start 화면 까지 실행이 완료 됨

sudo ssh -i "i5A502T.pem" ubuntu@i5a502.p.ssafy.io