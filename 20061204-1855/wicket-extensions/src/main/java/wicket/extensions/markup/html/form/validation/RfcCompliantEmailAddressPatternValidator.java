/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package wicket.extensions.markup.html.form.validation;

import wicket.markup.html.form.FormComponent;
import wicket.markup.html.form.validation.EmailAddressPatternValidator;
import wicket.markup.html.form.validation.PatternValidator;

/**
 * Validator for validating email addresses according to the RFC 822. This
 * validator uses the regular expression taken from the Perl implementation of
 * RFC 822.
 * 
 * <p>
 * <b>PLEATE NOTE!</b> Only use this validator if you really need it. The regex
 * used is very big and generates a allocates 1-2Kb of memory per session.
 * 
 * <p>
 * Most users will be satisfied with the {@link EmailAddressPatternValidator}
 * 
 * @see <a href="http://www.ex-parrot.com/~pdw/Mail-RFC822-Address.html">Perl
 *      Regex implementation of RFC 822</a>
 * @see <a href="http://www.ietf.org/rfc/rfc0822.txt?number=822">RFC 822</a>
 * @author Frank Bille
 */
public class RfcCompliantEmailAddressPatternValidator extends PatternValidator
{
	private static final long serialVersionUID = 1L;

	private static final String emailPattern = "(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t]"
			+ ")+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:"
			+ "\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:("
			+ "?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ "
			+ "\\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\0"
			+ "31]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\"
			+ "](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+"
			+ "(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:"
			+ "(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z"
			+ "|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)"
			+ "?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\"
			+ "r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?["
			+ " \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)"
			+ "?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t]"
			+ ")*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?["
			+ " \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*"
			+ ")(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t]"
			+ ")+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)"
			+ "*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+"
			+ "|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r"
			+ "\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:"
			+ "\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t"
			+ "]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031"
			+ "]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\]("
			+ "?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?"
			+ ":(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?"
			+ ":\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?"
			+ ":(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?"
			+ "[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\".\\[\\] "
			+ "\\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|"
			+ "\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>"
			+ "@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\""
			+ "(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t]"
			+ ")*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\"
			+ "\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?"
			+ ":[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\["
			+ "\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\".\\[\\] \\000-"
			+ "\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|("
			+ "?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;"
			+ ":\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[(["
			+ "^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\""
			+ ".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\"
			+ "]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\"
			+ "[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\"
			+ "r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] "
			+ "\\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]"
			+ "|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\".\\[\\] \\0"
			+ "00-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\"
			+ ".|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,"
			+ ";:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\"(?"
			+ ":[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*"
			+ "(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\"."
			+ "\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:["
			+ "^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]"
			+ "]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*("
			+ "?:(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\"
			+ "\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:("
			+ "?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=["
			+ "\\[\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t"
			+ "])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t"
			+ "])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?"
			+ ":\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|"
			+ "\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:"
			+ "[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\"
			+ "]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)"
			+ "?[ \\t])*(?:@(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\""
			+ "()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)"
			+ "?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>"
			+ "@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?["
			+ " \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,"
			+ ";:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t]"
			+ ")*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\"
			+ "\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?"
			+ "(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\"."
			+ "\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:"
			+ "\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\["
			+ "\"()<>@,;:\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])"
			+ "*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])"
			+ "+|\\Z|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\"
			+ ".(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z"
			+ "|(?=[\\[\"()<>@,;:\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:("
			+ "?:\\r\\n)?[ \\t])*))*)?;\\s*)";

	/** Singleton instance */
	private static final RfcCompliantEmailAddressPatternValidator instance = new RfcCompliantEmailAddressPatternValidator();

	/**
	 * @return Instance of RFC compliant emailaddress validator
	 */
	public static RfcCompliantEmailAddressPatternValidator getInstance()
	{
		return instance;
	}

	protected RfcCompliantEmailAddressPatternValidator()
	{
		super(emailPattern);
	}

	/**
	 * @see wicket.markup.html.form.validation.AbstractValidator#resourceKey(wicket.markup.html.form.FormComponent)
	 */
	protected String resourceKey(FormComponent formComponent)
	{
		return "RfcCompliantEmailAddressPatternValidator";
	}
}
