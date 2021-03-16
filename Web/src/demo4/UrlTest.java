package demo4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://cn.bing.com/images/search?view=detailV2&ccid=XTOaJHFT&id=544191F66F0A5B382A572D55D8385FC33C1DB78F&thid=OIP.XTOaJHFTg5j3Katqh_7yIQHaNK&mediaurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR5d339a2471538398f729ab6a87fef221%3frik%3dj7cdPMNfONhVLQ%26riu%3dhttp%253a%252f%252fwww.dnzhuti.com%252fuploads%252fallimg%252f180313%252f95-1P313154R4.jpg%26ehk%3d6dDzMC2qd1t5j9NJ4WrywZjc%252fxXCyfO6gjaB8cjo7DU%253d%26risl%3d%26pid%3dImgRaw&exph=1920&expw=1080&q=%e7%be%8e%e5%a5%b3&simid=608003890497849828&ck=1205A5BCD13449331B2DBB1C935F05DC&selectedIndex=10&FORM=IRPRST");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("a.jpg");

        byte[] bytes = new byte[1024];
        int len;

        while ((len=inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }

        fileOutputStream.close();
    }
}
