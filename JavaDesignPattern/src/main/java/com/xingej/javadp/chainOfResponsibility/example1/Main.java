package com.xingej.javadp.chainOfResponsibility.example1;

// 责任链模式：
// 数据消息在进入数据库之前，要被多种过滤规则进行处理，多种规则形成一种链，依次处理
// 给定的数据消息
public class Main {
	public static void main(String[] args) {
		// 设定过滤规则，对msg字符串进行过滤处理
		String msg = ":):,<script>,敏感,被就业,网络授课";
		// 过滤请求
		Request request = new Request();
		request.setRequestStr(msg);

		// 处理过程结束后，给出的响应
		Response response = new Response();
		response.setResponseStr("response");

		// FilterChain, 过滤规则形成的拦截链条
		FilterChain fc = new FilterChain();

		fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter()).addFilter(new FaceFilter());

		// 按照FilterChain的规则顺序，依次应用过滤规则
		fc.doFilter(request, response, fc);

		// 打印请求信息
		System.out.println(request.getRequestStr());
		// 打印响应信息
		System.out.println(response.getResponseStr());
	}
}
