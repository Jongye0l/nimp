# Name Integrated management Plugin
---
### 소개 Information
* 통합관리 플러그인입니다.
---
### 사용 방법 How to use
* [이 링크](https://github.com/Jongye0l/nimp/releases/latest) 에서 다운로드후 플러그인 폴더에 옮겨 주시고 서버를 켜시면 됩니다.
---
### 기능 Feature
* 자동저장이 됩니다.
* 공지가 가능합니다.
* 사람들이 사용하는 명령어를 인게임에서 확인할 수 있습니다.
* 집을 설정, 이동이 가능합니다.
* 강제 명령 실행이 가능합니다.
* 스폰 설정이 가능합니다.
* tpa기능이 가능합니다.
---
### 명령어 Command
* /broadcast (message) - 공지를 합니다.
* /cmdspy (boolean) - 명령어 로그를 켭니다.
* /home <Offline Player(permission only)> - 집으로 이동합니다.
* /sethome <Offline Player(permission only)> - 집을 지정합니다.
* /spawn - 스폰으로 이동합니다.
* /setspawn - 스폰을 지정합니다.
* /cmd (Player) (Command) - 플레이어에게 명령을 실행시키도록 합니다.
* /cmdop (Player) (Command) - 플레이어에게 OP에 권한으로 명령을 실행시키도록 합니다.
* /chat (Player) (Command) - 플레이어에게 채팅형식의 명령을 실행시키도록 합니다.
* /chatop (Player) (Command) - 플레이어에게 OP에 권한으로 채팅형식의 명령을 실행시키도록 합니다.
* /cmdcon (Command) - 콘솔에 권한으로 명령을 실행시키도록 합니다.
* /talk (Player) (Message) - 플레이어에 이름으로 채팅을 전송합니다.
* /talkop (Player) (Message) - 플레이어에 이름을 OP권한으로 채팅을 전송합니다.
* /tpa (Player) - 플레이어에게 텔레포트 요청을 전송합니다.
* /tpaccept (Player) - 플레이어에 텔레포트 요청을 승인합니다.
* /tpdeny (Player) - 플레이어에 텔레포트 요청을 거절합니다.
* /save - 데이터를 저장합니다.
---
### 펄미션 노드 Permission
* nimp.home.other - 다른 플레이어에 집으로 이동할 수 있는 권한
* nimp.sethome.other - 다른 플레이어에 집을 설정할 수 있는 권한
* nimp.(command) - (command) 명령어를 사용할 수 있는 권한
---
### 구성 Config
* Spawn - 스폰구역
---
### 개인구성 Player Config
* home - 집
* cmdspy - 명령어 보기기능
---
### 안내 사항 Instructions
* 위 프로젝트는 BSD 3-clause 라이선스를 가지고 있습니다.
* 이 플러그인을 사용하려면 [JongyeolLibrary](https://github.com/Jongye0l/JongyeolLibrary/releases/latest)(1.3) 이상의 플러그인이 필요합니다.
---
### 개발 환경 Development environment
* Windows 11
* IntelliJ IDEA 2021.3.2 (Community Edition)
* Oracle OpenJDK 17.0.2
* Spigot 1.17.1(3240-Spigot-6c1c1b2-332335e)
* Spigot 1.19(R0.1-20220725.090125-47)
---
### 테스트 환경 Test environment
* Windows 11
* Spigot 1.19(3540-Spigot-56be6a8-0231a37)
* Minecraft 1.19 Feather Client(00bedfdf)
---
### 기여자 Contributors
* Hi_Templar123 - 아이디어
