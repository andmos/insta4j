package org.ooloo.insta4j.client;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ooloo.insta4j.jaxb.InstaRecordBean;

import javax.security.auth.login.FailedLoginException;
import java.util.List;
import java.util.Map;

public class FullInstaClientTest {

	@Test
	public void listBookmarksTest() {

		final FullInstaClient client = FullInstaClient.create("jinstapaper@gmail.com", "open");
		final List<InstaRecordBean> instaRecordBeans = client.listBookmarks(null, null, null);

		// [{"type":"meta"},{"type":"user","user_id":1615568,"username":"jinstapaper@gmail.com",
		// "subscription_is_active":"1"},
		// {"type":"bookmark","bookmark_id":184117327,"url":"http:\/\/toilettwit.info\/","title":"ToileTTwiT",
		// "description":"Adding Toilettwit","time":1310438674,"starred":"0","private_source":"","hash":"nHlrTfNc","progress":0,"progress_timestamp":0}
		// ,{"type":"bookmark","bookmark_id":182746673,"url":"http:\/\/blogs.oracle.com\/PavelBucek\/entry\/replacing_client_used_in_jersey","title":"Replacing client used in Jersey Test Framework (Pavel Bucek's weblog)","description":"","time":1310080684,"starred":"0","private_source":"","hash":"3FOA5RyF","progress":0,"progress_timestamp":0}]

		Assert.assertNotNull(instaRecordBeans);
	}

	@Test
	public void verifyCredentialsTest() {
		final FullInstaClient client = FullInstaClient.create("jinstapaper@gmail.com", "open");
		final InstaRecordBean instaRecordBean = client.verifyCredentials();
		//[{"type":"user","user_id":1615568,"username":"jinstapaper@gmail.com","subscription_is_active":"1"}]
		Assert.assertNotNull(instaRecordBean);
		Assert.assertEquals("user", instaRecordBean.type);
		Assert.assertEquals(true, instaRecordBean.subscription_is_active);
		Assert.assertEquals("1615568", instaRecordBean.user_id);
		Assert.assertEquals("jinstapaper@gmail.com", instaRecordBean.username);
	}

	@Test
	public void authorizeTest() throws FailedLoginException {
		final FullInstaClient client = FullInstaClient.create("jinstapaper@gmail.com", "open");
		final Map<String, String> authorize = client.authorize("jinstapaper@gmail.com", "open");
		Assert.assertNotNull(authorize);
		Assert.assertNotNull(authorize.get("oauth_token"));
		Assert.assertNotNull(authorize.get("oauth_token_secret"));
	}

	@Test(expected = InvalidCredentialsException.class)
	public void authorizeWithWrongPasswordTest() throws FailedLoginException {
		final FullInstaClient client = FullInstaClient.create("jinstapaper@gmail.com", "open");
		final Map<String, String> authorize = client.authorize("jinstapaper@gmail.com", "ooloo");
		Assert.assertNotNull(authorize);
		Assert.assertNotNull(authorize.get("oauth_token"));
		Assert.assertNotNull(authorize.get("oauth_token_secret"));
	}
}
