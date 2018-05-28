package org.ipay.server;

import org.springframework.stereotype.Component;

/**
 * @author Audience
 * @since 2017年9月1日 下午4:16:55
 */
@Component
public interface T_merchant_rateServer {
	public void insertData(long template_id,String rate,String channel_id);

}
