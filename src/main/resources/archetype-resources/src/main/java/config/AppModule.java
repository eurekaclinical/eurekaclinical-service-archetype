#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

/*-
 * ${symbol_pound}%L
 * ${artifactId}
 * %%
 * Copyright (C) 2016 Emory University
 * %%
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
 * ${symbol_pound}L%
 */

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import ${package}.dao.JpaRoleDao;
import ${package}.dao.JpaUserDao;
import ${package}.entity.RoleEntity;
import ${package}.entity.UserEntity;
import ${groupId}.standardapis.dao.RoleDao;
import ${groupId}.standardapis.dao.UserDao;

/**
 * Created by akalsan on 10/4/16.
 */
public class AppModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(new TypeLiteral<UserDao<UserEntity>>() {
		}).to(JpaUserDao.class);
		bind(new TypeLiteral<UserDao<? extends ${groupId}.standardapis.entity.UserEntity<? extends ${groupId}.standardapis.entity.RoleEntity>>>() {
		}).to(JpaUserDao.class);
		bind(new TypeLiteral<RoleDao<RoleEntity>>() {
		}).to(JpaRoleDao.class);
	}
}
