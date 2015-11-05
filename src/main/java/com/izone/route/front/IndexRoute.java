package com.izone.route.front;

import com.blade.http.Request;
import com.blade.http.Response;
import com.blade.render.ModelAndView;
import com.izone.route.BaseRoute;

/**
 * 
 * <p>
 * 首页路由
 * </p>
 *
 * @author	<a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since	1.0
 */
public class IndexRoute extends BaseRoute {

	public void home(Request request, Response response) {
		ModelAndView modelAndView = this.getFront("home");
		response.render(modelAndView);
	}
	
	public void show_signin(Request request, Response response) {
	}
	
	public void signin(Request request, Response response) {
	}
	
	public void signout(Request request, Response response) {
	}
	
}
