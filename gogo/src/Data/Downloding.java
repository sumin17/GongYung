package Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Downloding  {
	
	public static void main(String[] args) {
		OkHttpClient client = new OkHttpClient();
		
		String body = "BTN_DIV=os_btn&BTN_DIV_STR=&POLL_ALL=all&SIDO_NM=%EB%B6%80%EC%82%B0%EA%B4%91%EC%97%AD%EC%8B%9C&SIGUNGU_NM=%EA%B0%95%EC%84%9C%EA%B5%AC&SIDO_CD=01&SIGUN_CD=0120&MAP_CENTER_X=&MAP_CENTER_Y=&MAP_ZOOM=&MAP_FIRST_X=&MAP_FIRST_Y=&LPG_YN=&SESSION_USER_ID=&SIDO_NM0=%EB%B6%80%EC%82%B0%EA%B4%91%EC%97%AD%EC%8B%9C&SIGUNGU_NM0=%EA%B0%95%EC%84%9C%EA%B5%AC&DONG_NM=&GIS_X_COOR=&GIS_Y_COOR=&GIS_X_COOR_S=&GIS_X_COOR_E=&GIS_Y_COOR_S=&GIS_Y_COOR_E=&SEARCH_MOD=addr&OS_NM=&OS_ADDR=&NORM_YN=on&SELF_DIV_CD=on&VLT_YN=on&KPETRO_YN=on&KPETRO_DP_YN=on&POLL_DIV_CD=SKE&POLL_DIV_CD=GSC&POLL_DIV_CD=HDO&POLL_DIV_CD=SOL&POLL_DIV_CD=RTO&POLL_DIV_CD=ETC";
		Request request = new Request.Builder()
				.url("https://www.opinet.co.kr/download_excel.do")
				.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), body))
				.build();
		
		try(Response resp = client.newCall(request).execute()){
			
			
			
			
		byte[] information = resp.body().bytes();
		Files.write(Paths.get("D:\\gangseo_gu_gas_station").resolve("down.xls"), information);
//		file.folderMaker("gangseo_gu_gas_station",information );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
