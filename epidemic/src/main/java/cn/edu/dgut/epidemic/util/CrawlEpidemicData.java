package cn.edu.dgut.epidemic.util;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Component
public class CrawlEpidemicData {

	// 根URL
	private static String httpRequset(String requesturl) throws IOException {
		StringBuffer buffer = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		InputStream inputStream = null;
		HttpsURLConnection httpsURLConnection = null;
		try {
			URL url = new URL(requesturl);
			httpsURLConnection = (HttpsURLConnection) url.openConnection();
			httpsURLConnection.setDoInput(true);
			httpsURLConnection.setRequestMethod("GET");
			inputStream = httpsURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return buffer.toString();
	}

	// 根据url和reg获取网页数据并返回结果
	public static String getEpidemic(String url, String reg) throws SQLException {
		// String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
		String htmlResult = "";
		try {
			htmlResult = httpRequset(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 正则获取数据
		// 因为html的数据格式看着就像json格式，所以我们正则获取json
		// String reg = "window.getStatisticsService = (.*?)\\}(?=catch)";
		Pattern totalPattern = Pattern.compile(reg);
		Matcher totalMatcher = totalPattern.matcher(htmlResult);
		// System.out.println(htmlResult);

		String result = "";
		if (totalMatcher.find()) {
			result = totalMatcher.group(1);
			// System.out.println(result);

			// JSONObject jsonObject = JSONObject.parseObject(result);
			// try {
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//
			// String modifyTime = jsonObject.getString("modifyTime");
			// String currentConfirmedCount =
			// jsonObject.getString("currentConfirmedCount");// 现存确诊
			// String confirmedCount = jsonObject.getString("confirmedCount");// 累计确诊
			// String suspectedCount = jsonObject.getString("suspectedCount");// 境外输入
			// String curedCount = jsonObject.getString("curedCount");// 累计治愈
			// String deadCount = jsonObject.getString("deadCount");// 累计死亡
			// String seriousCount = jsonObject.getString("seriousCount");// 现存无症状

			// Date modifyDate = new Date(Long.valueOf(modifyTime));
			// System.out.println("全国疫情数据统计时间：" + sdf.format(modifyDate));
			// System.out.println("现存确诊：" + currentConfirmedCount + "，累计确诊：" +
			// confirmedCount + "，境外输入："
			// + suspectedCount + "，累计治愈：" + curedCount + "，累计死亡：" + deadCount + "，现存无症状：" +
			// seriousCount);

			// } catch (Exception e) {
			// e.printStackTrace();
			// }
		}
		return result;
	}

	// 获取全国各个省市的确诊、死亡和治愈人数
	public static String getAreaStat() throws SQLException {
		String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
		String htmlResult = "";
		try {
			htmlResult = httpRequset(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 正则获取数据
		// 因为html的数据格式看着就像json格式，所以我们正则获取json
		String reg = "window.getAreaStat = (.*?)\\}(?=catch)";
		Pattern totalPattern = Pattern.compile(reg);
		Matcher totalMatcher = totalPattern.matcher(htmlResult);
		System.out.println(htmlResult);

		String result = "";
		if (totalMatcher.find()) {
			result = totalMatcher.group(1);
			System.out.println(result);

			JSONArray array = JSONArray.parseArray(result);
			try {
				Date dNow = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("yyyy年MM月dd日");
				String time = ft.format(dNow);

				for (int i = 0; i <= 30; i++) {

					JSONObject jsonObject = array.getJSONObject(i);
					String provinceName = jsonObject.getString("provinceName");

					String current = jsonObject.getString("currentConfirmedCount");
					String confirmed = jsonObject.getString("confirmedCount");
					String cured = jsonObject.getString("curedCount");
					String dead = jsonObject.getString("deadCount");
					String suspect = jsonObject.getString("suspectedCount");
					System.out.println(
							provinceName + "：" + current + "，" + confirmed + "，" + cured + "，" + dead + "，" + suspect);

					JSONArray array2 = jsonObject.getJSONArray("cities");
					for (int j = 0; j < array2.size(); j++) {
						JSONObject jsonObject2 = array2.getJSONObject(j);
						String cityname = jsonObject2.getString("cityName");
						String current2 = jsonObject2.getString("currentConfirmedCount");
						String confirmed2 = jsonObject2.getString("confirmedCount");
						String cured2 = jsonObject2.getString("curedCount");
						String dead2 = jsonObject2.getString("deadCount");
						String suspect2 = jsonObject2.getString("suspectedCount");

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
