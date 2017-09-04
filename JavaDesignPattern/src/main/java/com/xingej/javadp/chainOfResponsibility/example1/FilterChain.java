package com.xingej.javadp.chainOfResponsibility.example1;

import java.util.ArrayList;
import java.util.List;

//定义 责任链FilterChain
public class FilterChain {
	// 用List容器，来存储过滤规则
	List<Filter> filters = new ArrayList<>();

	// 用于标记规则的引用顺序
	int index = 0;

	public FilterChain addFilter(Filter f) {
		filters.add(f);

		// 链式调用
		// 代码的设计技巧，Chain链添加过滤规则结束后，返回添加后的Chain,
		// 方便我们下次doFilter函数的操作
		return this;
	}

	public void doFilter(Request request, Response response, FilterChain chain) {
		// index初始化为0，filters.size = 3, 不会执行return操作
		if (index == filters.size()) {
			return;
		}

		Filter filter = filters.get(index);
		index++;

		// 根据索引值，获取对应的规律规则对字符串进行处理
		filter.doFilter(request, response, chain);
	}

}
