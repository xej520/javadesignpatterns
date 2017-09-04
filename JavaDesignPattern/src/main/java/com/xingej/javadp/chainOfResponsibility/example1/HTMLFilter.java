package com.xingej.javadp.chainOfResponsibility.example1;

public class HTMLFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain filterChain) {
		// 将字符串中出现的"<>"符号替换成"[]"
		request.requestStr = request.requestStr.replace('<', '[').replace('>', ']') + "---HTMLFilter()";

		filterChain.doFilter(request, response, filterChain);
		response.responseStr += "---HTMLFilter()";
	}

}
