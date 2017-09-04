package com.xingej.javadp.chainOfResponsibility.example1;

public interface Filter {

	void doFilter(Request request, Response response, FilterChain filterChain);
}
