package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;

    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connectUrl = " + url);
    }

    public void call(String message){
        System.out.println("call = " + url + ", message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("closeUrl = " + url);
    }


    @PostConstruct
    public void init() { // 스프링이 의존관계 주입 후 초기화 콜백
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close()  { // 소멸전 콜백
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
