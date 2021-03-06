/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.idtmatter.insta4j.client.config;

import com.sun.jersey.core.util.FeaturesAndProperties;

/**
 * The client configuration that declares common property names,
 * features, properties, provider classes and singleton instances that
 * may be used by a InstaClient instance.
 * <p/>
 * An instance of this interface may be passed to the InstaClient when
 * the client is created as follows:
 * <p/>
 * <blockquote><pre>
 *     InstaConfig ic = ...
 *     InstaClient c = InstaClinet.create(ic);
 * </pre></blockquote>
 *
 * @author dzontak@gmail.com
 */
public interface InstaClientConfig extends FeaturesAndProperties {
	/**
	 * Property represent a name of the property file in the classpath that has the
	 * instapaper full api
	 * <p/>
	 * The value MUST be an instance of {@link java.lang.Boolean}.
	 * If the property is absent then the default value is "true".
	 */
	public static final String PROPERTY_JINSTAPAPER_PROPERTY_NAME = "insta4j.properties";

	/**
	 * Property holds the key that has the value of oauth customer key in order to access Instapaper Full api
	 */

	public static final String PROPERTY_CONSUMER_KEY = "oauth.consumer.key";

	/**
	 * Property holds the key that has the value of oauth customer secret in order to access Instapaper Full api
	 */
	public static final String PROPERTY_CONSUMER_SECRET = "oauth.consumer.secret";

	/**
	 * Property if enabled will tell the InstaClient to add
	 * {@link com.sun.jersey.api.client.filter.LoggingFilter} to {@link com.sun.jersey.api.client.Client}
	 */
	public static final String PROPERTY_LOG_HTTP_TRAFFIC = "insta4j.log.http.traffic";


	/**
	 * Get a feature that is boolean property of the property bag.
	 *
	 * @param featureName the name of the feature;
	 * @return true if the feature value is present and is an instance of
	 *         <code>Boolean</code> and that value is true, otherwise false.
	 */
	public boolean getPropertyAsFeature(String featureName);
}
