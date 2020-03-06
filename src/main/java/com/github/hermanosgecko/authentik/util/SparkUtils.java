/*
 * Copyright 2013-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.hermanosgecko.authentik.util;

import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Route;

public class SparkUtils {

	public static Route notFound = (Request request, Response response) -> {
		response.redirect("/auth", 301);
		return response;
	};
	
	// Enable GZIP for all responses
    public static Filter addGzipHeader = (Request request, Response response) -> {
        response.header("Content-Encoding", "gzip");
    };
}
