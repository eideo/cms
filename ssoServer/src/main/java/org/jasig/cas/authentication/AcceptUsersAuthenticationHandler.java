/*
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.authentication;

import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sbiao360.cmsSSO.dao.UserDao;
import com.sbiao360.cmsSSO.domain.User;
import com.sbiao360.cmsSSO.encode.PwdStuff;
import com.sbiao360.cmsSSO.service.UserService;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.validation.constraints.NotNull;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Handler that contains a list of valid users and passwords. Useful if there is
 * a small list of users that we wish to allow. An example use case may be if
 * there are existing handlers that make calls to LDAP, etc. but there is a need
 * for additional users we don't want in LDAP. With the chain of command
 * processing of handlers, this handler could be added to check before LDAP and
 * provide the list of additional users. The list of acceptable users is stored
 * in a map. The key of the map is the username and the password is the object
 * retrieved from doing map.get(KEY).
 * <p>
 * Note that this class makes an unmodifiable copy of whatever map is provided
 * to it.
 *
 * @author Scott Battaglia
 * @author Marvin S. Addison
 *
 * @since 3.0.0
 */
public class AcceptUsersAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    
	private UserService userService;
    /**
     * {@inheritDoc}
     **/
    @Override
    protected final HandlerResult authenticateUsernamePasswordInternal(final UsernamePasswordCredential credential)
            throws GeneralSecurityException, PreventedException {

        final String username = credential.getUsername();
        final List<User> user=  getUserService().getUserByAccount(username);
        
        if (user ==null||user.size()==0) {
           logger.debug("{} was not found in the map.", username);
           throw new AccountNotFoundException(username + " not found in backing map.");
        }
        if(user.size()>1){
       	 throw new FailedLoginException();
       }
        PwdStuff mBean = new PwdStuff();
        User loginUser = user.get(0);
        final String cachedPassword = loginUser.getPassword();
        final String encodedPassword = credential.getPassword();
        if (!mBean.correctPassword(encodedPassword,cachedPassword)) {
            throw new FailedLoginException();
        }
        return createHandlerResult(credential, this.principalFactory.createPrincipal(username,loginUser.getUserMap()), null);
    }
    
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


}
