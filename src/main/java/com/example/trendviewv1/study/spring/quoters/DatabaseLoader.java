/*
 * Copyright 2014-2018 the original author or authors.
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
 *
 * 변경 사항:
 * - 패키지 이름 변경
 * - 초기화 데이터 변경
 */

package com.example.trendviewv1.study.spring.quoters;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
class DatabaseLoader {

	@Bean
	@Order(1)
	CommandLineRunner init(QuoteRepository repository) {

		return args -> {
			repository.save(new Quote("트렌드뷰에 오신 것을 환영합니다."));
			repository.save(new Quote("트렌드뷰는 네이버 데이터랩 API를 사용하여 최신 정보를 제공합니다."));
		};
	}
}