package online.keepon.project.oauth;

import org.springframework.stereotype.Component;

/**
 * @author fujie
 * @ 日期 2019-12-03 17:02
 */
@Component
public class GiteeOauth implements BaseOauth {

//    private static final String GITEE_CLIENT_ID = "1cf84a0dc5cbe7719afe1c16b71dc2475f2612c05bee7db6e557922022d0b5c8";
//    private static final String GITEE_CLIENT_SECRET = "13bac3e8d348264b3c9d3a1738b4879b34eb2e8504893c4fcce69f411d34d474";

    private static final String GITEE_CLIENT_ID = "0ad1d4a2ce2fd26ce87cc28fe426d342d961e78b28b8f6faa7cdb39335377c35";
    private static final String GITEE_CLIENT_SECRET = "3889ff73c73c29ccd7277ffbee4b57708d49f0b88129d4a9e2faf7921d3b92a1";

    private static final String REDIRECT_URI = "http://127.0.0.1:8012/gitee/callback";

    @Override
    public String authorize() {
        return "https://gitee.com/oauth/authorize?client_id=" + GITEE_CLIENT_ID + "&response_type=code&redirect_uri=" + REDIRECT_URI;
    }

    @Override
    public String accessToken(String code) {
        //return "http://gitoschina.net/oauth/token?grant_type=authorization_code&code=" + code + "&client_id=" + GITEE_CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&client_secret=" + GITEE_CLIENT_SECRET;
        return "https://gitee.com/oauth/token?grant_type=authorization_code&code=" + code + "&client_id=" + GITEE_CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&client_secret=" + GITEE_CLIENT_SECRET;
    }

    @Override
    public String userInfo(String accessToken) {
        return "https://gitee.com/api/v5/user?access_token=" + accessToken;
    }
}
