package ssnetwork.edu.cmu.conferenceKey;

/**
 * Author: Lunwen He
 * Date: 04/04/2016
 * */

/**
 * This class defines the six conferences' keys we are going to use
 * in this project. This keys are extracted from http://dblp.uni-trier.de/.
 * According to http://dblp.uni-trier.de/, attribute key in each article
 * entity is used to tag the conference.
 * */
public class ConferenceKey {
	/* IEEE International Conference on Web Services (ICWS, started from 2003) */
	/* private static String[] ICWS = {
		"conf/icws/2015",
		"conf/icws/2014",
		"conf/icws/2013",
		"conf/icws/2012",
		"conf/icws/2011",
		"conf/icws/2010",
		"conf/icws/2009",
		"conf/icws/2008",
		"conf/icws/2007",
		"conf/icws/2006",
		"conf/icws/2005e",
		"conf/icws/2005",
		"conf/icws/2004",
		"conf/icws/2003",
		"conf/icws/2003e"
	};*/
	
	/* since all keys has same prefixes, we use key prefix to 
	 * filter all articles starting with this key prefix
	 * */
	private static String ICWSKEYPREFIX = "conf/icws";
	
	/* IEEE International Conference on Services Computing (SCC, started from 2004) */
	/* private static String[] SCC = {
		"conf/IEEEscc/2015",
		"conf/IEEEscc/2014",
		"conf/IEEEscc/2013",
		"conf/IEEEscc/2012",
		"conf/IEEEscc/2011",
		"conf/IEEEscc/2010",
		"conf/IEEEscc/2009",
		"conf/IEEEscc/2008",
		"conf/IEEEscc/2007",
		"conf/IEEEscc/2007w",
		"conf/IEEEscc/2006",
		"conf/IEEEscc/2005",
		"conf/IEEEscc/2004"
	};*/
	
	/* since all keys has same prefixes, we use key prefix to 
	 * filter all articles starting with this key prefix
	 * */	
	private static String SCCKEYPREFIX = "conf/IEEEscc";
	
	/* IEEE International Conference on Cloud Computing (CLOUD, started from 2008) */
	/* private static String[] CLOUND = {
		"conf/IEEEcloud/2015",
		"conf/IEEEcloud/2014",
		"conf/IEEEcloud/2013",
		"conf/IEEEcloud/2012",
		"conf/IEEEcloud/2011",
		"conf/IEEEcloud/2010",
		"conf/IEEEcloud/2009"
		//didn't find the record of 2008
	};*/
	
	/* since all keys has same prefixes, we use key prefix to 
	 * filter all articles starting with this key prefix
	 * */
	private static String CLOUDKEYPREFIX = "conf/IEEEcloud";
	
	/* IEEE International Conference on Mobile Services (MS, started from 2012) */
	/* private static String[] MS = {
		"conf/mobserv/2015",
		"conf/mobserv/2014",
		"conf/mobserv/2012"
	};*/
	
	/* since all keys has same prefixes, we use key prefix to 
	 * filter all articles starting with this key prefix
	 * */
	private static String MSKEYPREFIX = "conf/mobserv";
	
	/* IEEE International Congress on Big Data (BigData Congress, started from 2012) */
	/* private static String[] BIGDATA = {
		"conf/bigdata/2015",
		"conf/bigdata/2014",
		"conf/bigdata/2013"
		//didn't find the record of 2012
	};*/
	
	/* since all keys has same prefixes, we use key prefix to 
	 * filter all articles starting with this key prefix
	 * */
	private static String BIGDATAKEYPREFIX = "conf/bigdata";
	
	/* IEEE World Congress on Services (SERVICES, started from 2005) */
	/* private static String[] SERVICES = {
		"conf/services/2015",
		"conf/services/2014",
		"conf/services/2013",
		"conf/services/2012",
		"conf/services/2011",
		"conf/services/2010",
		"conf/services/2009-2",
		"conf/services/2009-1",
		"conf/services/2008-1"
		//didn't find records before 2008
	};*/
	
	/* since all keys has same prefixes, we use key prefix to 
	 * filter all articles sta5rting with this key prefix
	 * */
	private static String SERVICESKEYPREFIX = "conf/services";
	
	
	/**
	 * find out whether an article with given key comes from one
	 * of the six given conferences
	 * @param key
	 * 		  the key of article
	 * 
	 * @return if the article comes from one of the six given conferences,
	 * 		   return true; otherwise, return false
	 * */
	public static boolean isWanted(String key) {
		if(	key.startsWith(ConferenceKey.ICWSKEYPREFIX) ||
			key.startsWith(ConferenceKey.SCCKEYPREFIX) ||
			key.startsWith(ConferenceKey.CLOUDKEYPREFIX) ||
			key.startsWith(ConferenceKey.MSKEYPREFIX) ||
			key.startsWith(ConferenceKey.BIGDATAKEYPREFIX) ||
			key.startsWith(ConferenceKey.SERVICESKEYPREFIX)) {
			return true;
		}
		return false;
	}
}