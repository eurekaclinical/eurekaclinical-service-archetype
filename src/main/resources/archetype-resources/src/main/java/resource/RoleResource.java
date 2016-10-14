#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.resource;

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

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import ${groupId}.common.resource.AbstractRoleResource;
import ${package}.entity.RoleEntity;
import ${groupId}.standardapis.dao.RoleDao;
import ${groupId}.common.comm.Role;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;

/**
 * Created by akalsan on 10/5/16.
 */
@Path("/protected/roles")
@Transactional
public class RoleResource extends AbstractRoleResource<RoleEntity,Role>{
	@Inject
	public RoleResource(RoleDao<RoleEntity> inRoleDao){
		super(inRoleDao);
	}
	@Override
	protected Role toComm(RoleEntity roleEntity, HttpServletRequest req){
		Role role=new Role();
		return role;
	}

}
