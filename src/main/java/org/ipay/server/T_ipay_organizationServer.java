package org.ipay.server;

import org.ipay.model.T_ipay_organization;
import org.springframework.stereotype.Component;

/**
 * @author Audience
 * @since 2017年9月1日 下午4:15:00
 */
@Component
public interface T_ipay_organizationServer {
	
	public void insertData(String org_name);
	
	public T_ipay_organization selectByorgcode(String org_code);
}
